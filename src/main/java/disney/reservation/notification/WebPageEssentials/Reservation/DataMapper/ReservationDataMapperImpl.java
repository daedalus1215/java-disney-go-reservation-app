package disney.reservation.notification.WebPageEssentials.Reservation.DataMapper;


import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser.Exception.ReservationParserException;
import disney.reservation.notification.WebPageEssentials.Reservation.Date.DataMapper.DateDataMapper;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ValueObject.Date;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser.ReservationParser;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ReservationEvent;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;


public class ReservationDataMapperImpl  implements ReservationDataMapper{
    private String locationOfReservations;
    private ArrayList<ReservationEvent> reservationEvents = new ArrayList<>();
    private ReservationParser reservationParser;
    private DateDataMapper dateDataMapper;


    public ReservationDataMapperImpl(ReservationParser reservationParser, DateDataMapper dateDataMapper) {
        this.locationOfReservations = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        this.reservationParser = reservationParser;
        this.dateDataMapper = dateDataMapper;
    }

    public ArrayList<ReservationEvent> load() throws java.text.ParseException, ReservationParserException {
        try {
            ArrayList<JSONObject> jsonReservationEvents = reservationParser.parse(this.locationOfReservations);
            for(JSONObject jsonReservationEvent:jsonReservationEvents) {
                ReservationEvent reservationEvent = new ReservationEvent();
                reservationEvent.url = (String) jsonReservationEvent.get("url");
                reservationEvent.name = (String) jsonReservationEvent.get("eventName");

                ArrayList<Date> dates = this.dateDataMapper.load(jsonReservationEvent);
                reservationEvent.dates = dates;
                this.reservationEvents.add(reservationEvent);
            }

            return this.reservationEvents;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new ReservationParserException("Invalid format for the Reservation Event: " + e.getMessage());
        }

        return this.reservationEvents;
    }
}
