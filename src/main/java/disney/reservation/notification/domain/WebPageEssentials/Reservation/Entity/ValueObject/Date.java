package disney.reservation.notification.domain.WebPageEssentials.Reservation.Entity.ValueObject;

public interface Date {
    String getDate();

    void setDate(String date);

    String getTime();

    void setTime(String time);

    String getSeating();

    void setSeating(String seating);

    String toString();
}
