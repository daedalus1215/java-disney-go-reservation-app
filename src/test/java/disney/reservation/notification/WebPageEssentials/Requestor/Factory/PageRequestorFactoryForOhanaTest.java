package disney.reservation.notification.WebPageEssentials.Requestor.Factory;

import disney.reservation.notification.WebPageEssentials.Requestor.PageRequestor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageRequestorFactoryForOhanaTest {


    @Test
    void createPageRequestor() {
        PageRequestorFactory tester = new PageRequestorFactory();
        PageRequestor mockRequestor = tester.createPageRequestor();

        assertEquals("PageRequestor{url='null', webClient=class com.gargoylesoftware.htmlunit.WebClient}", mockRequestor.toString());
    }

}