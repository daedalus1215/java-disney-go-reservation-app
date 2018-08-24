package WebPageEssentials.Requestor;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebConnection;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PageRequestorTest {


    @Test
    void testGetPageEquals() {
        String stubUrl = "testdummy.html";
        WebClient stubWebClient = new WebClient();

        PageRequestor tester = new PageRequestor(stubUrl, stubWebClient);

        try {
            tester.visitWebPage();
            assertEquals("testdummy.html", tester.page.getUrl());
        } catch (IOException exception) {

        }
    }

}