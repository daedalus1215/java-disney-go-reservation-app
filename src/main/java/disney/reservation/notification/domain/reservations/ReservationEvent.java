package disney.reservation.notification.domain.reservations;

final public class ReservationEvent {

  final private String name;
  final private String url;
  final private int partySize;
  final private String date;
  final private String time;

  public ReservationEvent(String name, String url, int partySize, String date, String time) {
    this.name = name;
    this.url = url;
    this.partySize = partySize;
    this.date = date;
    this.time = time;
  }

  public String getName() {
    return name;
  }

  public String getUrl() {
    return url;
  }

  public int getPartySize() {
    return partySize;
  }

  public String getDate() {
    return date;
  }

  public String getTime() {
    return time;
  }
}
