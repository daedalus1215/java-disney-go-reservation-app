package disney.reservation.notification.WebPageEssentials;


import disney.reservation.notification.infrastructure.log.InfoLoggerAdapter;
import disney.reservation.notification.domain.mail.MailerAdapter;
import disney.reservation.notification.WebPageEssentials.Reference.HtmlElementReferrer;
import disney.reservation.notification.WebPageEssentials.Requestor.PageRequestor;
import com.gargoylesoftware.htmlunit.html.*;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ReservationEvent;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ValueObject.Date;
import org.w3c.dom.html.HTMLDivElement;

import java.io.IOException;
import java.util.ArrayList;


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


    public void checkForAvailabilityAndEmail(ArrayList<ReservationEvent> reservationEvents,
                                             PageRequestor requestor) throws Exception {

        for (ReservationEvent event : reservationEvents) {

            this.tryToConnectToEventsWebpage(requestor, event);

            for (Date date : event.dates) { //@todo: what if there are no dates - throw an exception - or ensure that it won't happen.
                this.setDateFieldForReservation(requestor, date);

                this.setTimeFieldForReservation(requestor, date);

                this.setPartySizeForReservation(requestor, date);

                this.submitForm(requestor);

                try {
                    //@todo: troubleshooting right here, some reason there is an issue with validating a return.
                    this.sendMessage(this.getReservationIfAvailable(requestor));

                } catch (Exception e) {
                    this.infoLoggerAdapter.info("NO, current availabilities around: "
                            + "\n Reservation Name: " + event.name
                            + "\n Event Date: " + date.getDate()
                            + "\n Event Time: " + date.getTime()
                            + "\n Seating: " + date.getSeating());
                } finally {
                    requestor.close();
                }
            }
        }
    }


    /**
     *
     * @param requestor
     * @param event
     */
    private void tryToConnectToEventsWebpage(PageRequestor requestor, ReservationEvent event) throws Exception {
        try {
            requestor.visitWebPage(event.url);
        } catch (IOException exception) {
           throw new Exception("WebClient issue with connecting to: " + event.url);
        }
    }


    /**
     * Set the date calendar field
     *
     * @param requestor
     * @param date
     */
    private void setDateFieldForReservation(PageRequestor requestor, Date date) throws Exception {
        HtmlInput dateCalendarField = (HtmlInput) requestor.getElementByXPath(this.htmlElementReferrer.DATE_ID_XPATH);
        dateCalendarField.setValueAttribute(date.getDate());
    }

    /**
     * Set the Time for the reservation.
     *
     * @param requestor
     * @param date
     */
    private void setTimeFieldForReservation(PageRequestor requestor, Date date) throws Exception {
        HtmlSelect timeSelectField = (HtmlSelect) requestor.getElementByXPath(this.htmlElementReferrer.TIME_ID_XPATH);
        HtmlOption option = timeSelectField.getOptionByValue(date.getTime());
        timeSelectField.setSelectedAttribute(option, true);
    }

    /**
     * Party Size Drop down field
     *
     * @param requestor
     * @param date
     */
    private void setPartySizeForReservation(PageRequestor requestor, Date date) throws Exception {
        HtmlSelect partySizeSelectField = (HtmlSelect) requestor.getElementByXPath(this.htmlElementReferrer.PARTY_SIZE_XPATH);
        HtmlOption partySizeOption = partySizeSelectField.getOptionByValue(date.getSeating());
        partySizeSelectField.setSelectedAttribute(partySizeOption, true);
    }

    /**
     * @param requestor
     * @throws IOException
     */
    private void submitForm(PageRequestor requestor) throws Exception {
        HtmlButton findTableButton = (HtmlButton) requestor.getElementById(this.htmlElementReferrer.SEARCH_TIME_BTN_ID);
        findTableButton.click();
    }

    /**
     * Wait 10 seconds for the page load, then check to see if the dining reservation info title div is set, if it is
     * than we know we can set a reservation.
     *
     * @param requestor
     * @return
     */
    private HTMLDivElement getReservationIfAvailable(PageRequestor requestor) throws Exception {
//        requestor.waitInSeconds(10);
        String firstAvailableElementXpath = this.htmlElementReferrer.FIRST_AVAILABLE_TIME_ELEMENT_ID;
        HTMLDivElement diningReservationInfoTitleDiv = (HTMLDivElement) requestor.getElementById(firstAvailableElementXpath);

        if (diningReservationInfoTitleDiv != null) {
            return diningReservationInfoTitleDiv;
        } else {
            throw new Exception("no reservation potential for: ");
        }
    }

    /**
     * Send the message out.
     *
     * @param diningReservationInfoTitleDiv
     * @throws Exception
     */
    private void sendMessage(HTMLDivElement diningReservationInfoTitleDiv) throws Exception {
        this.infoLoggerAdapter.info("ReservationEntity potential alert: " + diningReservationInfoTitleDiv.getTextContent());
        this.mailerAdapter.setSubjectAndBody("ReservationEntity potential alert: ", "For the day and time: " + diningReservationInfoTitleDiv.getTextContent());
        this.mailerAdapter.sendMessage();
    }
}
