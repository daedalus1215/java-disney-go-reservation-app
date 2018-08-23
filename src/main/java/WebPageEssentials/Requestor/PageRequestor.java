package WebPageEssentials.Requestor;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class PageRequestor {
    private String url;
    private WebClient webClient;

    public PageRequestor(String url, WebClient webClient) {
        this.url = url;
        this.webClient = webClient;
    }


    /**
     * Wait 5 seconds after we get the webpage
     * @return HtmlPage page
     * @throws IOException
     */
    public HtmlPage getPage() throws IOException {
        System.out.println("Loading page now: " + this.url);
        HtmlPage page = this.webClient.getPage(this.url);
        this.webClient.waitForBackgroundJavaScript(5 * 1000);

        return page;
    }

    @Override
    public String toString() {
        return "PageRequestor{" +
                "url='" + url + '\'' +
                ", webClient=" + webClient.getClass().toString() +
                '}';
    }
}
