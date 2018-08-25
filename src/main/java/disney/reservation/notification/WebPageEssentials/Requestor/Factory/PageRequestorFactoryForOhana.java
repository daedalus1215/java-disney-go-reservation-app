package disney.reservation.notification.WebPageEssentials.Requestor.Factory;

import disney.reservation.notification.WebPageEssentials.Requestor.PageRequestor;
import com.gargoylesoftware.htmlunit.WebClient;

public class PageRequestorFactoryForOhana implements PageRequestorFactoryInterface {

    public PageRequestor createPageRequestor() {
        String url = "https://disneyworld.disney.go.com/dining/polynesian-resort/ohana/";

        WebClient webClient = new WebClient();

        PageRequestor pageRequestor = new PageRequestor(url, webClient);

        return pageRequestor;
    }
}
