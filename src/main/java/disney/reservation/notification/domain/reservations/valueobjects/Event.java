package disney.reservation.notification.domain.reservations.valueobjects;

public final class Event {

  private final String name;
  private final String url;
  private final int partySize;
  private final String date;
  private final String time;

  public Event(String name, String url, int partySize, String date, String time) {
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
