package disney.reservation.notification.WebPageEssentials;

import disney.reservation.notification.WebPageEssentials.Requestor.PageRequestor;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ValueObject.Date;

import java.util.ArrayList;

public interface ReservationResolverInterface {
    void checkForAvailabilityAndEmail(ArrayList<Date> dates, PageRequestor requestor) throws Exception;
}
