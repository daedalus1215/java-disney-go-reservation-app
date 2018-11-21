package disney.reservation.notification.WebPageEssentials.Requestor;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class PageRequestor implements PageRequestorInterface {
    private String url;
    private WebClient webClient;
    public HtmlPage page;


    public PageRequestor(WebClient webClient) {
        this.webClient = webClient;
    }


    /**
     * Wait 5 seconds after we get the webpage
     * @return HtmlPage page
     * @throws IOException
     */
    public void visitWebPage(String url) throws IOException {
        this.url = url;
        HtmlPage page = this.webClient.getPage(url);
        this.waitInSeconds(5);
        this.page = page;
    }

    /**
     * Wait in seconds.
     * @param inSeconds the seconds that we want to wait for.
     */
    public void waitInSeconds(int inSeconds) {
        this.webClient.waitForBackgroundJavaScript(inSeconds * 1000);
    }


    public HtmlElement getElementByXPath(String xPath) {
        return this.page.getFirstByXPath(xPath);
    }

    public DomElement getElementById(String id) {
        return this.page.getElementById(id);
    }


    public String toString() {
        return "PageRequestor{" +
                "url='" + this.url + '\'' +
                ", webClient=" + webClient.getClass().toString() +
                '}';
    }
}
