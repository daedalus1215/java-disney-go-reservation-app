package WebPageEssentials;

/**
 * Stores the date stuff that we use to set and check against.
 */
public class DateEntity {
    public String date;
    public String time;
    public int seating;

    public DateEntity(String date, String time, int seating) {
        this.date = date;
        this.time = time;
        this.seating = seating;
    }

    @Override
    public String toString() {
        return "DateEntity{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", seating=" + seating +
                '}';
    }
}
