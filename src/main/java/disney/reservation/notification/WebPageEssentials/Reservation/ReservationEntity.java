package disney.reservation.notification.WebPageEssentials.Reservation;

import disney.reservation.notification.WebPageEssentials.Reservation.Property.ReservationDateInterface;

import java.util.ArrayList;

final public class ReservationEntity implements ReservationInterface {
    private ArrayList<ReservationDateInterface> reservationDates = new ArrayList<ReservationDateInterface>();
    private String url;

    public ReservationEntity(ArrayList<ReservationDateInterface> reservationDates, String url) {
        this.reservationDates = reservationDates;
        this.url = url;
    }

    public ReservationEntity(ReservationDateInterface reservationDate, String url) {
        this.reservationDates.add(reservationDate);
        this.url = url;
    }

    public ArrayList<ReservationDateInterface> getReservationDates() {
        return reservationDates;
    }

    public String getUrl() {
        return url;
    }
}
