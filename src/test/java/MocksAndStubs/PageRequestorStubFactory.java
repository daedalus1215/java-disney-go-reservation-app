package MocksAndStubs;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlDateInput;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import disney.reservation.notification.domain.WebPageEssentials.Reference.HtmlElementReferrer;
import disney.reservation.notification.domain.WebPageEssentials.Requestor.PageRequestor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class PageRequestorStubFactory {

    public static PageRequestor createStub() throws Exception {
        PageRequestor stub = mock(PageRequestor.class);
        HtmlDateInput sInput = mock(HtmlDateInput.class);
        HtmlSelect sSelect = mock(HtmlSelect.class);
        HtmlButton sButton = mock(HtmlButton.class);
        when(sButton.click()).thenReturn(mock(Page.class));

        HtmlElementReferrer htmlRef = new HtmlElementReferrer();
        when(stub.getElementByXPath(htmlRef.DATE_ID_XPATH)).thenReturn(sInput);
        when(stub.getElementByXPath(htmlRef.TIME_ID_XPATH)).thenReturn(sSelect);
        when(stub.getElementByXPath(htmlRef.PARTY_SIZE_XPATH)).thenReturn(sSelect);
        when(stub.getElementById(htmlRef.SEARCH_TIME_BTN_ID)).thenReturn(sButton);
        when(stub.getElementById(" ")).thenReturn(sInput);
        return stub;
    }


}
