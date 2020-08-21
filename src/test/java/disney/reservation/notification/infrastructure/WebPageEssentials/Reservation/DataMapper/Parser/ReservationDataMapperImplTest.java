package disney.reservation.notification.infrastructure.WebPageEssentials.Reservation.DataMapper.Parser;


import MocksAndStubs.DateDataMapperStubFactory;
import disney.reservation.notification.infrastructure.WebPageEssentials.Reservation.DataMapper.Parser.Exception.ReservationParserException;
import disney.reservation.notification.infrastructure.WebPageEssentials.Reservation.DataMapper.ReservationDataMapperImpl;
import disney.reservation.notification.infrastructure.WebPageEssentials.Reservation.Entity.Event;
import disney.reservation.notification.infrastructure.WebPageEssentials.Reservation.Entity.ValueObject.DateImpl;
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
    public void testLoadEquals() throws ParseException, ReservationParserException {
        this.setup();
        ArrayList<Event> events = this.tester.load();
        Assert.assertEquals(new DateImpl("10/12/2013", "10:00", "4").toString(), events.get(0).dates.get(0).toString());
        Assert.assertEquals("testing-event-name", events.get(0).name);
        Assert.assertEquals("http://test.com1", events.get(0).url);
    }
}