package WebPageEssentials;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateEntityTest {

    @Test
    public void testConstructorEquals() {
        DateEntity tester = new DateEntity("09/18/2018", "8000019", 4, "September 19, 2018");
        assertEquals("09/18/2018", tester.date);
        assertEquals("8000019", tester.time);
        assertEquals(4, tester.seating);
        assertEquals("September 19, 2018", tester.displayedDate);
    }
}