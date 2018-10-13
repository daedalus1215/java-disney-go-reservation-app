package disney.reservation.notification.WebPageEssentials.Requestor.Factory;

import disney.reservation.notification.WebPageEssentials.Requestor.PageRequestor;
import com.gargoylesoftware.htmlunit.WebClient;

public class PageRequestorFactoryForOhana implements PageRequestorFactoryInterface {

    public PageRequestor createPageRequestor() {
        WebClient webClient = new WebClient();

        PageRequestor pageRequestor = new PageRequestor(webClient);

        return pageRequestor;
    }
}
