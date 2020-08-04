package disney.reservation.notification.domain.WebPageEssentials;


import disney.reservation.notification.domain.WebPageEssentials.Requestor.PageRequestorInterface;
import disney.reservation.notification.domain.reservations.value_objects.Event;
import java.util.List;

public interface ReservationResolver {

    void checkForAvailabilityAndEmail(List<Event> reservationEvents,
        PageRequestorInterface requestor);
}