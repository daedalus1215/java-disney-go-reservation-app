package disney.reservation.notification.domain.WebPageEssentials.Reservation.DataMapper;


import disney.reservation.notification.domain.WebPageEssentials.Reservation.DataMapper.Parser.Exception.ReservationParserException;
import disney.reservation.notification.domain.WebPageEssentials.Reservation.DataMapper.Parser.ReservationParser;
import disney.reservation.notification.domain.WebPageEssentials.Reservation.Date.DataMapper.DateDataMapper;
import disney.reservation.notification.domain.WebPageEssentials.Reservation.Entity.Event;
import disney.reservation.notification.domain.WebPageEssentials.Reservation.Entity.ValueObject.Date;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;


public class ReservationDataMapperImpl  implements ReservationDataMapper{
    private String locationOfReservations;
    private ArrayList<Event> events = new ArrayList<>();
    private ReservationParser reservationParser;
    private DateDataMapper dateDataMapper;


    public ReservationDataMapperImpl(ReservationParser reservationParser, DateDataMapper dateDataMapper) {
        this.locationOfReservations = FileSystems.getDefault()
            .getPath("")
            .toAbsolutePath()
            .toString();
        this.reservationParser = reservationParser;
        this.dateDataMapper = dateDataMapper;
    }

    public ArrayList<Event> load() throws java.text.ParseException, ReservationParserException {
        try {
            ArrayList<JSONObject> jsonReservationEvents = reservationParser.parse(this.locationOfReservations);
            for(JSONObject jsonReservationEvent:jsonReservationEvents) {
                Event event = new Event();
                event.url = (String) jsonReservationEvent.get("url");
                event.name = (String) jsonReservationEvent.get("eventName");

                ArrayList<Date> dates = this.dateDataMapper.load(jsonReservationEvent);
                event.dates = dates;
                this.events.add(event);
            }

            return this.events;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new ReservationParserException("Invalid format for the Reservation Event: " + e.getMessage());
        }

        return this.events;
    }
}
