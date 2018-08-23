package WebPageEssentials;

import Adapter.InfoLoggerAdapter;
import Adapter.MailerAdapter;
import WebPageEssentials.Reference.HtmlElementReferrer;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

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
        this.htmlElementReferrer.DINING_RESERVATION_TITLE_XPATH
        ArrayList<HtmlHeading3> d = (ArrayList) page.getByXPath("/html/body/div[1]/div[2]/div[4]/div/div/div[4]/div[2]/div[1]/h3");
        for (int i = 0; i < d.size(); i++) {
            System.out.println(d.get(i).asText());
        }

        return null;
    }
}
