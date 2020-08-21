package disney.reservation.notification.infrastructure.WebPageEssentials.Reservation.DataMapper.Parser;


import org.json.simple.JSONObject;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ReservationEventMockFactory {

    public static JSONObject createStub(String url, String startDate, String endDate, String seating) {
        JSONObject ReservationEvent = mock(JSONObject.class);
        when(ReservationEvent.get("url")).thenReturn(url);
        when(ReservationEvent.get("startDate")).thenReturn(startDate);
        when(ReservationEvent.get("2")).thenReturn(endDate);
        when(ReservationEvent.get("seating")).thenReturn(seating);
        when(ReservationEvent.get("eventName")).thenReturn("testing-event-name");
        return ReservationEvent;
    }
}
