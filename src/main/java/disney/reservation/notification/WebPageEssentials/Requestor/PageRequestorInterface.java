package disney.reservation.notification.WebPageEssentials.Requestor;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;

import java.io.IOException;

public interface PageRequestorInterface {

    void visitWebPage(String url) throws IOException;

    void waitInSeconds(int inSeconds);

    HtmlElement getElementByXPath(String xPath);

    DomElement getElementById(String id);

    @Override
    String toString();
}
