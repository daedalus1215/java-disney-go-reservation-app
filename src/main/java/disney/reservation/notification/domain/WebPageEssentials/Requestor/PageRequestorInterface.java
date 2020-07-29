package disney.reservation.notification.domain.WebPageEssentials.Requestor;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;

import java.io.IOException;

public interface PageRequestorInterface {

    void visitWebPage(String url) throws IOException;

    void waitInSeconds(int inSeconds);

    HtmlElement getElementByXPath(String xPath) throws Exception;

    DomElement getElementById(String id) throws Exception;

    @Override
    String toString();

    void close();
}
