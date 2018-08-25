package disney.reservation.notification.WebPageEssentials.Requestor.Factory;

import disney.reservation.notification.WebPageEssentials.Requestor.PageRequestor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageRequestorFactoryForOhanaTest {


    @Test
    void createPageRequestor() {
        PageRequestorFactoryForOhana tester = new PageRequestorFactoryForOhana();
        PageRequestor mockRequestor = tester.createPageRequestor();

        assertEquals("PageRequestor{url='https://disneyworld.disney.go.com/dining/polynesian-resort/ohana/', webClient=class com.gargoylesoftware.htmlunit.WebClient}", mockRequestor.toString());
    }

}