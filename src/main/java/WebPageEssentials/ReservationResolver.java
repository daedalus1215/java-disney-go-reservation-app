package WebPageEssentials;

import Adapter.InfoLoggerAdapter;
import Adapter.MailerAdapter;
import WebPageEssentials.Reference.HtmlElementReferrer;
import com.gargoylesoftware.htmlunit.html.*;

import java.util.ArrayList;

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
     * @return ArrayList<DateEntity> | null
     */
    public ArrayList<DateEntity> checkForAvailability(HtmlPage page) {

        ArrayList<DateEntity> dateEntities = dateAggregator.getDateEntities();
        for (int i = 0; i < dateEntities.size(); i++) {
            // set the date calendar field
            HtmlInput dateCalendarField = page.getFirstByXPath(this.htmlElementReferrer.DATE_ID_XPATH);
            dateCalendarField.setValueAttribute(dateAggregator.getDesiredDate(i));

            // Time Drop down field
            HtmlSelect timeSelectField = page.getFirstByXPath(this.htmlElementReferrer.TIME_ID_XPATH);
            HtmlOption option = timeSelectField.getOptionByValue(dateAggregator.getDesiredTime(i));
            timeSelectField.setSelectedAttribute(option, true);

            // Party Size Drop down field
            HtmlSelect partySizeSelectField = page.getFirstByXPath(this.htmlElementReferrer.PARTY_SIZE_XPATH);
            HtmlOption partySizeOption = partySizeSelectField.getOptionByValue(dateAggregator.getDesiredPartySize(i));
            partySizeSelectField.setSelectedAttribute(partySizeOption, true);

        }
//
//        ArrayList<HtmlHeading3> d = (ArrayList) page.getByXPath(this.htmlElementReferrer.DINING_RESERVATION_DATE_XPATH);
//        for (int i = 0; i < d.size(); i++) {
//            System.out.println(d.get(i).asText());
//        }

        return null;
    }


}
