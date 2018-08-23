package WebPageEssentials.Reference;

import WebPageEssentials.Reference.HtmlElementReferrer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HtmlElementReferrerTest {

    @Test
    public void testPropertiesAreSetAutomaticallyEquals() {
        HtmlElementReferrer tester = new HtmlElementReferrer();

        assertEquals("//*[@id=\"diningAvailabilityForm-searchDate\"]", tester.DATE_ID_XPATH);
        assertEquals("//*[@id=\"diningAvailabilityForm-searchTime\"]", tester.TIME_ID_XPATH);
        assertEquals("//*[@id=\"partySize\"]", tester.PARTY_SIZE_XPATH);
        assertEquals("dineAvailSearchButton", tester.SEARCH_TIME_BTN_ID);
        assertEquals(
                "/html/body/div[1]/div[2]/div[4]/div/div/div[4]/div[2]/span/div[2]/div[4]/div[2]/span[1]",
                tester.DINING_RESERVATION_TITLE_XPATH
        );
    }
}