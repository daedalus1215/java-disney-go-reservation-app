package disney.reservation.notification.infrastructure.WebPageEssentials.Reservation.Entity.ValueObject;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DateImplTest {

    @Test
    public void testConstructorEquals() {
        DateImpl tester = new DateImpl("09/18/2018", "8000019", "4");
        assertEquals("09/18/2018", tester.date);
        assertEquals("8000019", tester.time);
        assertEquals("4", tester.seating);
    }
}