package disney.reservation.notification.domain.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import org.junit.jupiter.api.Test;

class GetNextDateTest {
  private GetNextDate target = new GetNextDate();

  @Test
  public void apply() throws ParseException {
    final String actual = target.apply("10/11/2020");
    assertEquals("10/12/2020", actual);
  }
}