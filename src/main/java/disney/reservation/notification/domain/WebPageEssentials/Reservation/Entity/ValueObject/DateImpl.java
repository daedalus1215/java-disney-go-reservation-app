package disney.reservation.notification.domain.WebPageEssentials.Reservation.Entity.ValueObject;

public class DateImpl implements Date {

    public String date;
    public String time;
    public String seating;


    public DateImpl(String date, String time, String seating) {
        this.date = date;
        this.time = time;
        this.seating = seating;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getTime() {
        return time;
    }

    @Override
    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String getSeating() {
        return seating;
    }

    @Override
    public void setSeating(String seating) {
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
