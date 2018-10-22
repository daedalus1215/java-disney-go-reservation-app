package disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser;


import disney.reservation.notification.Adapter.Logger.Logger;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser.Exception.ReservationParserException;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.nio.file.FileSystems;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;


public class ReservationParserImplTest {


    @Test
    public void testParseEquals() throws Exception, ReservationParserException {
        String directoryPath = FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "/src/test/java/disney/reservation/notification/WebPageEssentials/reservation/DataMapper/Parser";
        Logger stubLogger = mock(Logger.class);
        ReservationParserImpl tester = new ReservationParserImpl(stubLogger);
        ArrayList<JSONObject> mockObjects = tester.parse(directoryPath);


        assertEquals("http://happy.com", mockObjects.get(0).get("url"));
        assertEquals("12/31/2018", mockObjects.get(0).get("startDate"));
        assertEquals("1/29/2019", mockObjects.get(0).get("endDate"));
        assertEquals("2", mockObjects.get(0).get("seating"));

        assertEquals("http://happy.com", mockObjects.get(1).get("url"));
        assertEquals("1/15/2019", mockObjects.get(1).get("startDate"));
        assertEquals("1/30/2019", mockObjects.get(1).get("endDate"));
        assertEquals("4", mockObjects.get(1).get("seating"));

    }


    @Test
    public void testParseNotEquals() throws Exception, ReservationParserException {
        String directoryPath = FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "/src/test/java/disney/reservation/notification/WebPageEssentials/reservation/DataMapper/Parser";
        Logger stubLogger = mock(Logger.class);
        ReservationParserImpl tester = new ReservationParserImpl(stubLogger);
        ArrayList<JSONObject> mockObjects = tester.parse(directoryPath);


        assertNotSame("NOT_EQUALS", mockObjects.get(0).get("url"));
        assertNotSame("NOT_EQUALS", mockObjects.get(0).get("startDate"));
        assertNotSame("NOT_EQUALS", mockObjects.get(0).get("endDate"));
        assertNotSame("NOT_EQUALS", mockObjects.get(0).get("seating"));
    }


    @Test
    public void testParseException() {
        String directoryPath = "C:\\NOT_REAL_DIRECTORY";
        Logger stubLogger = mock(Logger.class);
        ReservationParserImpl tester = new ReservationParserImpl(stubLogger);

            ArrayList<JSONObject> mockJSONObjects = tester.parse(directoryPath);
            Assertions.assertNull(mockJSONObjects);
    }


}