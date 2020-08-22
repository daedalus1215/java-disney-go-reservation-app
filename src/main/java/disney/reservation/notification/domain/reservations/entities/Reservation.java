package disney.reservation.notification.domain.reservations.entities;

public class Reservation {

  private final String name;
  private final String url;
  private final int partySize;
  private final String startDate;
  private final String endDate;
  private final String time;

  public Reservation(String name, String url, int partySize, String startDate,
      String endDate, String time) {
    this.name = name;
    this.url = url;
    this.partySize = partySize;
    this.startDate = startDate;
    this.endDate = endDate;
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

  public String getStartDate() {
    return startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public String getTime() {
    return time;
  }
}
