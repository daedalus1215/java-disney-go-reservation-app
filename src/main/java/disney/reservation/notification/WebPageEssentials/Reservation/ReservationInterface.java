package disney.reservation.notification.WebPageEssentials.Reservation;

import disney.reservation.notification.WebPageEssentials.Reservation.Property.ReservationDateInterface;

import java.util.ArrayList;

public interface ReservationInterface {
    public String getUrl();
    public ArrayList<ReservationDateInterface> getReservationDates();
}
