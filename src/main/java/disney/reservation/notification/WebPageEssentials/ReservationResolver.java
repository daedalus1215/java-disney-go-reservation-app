package disney.reservation.notification.WebPageEssentials;

import disney.reservation.notification.Adapter.InfoLoggerAdapter;
import disney.reservation.notification.Adapter.MailerAdapter;
import disney.reservation.notification.WebPageEssentials.Reference.HtmlElementReferrer;
import disney.reservation.notification.WebPageEssentials.Requestor.PageRequestor;
import com.gargoylesoftware.htmlunit.html.*;

import java.util.ArrayList;
import java.util.Calendar;

public class ReservationResolver implements ReservationResolverInterface {
    private MailerAdapter mailerAdapter;
    private HtmlElementReferrer htmlElementReferrer;
    private ArrayList<DateEntity> dateEntities;
    private InfoLoggerAdapter infoLoggerAdapter;

    public ReservationResolver(MailerAdapter mailerAdapter, HtmlElementReferrer htmlElementReferrer, ArrayList<DateEntity> dateEntities, InfoLoggerAdapter infoLoggerAdapter) {
        this.mailerAdapter = mailerAdapter;
        this.htmlElementReferrer = htmlElementReferrer;
        this.dateEntities = dateEntities;
        this.infoLoggerAdapter = infoLoggerAdapter;
    }

    /**
     *
     */
    public void checkForAvailabilityAndEmail(PageRequestor requestor) throws Exception {

        for (int i = 0; i < this.dateEntities.size(); i++) {
            // set the date calendar field
            HtmlInput dateCalendarField = (HtmlInput) requestor.getElementByXPath(this.htmlElementReferrer.DATE_ID_XPATH);
            dateCalendarField.setValueAttribute(dateEntities.get(i).date);

            // Time Drop down field
            HtmlSelect timeSelectField = (HtmlSelect) requestor.getElementByXPath(this.htmlElementReferrer.TIME_ID_XPATH);
            HtmlOption option = timeSelectField.getOptionByValue(dateEntities.get(i).time);
            timeSelectField.setSelectedAttribute(option, true);

            // Party Size Drop down field
            HtmlSelect partySizeSelectField = (HtmlSelect) requestor.getElementByXPath(this.htmlElementReferrer.PARTY_SIZE_XPATH);
            HtmlOption partySizeOption = partySizeSelectField.getOptionByValue(dateEntities.get(i).seating);
            partySizeSelectField.setSelectedAttribute(partySizeOption, true);

            HtmlButton findTableButton = (HtmlButton) requestor.getElementById(this.htmlElementReferrer.SEARCH_TIME_BTN_ID);
//            this.infoLoggerAdapter.info("clicking on the submit button");
            findTableButton.click();

            requestor.waitInSeconds(10);


            String diningReservationInfoTitle = "/html/body/div[1]/div[2]/div[4]/div/div/div[4]/div[2]/span/div[2]/div[4]/span[2]";
            HtmlSpan diningReservationInfoTitleDiv = (HtmlSpan) requestor.getElementByXPath(diningReservationInfoTitle);

            if (diningReservationInfoTitleDiv != null) {
                this.infoLoggerAdapter.info("Reservation potential alert: " + diningReservationInfoTitleDiv.asText());
                this.mailerAdapter.setSubjectAndBody("Reservation potential alert: ", "For the day and time: " +diningReservationInfoTitleDiv.asText());
                this.mailerAdapter.sendMessage();
            } else {
                this.infoLoggerAdapter.info("Current Time: " + Calendar.getInstance().getTime().toString() +
                        " no reservation potential for: " + dateEntities.get(i).date);
            }
        }
    }


}
