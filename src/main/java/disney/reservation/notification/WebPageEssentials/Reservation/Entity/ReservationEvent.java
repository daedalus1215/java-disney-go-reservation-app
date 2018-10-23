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
}
