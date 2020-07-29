package disney.reservation.notification.domain.WebPageEssentials.Requestor.Factory;

import com.gargoylesoftware.htmlunit.*;
import disney.reservation.notification.domain.WebPageEssentials.Requestor.PageRequestor;

public class PageRequestorFactory implements PageRequestorFactoryInterface {

    public PageRequestor createPageRequestor() {
        WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
//        webClient.getOptions().setTimeout(60000);
//        webClient.getOptions().setRedirectEnabled(true);
//        webClient.getOptions().setJavaScriptEnabled(true);
//        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
//        webClient.getOptions().setThrowExceptionOnScriptError(false);
//        webClient.getOptions().setCssEnabled(false);
//        webClient.setJavaScriptTimeout(30000); //e.g. 30s


        final SilentCssErrorHandler eh = new SilentCssErrorHandler();
        webClient.setCssErrorHandler(eh);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setUseInsecureSSL(true);
        webClient.getOptions().setCssEnabled(true);
        webClient.getOptions().setPopupBlockerEnabled(false);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getOptions().setJavaScriptEnabled(true);
        CookieManager cm = new CookieManager();
        webClient.setCookieManager(cm);
        webClient.setJavaScriptTimeout(3600);
        webClient.getOptions().setTimeout(9000);




        return  new PageRequestor(webClient);
    }
}
