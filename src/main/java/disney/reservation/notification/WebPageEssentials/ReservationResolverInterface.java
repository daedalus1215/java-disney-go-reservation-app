package disney.reservation.notification.WebPageEssentials;


import disney.reservation.notification.WebPageEssentials.Requestor.PageRequestor;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ReservationEvent;


import java.io.IOException;
import java.util.ArrayList;

public interface ReservationResolverInterface {
    void checkForAvailabilityAndEmail(ArrayList<ReservationEvent> reservationEvents, PageRequestor requestor) throws IOException;
}