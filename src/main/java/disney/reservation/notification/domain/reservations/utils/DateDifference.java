package disney.reservation.notification.domain.reservations.utils;

import static java.lang.Math.toIntExact;
import static java.util.Locale.ENGLISH;

import disney.reservation.notification.domain.log.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

public class DateDifference implements BiFunction<String, String, Integer> {

  private final Logger logger;

  public DateDifference(Logger infoLoggerAdapter) {
    this.logger = infoLoggerAdapter;
  }

  @Override
  public Integer apply(String startDate, String endDate) {
    final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", ENGLISH);
    try {
      final Date start = sdf.parse(startDate);
      final Date end = sdf.parse(endDate);
      final long diffInMillies = Math.abs(end.getTime() - start.getTime());
      return toIntExact(TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS));
    } catch (ParseException e) {
      logger.info("Issue with parsing dates: " + e.getMessage());
    }

    return null;
  }
}
