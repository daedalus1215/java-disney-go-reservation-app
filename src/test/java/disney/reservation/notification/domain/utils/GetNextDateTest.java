package disney.reservation.notification.domain.utils;

import static org.junit.jupiter.api.Assertions.*;

import disney.reservation.notification.infrastructure.log.FileLogger;
import java.text.ParseException;
import org.junit.jupiter.api.Test;

class GetNextDateTest {
  private GetNextDate target = new GetNextDate(new FileLogger());

  @Test
  public void apply_withADateAndIntervalOfOne_willReturnNextDate() throws ParseException {
    final String actual = target.apply("10/11/2020", 1);
    assertEquals("10/12/2020", actual);
  }
  //@TODO: Can test the exception throwing.
}