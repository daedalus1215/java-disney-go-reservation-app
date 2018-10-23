package disney.reservation.notification.WebPageEssentials.Reservation.DataMapper;


import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser.Exception.ReservationParserException;
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


    public ReservationDataMapperImpl(ReservationParser reservationParser) {
        this.locationOfReservations = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        this.reservationParser = reservationParser;
    }

    //@todo: log errors here.

    @Override
    public ArrayList<ReservationEvent> fetchReservationEvents() {
        try {
            ArrayList<JSONObject> jsonReservationEvents = reservationParser.parse(this.locationOfReservations);
            for(JSONObject jsonReservationEvent:jsonReservationEvents) {
                ReservationEvent reservationEvent = new ReservationEvent();
                reservationEvent.url = (String) jsonReservationEvent.get("url");
                reservationEvent.startDate = (String) jsonReservationEvent.get("startDate");
                reservationEvent.endDate = (String) jsonReservationEvent.get("endDate");
                reservationEvent.seating = (String) jsonReservationEvent.get("seating");
                this.reservationEvents.add(reservationEvent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ReservationParserException e) {
            e.printStackTrace();
        }

        return this.reservationEvents;
    }
}
