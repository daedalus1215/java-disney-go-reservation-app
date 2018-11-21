package disney.reservation.notification.WebPageEssentials;

import disney.reservation.notification.Adapter.Logger.InfoLoggerAdapter;
import disney.reservation.notification.Adapter.MailerAdapter;
import disney.reservation.notification.WebPageEssentials.Reference.HtmlElementReferrer;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;


final public class ReservationResolverTest {
    private ReservationResolver tester;

    private void setup() throws Exception {
        MailerAdapter stub = mock(MailerAdapter.class);
        HtmlElementReferrer stubHtml = mock(HtmlElementReferrer.class);
        InfoLoggerAdapter stubLogger = mock(InfoLoggerAdapter.class);
        this.tester = new ReservationResolverImpl(stub, stubHtml, stubLogger);
    }
    @Test
    void testCheckForAvailabilityAndEmailEquals() {

        //@todo: stub up the ReservationEvent.
        //@todo: stub up the Requestor.
        this.tester.checkForAvailabilityAndEmail();
    }

}