package disney.reservation.notification.infrastructure.WebPageEssentials.Requestor;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

/**
 * Class is essentially an adapter over HtmlPage & WebClient.
 */
public class PageRequestor implements PageRequestorInterface {
    private String url;
    private WebClient webClient;
    private HtmlPage page;


    public PageRequestor(WebClient webClient) {
        this.webClient = webClient;
    }


    /**
     * Wait 5 seconds after we get the webpage.
     * This will fire off a webClient and we will be ready to grab elements.
     *
     * @param url
     * @throws IOException
     */
    public void visitWebPage(String url) throws IOException {
        this.url = url;
        HtmlPage page = this.webClient.getPage(url);
//        this.waitInSeconds(5);
        this.page = page;
    }

    /**
     * Wait in seconds.
     * @param inSeconds the seconds that we want to wait for.
     */
    public void waitInSeconds(int inSeconds) {
        this.webClient.waitForBackgroundJavaScript(inSeconds * 1000);
    }


    public HtmlElement getElementByXPath(String xPath) throws Exception {
        this.makeSureWeAreOnAPage();
        return this.page.getFirstByXPath(xPath);
    }

    public DomElement getElementById(String id) throws Exception {
        this.makeSureWeAreOnAPage();
        return this.page.getElementById(id);
    }

    /**
     * We want to make sure that we have a page
     * @throws Exception
     */
    private void makeSureWeAreOnAPage() throws Exception {
        if (this.page == null) {
            throw new Exception("Need to set the target URL before we grab elements from the page. Please call visitWebPage(), that way we have a Page object to grab elements for.");
        }
    }

    public HtmlPage getPage() {
        return this.page;
    }


    @Override
    public void close() {
        this.webClient.close();
    }

    public String toString() {
        return "PageRequestor{" +
                "url='" + this.url + '\'' +
                ", webClient=" + webClient.getClass().toString() +
                '}';
    }
}
