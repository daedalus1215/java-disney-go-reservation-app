package disney.reservation.notification.WebPageEssentials.Reservation.Entity;


import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ValueObject.Date;
import java.util.ArrayList;


public class ReservationEvent {
    public String url;
    public String startDate;
    public String endDate;
    public String time;
    public String seating;
    public ArrayList<Date> dates;


    public ReservationEvent clone() {

        ReservationEvent newEvent = new ReservationEvent();
        newEvent.url = this.url;
        newEvent.startDate = this.startDate;
        newEvent.endDate = this.endDate;
        newEvent.time = this.time;
        newEvent.dates = this.dates;

        return newEvent;
    }
}
