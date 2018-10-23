package disney.reservation.notification.WebPageEssentials.Reservation.DataMapper;

//import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ReservationEvent;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ReservationEvent;
import java.util.ArrayList;

public interface ReservationDataMapper {
    public ArrayList<ReservationEvent> fetchReservationEvents();
}
