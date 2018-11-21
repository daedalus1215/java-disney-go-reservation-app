package disney.reservation.notification.WebPageEssentials;


import disney.reservation.notification.Adapter.Logger.InfoLoggerAdapter;
import disney.reservation.notification.Adapter.MailerAdapter;
import disney.reservation.notification.WebPageEssentials.Reference.HtmlElementReferrer;
import disney.reservation.notification.WebPageEssentials.Requestor.PageRequestor;
import com.gargoylesoftware.htmlunit.html.*;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ReservationEvent;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ValueObject.Date;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;


public class ReservationResolverImpl implements ReservationResolver {
    private MailerAdapter mailerAdapter;
    private HtmlElementReferrer htmlElementReferrer;
    private InfoLoggerAdapter infoLoggerAdapter;


    public ReservationResolverImpl(MailerAdapter mailerAdapter,
                                   HtmlElementReferrer htmlElementReferrer,
                                   InfoLoggerAdapter infoLoggerAdapter) {
        this.mailerAdapter = mailerAdapter;
        this.htmlElementReferrer = htmlElementReferrer;
        this.infoLoggerAdapter = infoLoggerAdapter;
    }


    public void checkForAvailabilityAndEmail(ArrayList<ReservationEvent> reservationEvents, PageRequestor requestor) throws IOException {

        // @todo: need to go through the ReservationEvents,
//        reservationEvents
//        ArrayList<Date> dates = reservationEvent.dates;
//
//        requestor.visitWebPage(reservationEvent.url);
         ArrayList<Date> dates = reservationEvents.get(0).dates;

        for (int i = 0; i < dates.size(); i++) {

            this.setDateFieldForReservation(requestor, dates, i);

            this.setTimeFieldForReservation(requestor, dates, i);

            this.setPartySizeForReservation(requestor, dates, i);

            this.submitForm(requestor);

            try {
                this.sendMessage(this.getReservationIfAvailable(requestor));
            } catch (Exception e) {
                this.infoLoggerAdapter.info("Current Time: " + Calendar.getInstance().getTime().toString() +
                        " no reservation potential for: " + dates.get(i).getDate());
            }
        }
    }

    /**
     * Set the date calendar field
     * @param requestor
     * @param iteration
     */
    private void setDateFieldForReservation(PageRequestor requestor, ArrayList<Date> dates, int iteration) {
        HtmlInput dateCalendarField = (HtmlInput) requestor.getElementByXPath(this.htmlElementReferrer.DATE_ID_XPATH);
        dateCalendarField.setValueAttribute(dates.get(iteration).getDate());
    }

    /**
     * Set the Time for the reservation.
     *
     * @param requestor
     */
    private void setTimeFieldForReservation(PageRequestor requestor, ArrayList<Date> dates, int iteration) {
        HtmlSelect timeSelectField = (HtmlSelect) requestor.getElementByXPath(this.htmlElementReferrer.TIME_ID_XPATH);
        HtmlOption option = timeSelectField.getOptionByValue(dates.get(iteration).getTime());
        timeSelectField.setSelectedAttribute(option, true);
    }

    /**
     * Party Size Drop down field
     * @param requestor
     * @param iteration
     */
    private void setPartySizeForReservation(PageRequestor requestor, ArrayList<Date> dates, int iteration) {
        HtmlSelect partySizeSelectField = (HtmlSelect) requestor.getElementByXPath(this.htmlElementReferrer.PARTY_SIZE_XPATH);
        HtmlOption partySizeOption = partySizeSelectField.getOptionByValue(dates.get(iteration).getSeating());
        partySizeSelectField.setSelectedAttribute(partySizeOption, true);
    }

    /**
     *
     */
    private void submitForm(PageRequestor requestor) throws IOException {
        HtmlButton findTableButton = (HtmlButton) requestor.getElementById(this.htmlElementReferrer.SEARCH_TIME_BTN_ID);
//            this.infoLoggerAdapter.info("clicking on the submit button");
        findTableButton.click();
    }

    /**
     * Wait 10 seconds for the page load, then check to see if the dining reservation info title div is set, if it is
     * than we know we can set a reservation.
     *
     * @param requestor
     * @return
     */
    private HtmlSpan getReservationIfAvailable(PageRequestor requestor) throws Exception {
        requestor.waitInSeconds(10);
        String diningReservationInfoTitle = "/html/body/div[1]/div[2]/div[4]/div/div/div[4]/div[2]/span/div[2]/div[4]/span[2]";
        HtmlSpan diningReservationInfoTitleDiv = (HtmlSpan) requestor.getElementByXPath(diningReservationInfoTitle);

        if (diningReservationInfoTitleDiv != null) {
            return diningReservationInfoTitleDiv;
        } else {
            throw new Exception("Current Time: " + Calendar.getInstance().getTime().toString() +
                    " no reservation potential for: ");
        }
    }

    /**
     * Send the message out.
     *
     * @param diningReservationInfoTitleDiv
     * @throws Exception
     */
    private void sendMessage(HtmlSpan diningReservationInfoTitleDiv) throws Exception {
        this.infoLoggerAdapter.info("ReservationEntity potential alert: " + diningReservationInfoTitleDiv.asText());
        this.mailerAdapter.setSubjectAndBody("ReservationEntity potential alert: ", "For the day and time: " +diningReservationInfoTitleDiv.asText());
        this.mailerAdapter.sendMessage();
    }
}
