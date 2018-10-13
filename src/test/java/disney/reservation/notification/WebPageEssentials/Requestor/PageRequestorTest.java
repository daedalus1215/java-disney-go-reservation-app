package disney.reservation.notification.WebPageEssentials.Requestor;

import com.gargoylesoftware.htmlunit.WebClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PageRequestorTest {


    @Test
    void testGetPageEquals() {
        String stubUrl = "testdummy.html";
        WebClient stubWebClient = new WebClient();

        PageRequestor tester = new PageRequestor(stubWebClient);

        try {
            tester.visitWebPage(stubUrl);
            assertEquals("testdummy.html", tester.page.getUrl());
        } catch (IOException exception) {

        }
    }

}