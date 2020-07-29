package disney.reservation.notification.domain.WebPageEssentials.Reservation.Entity;


import disney.reservation.notification.domain.WebPageEssentials.Reservation.Entity.ValueObject.Date;
import java.util.ArrayList;

/**
 * ReservationEvent, it should have the URL, the dates, and a name associated with every ReservationEvent.
 */
public class ReservationEvent {
    /**
     * @var url: the url for the reservation.
     */
    public String url;
    /**
     * @var name: name of this reservation.
     */
    public String name;
    /**
     * @var dates: the dates we want to reserve.
     */
    public ArrayList<Date> dates;


    /**
     * Not sure if we even need this.
     * @return ReservationEvent
     */
    public ReservationEvent clone() {
        ReservationEvent newEvent = new ReservationEvent();
        newEvent.url = this.url;
        newEvent.name = this.name;
        newEvent.dates = this.dates;
        return newEvent;
    }
}
