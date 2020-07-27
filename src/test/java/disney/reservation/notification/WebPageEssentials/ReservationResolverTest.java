package disney.reservation.notification.WebPageEssentials;

import static org.mockito.Mockito.mock;

import MocksAndStubs.PageRequestorStubFactory;
import disney.reservation.notification.infrastructure.log.InfoLoggerAdapter;
import disney.reservation.notification.domain.mail.MailerAdapter;
import disney.reservation.notification.WebPageEssentials.Reference.HtmlElementReferrer;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ReservationEvent;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ValueObject.Date;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

final public class ReservationResolverTest {

  private ReservationResolver tester;

  private void setup() {
    MailerAdapter stub = mock(MailerAdapter.class);
    HtmlElementReferrer stubHtml = mock(HtmlElementReferrer.class);
    InfoLoggerAdapter stubLogger = mock(InfoLoggerAdapter.class);
    this.tester = new ReservationResolverImpl(stub, stubHtml, stubLogger);
  }


  private ArrayList<ReservationEvent> getReservationMocks() {
    ArrayList<ReservationEvent> mocks = new ArrayList<>();

    ReservationEvent mock1 = mock(ReservationEvent.class);
    mock1.name = "mock1 name";
    mock1.url = "http://mock-url.com";
    mock1.dates = this.getDateMocks();
    mocks.add(mock1);

    ReservationEvent mock2 = mock(ReservationEvent.class);
    mock2.name = "mock2 name";
    mock2.url = "http://mock2-url.com";
    mock2.dates = this.getDateMocks();
    mocks.add(mock2);

    return mocks;
  }

  private ArrayList<Date> getDateMocks() {
    ArrayList<Date> mocks = new ArrayList<>();

    Date mockDate1 = mock(Date.class);
    mockDate1.setDate("12/13/2013");
    mockDate1.setSeating("2");
    mockDate1.setTime("7:00 AM");
    mocks.add(mockDate1);

    Date mockDate2 = mock(Date.class);
    mockDate2.setDate("12/15/2013");
    mockDate2.setSeating("3");
    mockDate2.setTime("8:00 AM");
    mocks.add(mockDate2);

    return mocks;
  }


  @Test
  void testCheckForAvailabilityAndEmailEquals() throws Exception {
    this.setup();
    this.tester.checkForAvailabilityAndEmail(this.getReservationMocks(),
        PageRequestorStubFactory.createStub());
  }


}