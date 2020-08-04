package disney.reservation.notification.domain.WebPageEssentials.Reservation.DataMapper;

import disney.reservation.notification.domain.WebPageEssentials.Reservation.DataMapper.Parser.Exception.ReservationParserException;
import disney.reservation.notification.domain.WebPageEssentials.Reservation.Entity.Event;
import java.util.ArrayList;

public interface ReservationDataMapper {
    public ArrayList<Event> load() throws java.text.ParseException, ReservationParserException;
}
