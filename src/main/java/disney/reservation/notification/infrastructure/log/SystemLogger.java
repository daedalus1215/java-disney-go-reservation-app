package disney.reservation.notification.infrastructure.log;

import disney.reservation.notification.domain.log.Logger;

public class SystemLogger implements Logger {

  @Override
  public void info(String message) {
    System.out.println(message);
  }
}
