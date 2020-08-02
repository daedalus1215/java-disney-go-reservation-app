package disney.reservation.notification.domain.WebPageEssentials.Reservation.Entity;

import disney.reservation.notification.domain.WebPageEssentials.Reservation.Entity.ValueObject.Date;
import disney.reservation.notification.domain.WebPageEssentials.Reservation.Entity.ValueObject.DateImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    private ReservationEvent tester;


    public void setup() {
        ArrayList<Date> mockDates = new ArrayList<>();
        Date mockDateImpl = new DateImpl("09/18/2018", "8000029", "4");
        mockDates.add(mockDateImpl);

        ReservationEvent tester = new ReservationEvent();
        tester.url = "http://test.com";
        tester.name = "testing-name--of-reservation";
        tester.dates = mockDates;
        this.tester = tester;
    }


    @Test
    public void testConstructorEquals() {
        this.setup();
        assertEquals(tester.url, "http://test.com");
        assertEquals(tester.dates.get(0).toString(), new DateImpl("09/18/2018", "8000029", "4").toString());
    }
}