package disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser;


import MocksAndStubs.DateDataMapperStubFactory;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.ReservationDataMapperImpl;
import disney.reservation.notification.WebPageEssentials.Reservation.Date.DataMapper.DateDataMapperImpl;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ReservationEvent;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ValueObject.Date;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ValueObject.DateImpl;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import java.text.ParseException;
import java.util.ArrayList;


public class ReservationDataMapperImplTest {
    private ReservationDataMapperImpl tester;


    public void setup() throws ParseException {
        this.tester = new ReservationDataMapperImpl(
                (new ReservationParserStubFactory()).createStub(),
                (new DateDataMapperStubFactory()).createStub()
        );
    }

    @Test
    public void testLoadEquals() throws ParseException {
        this.setup();
        ArrayList<ReservationEvent> reservationEvents = this.tester.load();
        Assert.assertEquals(new DateImpl("10/12/2013", "10:00", "4").toString(), reservationEvents.get(0).dates.get(0).toString());
        Assert.assertEquals("testing-event-name", reservationEvents.get(0).name);
        Assert.assertEquals("http://test.com1", reservationEvents.get(0).url);
    }
}