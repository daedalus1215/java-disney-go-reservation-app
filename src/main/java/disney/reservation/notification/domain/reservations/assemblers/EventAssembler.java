package disney.reservation.notification.domain.reservations.assemblers;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

import disney.reservation.notification.domain.reservations.entities.Reservation;
import disney.reservation.notification.domain.reservations.value_objects.Event;
import disney.reservation.notification.domain.utils.DateDifference;
import disney.reservation.notification.domain.utils.GetNextDate;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class EventAssembler implements
    Function<List<Reservation>, List<Event>> {

  final private DateDifference dateDifference;
  final private GetNextDate getNextDate;

  public EventAssembler(
      DateDifference dateDifference, GetNextDate getNextDate) {
    this.dateDifference = dateDifference;
    this.getNextDate = getNextDate;
  }

  @Override
  public List<Event> apply(List<Reservation> reservations) {
    return reservations.stream()
        .flatMap(reservation -> Objects.requireNonNull(assembleEvents(reservation)).stream())
        .collect(toList());
  }

  /**
   * Take a Reservation and turn it into multiple Events.
   *
   * @param reservation Reservation that came from the database
   * @return a list of Events, one event per day, where the day is some day between the startDate
   * (including) and the endDate (including)
   */
  private List<Event> assembleEvents(Reservation reservation) {
    final String startDate = reservation.getStartDate();
    final String endDate = reservation.getEndDate();
    final Integer diff = dateDifference.apply(startDate, endDate);

    final List<Event> events = rangeClosed(1, diff)
        .mapToObj(i -> {
          final String nextDate = getNextDate.apply(startDate, i);
          return createEvent(reservation, nextDate);
        })
        .collect(toList());

    events.add(createEvent(reservation, startDate));

    return events;
  }

  private Event createEvent(Reservation reservation, String date) {
    return new Event(reservation.getName(),
        reservation.getUrl(),
        reservation.getPartySize(),
        date,
        reservation.getTime());
  }
}
