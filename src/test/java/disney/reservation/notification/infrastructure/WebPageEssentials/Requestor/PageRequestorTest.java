package disney.reservation.notification.infrastructure.WebPageEssentials.Requestor;


import com.gargoylesoftware.htmlunit.WebClient;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class PageRequestorTest {
    ExpectedException exceptionRule = ExpectedException.none();


    @Test
    void testGetPageEquals() {
        String stubUrl = "testdummy.html";
        //@todo: prob should mock this properly with mock().
        WebClient stubWebClient = new WebClient();

        PageRequestor tester = new PageRequestor(stubWebClient);

        try {
            tester.visitWebPage(stubUrl);
            assertEquals("testdummy.html", tester.getPage().getUrl());
        } catch (IOException exception) {

        }
    }

    @Test
    void testGetPageException() throws Exception {
        WebClient stubWebClient = new WebClient();
        PageRequestor tester = new PageRequestor(stubWebClient);

        Exception exception = assertThrows(Exception.class, () -> {
            tester.getElementByXPath("-");
        });
        assertEquals("Need to set the target URL before we grab elements from the page. Please call visitWebPage(), that way we have a Page object to grab elements for.",
                exception.getMessage());
    }

}