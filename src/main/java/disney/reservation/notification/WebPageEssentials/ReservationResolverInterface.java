package disney.reservation.notification.WebPageEssentials;

import disney.reservation.notification.WebPageEssentials.Requestor.PageRequestor;

public interface ReservationResolverInterface {
    void checkForAvailabilityAndEmail(PageRequestor requestor) throws Exception;
}
