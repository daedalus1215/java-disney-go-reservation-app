package disney.reservation.notification.WebPageEssentials.Reservation.Property;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReservationDateVOTest {

    @Test
    public void testConstructorException() {
        try {
            ReservationDateVO tester = new ReservationDateVO(null, null, null);
        } catch (Exception e) {
            Assertions.assertEquals("Must have a valid date, time, and seating for every ReservationDate", e.getMessage());
        }
    }

    @Test
    public void testConstructorEquals() throws Exception {
        ReservationDateVO tester = new ReservationDateVO("09/18/2018", "8000019", "4");
        Assertions.assertEquals("09/18/2018", tester.getDate());
        Assertions.assertEquals("8000019", tester.getTime());
        Assertions.assertEquals("4", tester.getSeating());
    }
}
