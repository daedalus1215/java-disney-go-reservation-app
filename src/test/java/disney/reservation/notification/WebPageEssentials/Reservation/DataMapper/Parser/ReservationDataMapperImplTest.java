package disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser;


import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.ReservationDataMapperImpl;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ReservationDataMapperImplTest {
    private ReservationDataMapperImpl tester;


    public void setup() {
        ReservationParser stubReservationParser = new ReservationParserStubFactory().createStub();
        this.tester = new ReservationDataMapperImpl(stubReservationParser);
    }

    @Test
    public void testFetechReservationEvents() {
        this.setup();
//        ArrayList<ReservationEvent> mockReservationEvents = this.tester.fetchReservationEvents();
//
//        ArrayList<Map<String, String>> mReservationEventsArray = new ArrayList<>();
//
//        Map<String, String> resEvent1 = new HashMap<String, String>();
//        resEvent1.put("url", "http://test.com1");
//        resEvent1.put("startDate", "05/12/1986");
//        resEvent1.put("endDate", "05/31/1986");
//        resEvent1.put("seating", "4");
//
//        mReservationEventsArray.add(resEvent1);
//
//
//        Map<String, String> resEvent2 = new HashMap<String, String>();
//        resEvent2.put("url", "http://test.com1");
//        resEvent2.put("startDate", "08/08/1987");
//        resEvent2.put("endDate", "08/16/1987");
//        resEvent2.put("seating", "4");
//
//        mReservationEventsArray.add(resEvent2);
//
//
//        Map<String, String> resEvent3 = new HashMap<String, String>();
//        resEvent3.put("url", "http://test.com1");
//        resEvent3.put("startDate", "10/01/1988");
//        resEvent3.put("endDate", "10/16/1988");
//        resEvent3.put("seating", "4");
//
//        mReservationEventsArray.add(resEvent3);
//
//
//        for (int i = 0; i < 3; i++) {
//            assertEquals(mReservationEventsArray.get(i).get("url"), mockReservationEvents.get(i).url);
//            assertEquals(mReservationEventsArray.get(i).get("startDate"), mockReservationEvents.get(i).startDate);
//            assertEquals(mReservationEventsArray.get(i).get("endDate"), mockReservationEvents.get(i).endDate);
//            assertEquals(mReservationEventsArray.get(i).get("seating"), mockReservationEvents.get(i).seating);
//        }
    }
}