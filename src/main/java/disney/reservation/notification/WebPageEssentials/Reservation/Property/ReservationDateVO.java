package disney.reservation.notification.WebPageEssentials.Reservation.Property;


final public class ReservationDateVO implements ReservationDateInterface {
    private String date;
    private String time;
    private String seating;


    public ReservationDateVO(String date, String time, String seating) {
        this.date = date;
        this.time = time;
        this.seating = seating;
    }

    public String getDate() {
        return date;
    }


    public String getTime() {
        return time;
    }


    public String getSeating() {
        return seating;
    }


    public String toString() {
        return "DateEntity{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", seating=" + seating +
                '}';
    }
}
