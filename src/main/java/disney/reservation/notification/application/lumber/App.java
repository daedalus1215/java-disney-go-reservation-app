package disney.reservation.notification.application.lumber;

public class App {
  public static void main(String[] args) throws Exception {
    System.out.println("Starting");
    new FetchPriceAction().apply();
  }
}
