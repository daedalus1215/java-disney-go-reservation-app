package disney.reservation.notification.application.lumber_price;

import org.testng.TestNG;

public class App {
  public static void main(String[] args) {
    TestNG test = new TestNG();
    test.setTestClasses(new Class[]{FetchPriceAction.class});
    test.run();
  }
}
