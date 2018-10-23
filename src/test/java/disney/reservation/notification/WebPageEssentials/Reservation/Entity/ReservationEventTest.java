package disney.reservation.notification.WebPageEssentials.Reservation.Entity;

import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ValueObject.Date;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ValueObject.DateImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReservationEventTest {

    private ReservationEvent tester;


    public void setup() {
        ReservationEvent tester = new ReservationEvent();
        tester.url = "http://test.com";
        tester.startDate = "09/18/2018";
        tester.endDate = "09/28/2018";
        tester.time = "8000029";
        tester.seating = "4";

        ArrayList<Date> mockDates = new ArrayList<>();
        Date mockDateImpl = new DateImpl(tester.startDate, tester.time, tester.seating);
        mockDates.add(mockDateImpl);
        tester.dates = mockDates;
        this.tester = tester;
    }


    @Test
    public void testConstructorEquals() {
        this.setup();
        assertEquals(tester.url, "http://test.com");
        assertEquals(tester.startDate, "09/18/2018");
        assertEquals(tester.endDate, "09/28/2018");
        assertEquals(tester.time, "8000029");
        assertEquals(tester.seating, "4");
        assertEquals(tester.dates.get(0).toString(), new DateImpl("09/18/2018", "8000029", "4").toString());
    }
}