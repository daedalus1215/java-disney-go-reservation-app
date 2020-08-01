package disney.reservation.notification.domain.utils;

import static java.util.Locale.ENGLISH;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//@TODO: If we inject logger, we can absorb the exception and make this a Functional Interface class.
public class GetNextDate {

  public String apply(String date, int interval) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", ENGLISH);
    final Date start = sdf.parse(date);
    final Calendar calendar = Calendar.getInstance();
    calendar.setTime(start);
    calendar.add(Calendar.DAY_OF_YEAR, interval);
    return sdf.format(calendar.getTime());
  }
}
