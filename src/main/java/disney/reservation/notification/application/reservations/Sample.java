package disney.reservation.notification.application.reservations;

import disney.reservation.notification.application.reservations.Example1;
import org.testng.TestNG;

public class Sample {
  public static void main(String[] args) throws ClassNotFoundException {
    TestNG test = new TestNG();
    test.setTestClasses(new Class[] { Example1.class });
    test.run();
  }
}