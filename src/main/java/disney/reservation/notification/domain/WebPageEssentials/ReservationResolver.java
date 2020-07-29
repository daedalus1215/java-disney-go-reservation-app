package disney.reservation.notification.domain.WebPageEssentials;


import disney.reservation.notification.domain.WebPageEssentials.Requestor.PageRequestor;
import disney.reservation.notification.domain.WebPageEssentials.Reservation.Entity.ReservationEvent;


import java.util.ArrayList;

public interface ReservationResolver {
    void checkForAvailabilityAndEmail(ArrayList<ReservationEvent> reservationEvents,
                                      PageRequestor requestor) throws Exception;
}