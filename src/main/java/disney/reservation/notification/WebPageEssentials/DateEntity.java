package disney.reservation.notification.WebPageEssentials;

/**
 * Stores the date stuff that we use to set and check against.
 */
public class DateEntity implements DateEntityInterface {
    public String date;
    public String time;
    public String seating;


    public DateEntity(String date, String time, String seating) {
        this.date = date;
        this.time = time;
        this.seating = seating;
    }

    public String toString() {
        return "DateEntity{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", seating=" + seating +
                '}';
    }
}
