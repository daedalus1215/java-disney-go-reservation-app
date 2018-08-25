package disney.reservation.notification.WebPageEssentials;

import disney.reservation.notification.Adapter.InfoLoggerAdapter;
import disney.reservation.notification.Adapter.MailerAdapter;
import disney.reservation.notification.WebPageEssentials.Reference.HtmlElementReferrer;
import disney.reservation.notification.WebPageEssentials.Requestor.PageRequestor;
import com.gargoylesoftware.htmlunit.html.*;

import java.util.ArrayList;
import java.util.Calendar;

public class ReservationResolver {
    private MailerAdapter mailerAdapter;
    private HtmlElementReferrer htmlElementReferrer;
    private DateAggregator dateAggregator;
    private InfoLoggerAdapter infoLoggerAdapter;

    public ReservationResolver(MailerAdapter mailerAdapter, HtmlElementReferrer htmlElementReferrer, DateAggregator dateAggregator, InfoLoggerAdapter infoLoggerAdapter) {
        this.mailerAdapter = mailerAdapter;
        this.htmlElementReferrer = htmlElementReferrer;
        this.dateAggregator = dateAggregator;
        this.infoLoggerAdapter = infoLoggerAdapter;
    }

    /**
     *
     */
    public void checkForAvailabilityAndEmail(PageRequestor requestor) throws Exception {

        ArrayList<DateEntity> dateEntities = dateAggregator.getDateEntities();
        for (int i = 0; i < dateEntities.size(); i++) {
            // set the date calendar field
            HtmlInput dateCalendarField = (HtmlInput) requestor.getElementByXPath(this.htmlElementReferrer.DATE_ID_XPATH);
            dateCalendarField.setValueAttribute(dateAggregator.getDesiredDate(i));

            // Time Drop down field
            HtmlSelect timeSelectField = (HtmlSelect) requestor.getElementByXPath(this.htmlElementReferrer.TIME_ID_XPATH);
            HtmlOption option = timeSelectField.getOptionByValue(dateAggregator.getDesiredTime(i));
            timeSelectField.setSelectedAttribute(option, true);

            // Party Size Drop down field
            HtmlSelect partySizeSelectField = (HtmlSelect) requestor.getElementByXPath(this.htmlElementReferrer.PARTY_SIZE_XPATH);
            HtmlOption partySizeOption = partySizeSelectField.getOptionByValue(dateAggregator.getDesiredPartySize(i));
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
                        " no reservation potential for: " + dateAggregator.getDesiredDate(i));
            }
        }
    }


}
