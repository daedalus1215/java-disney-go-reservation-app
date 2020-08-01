package disney.reservation.notification.domain.reservations.assemblers;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.of;

import disney.reservation.notification.domain.reservations.entities.Reservation;
import disney.reservation.notification.domain.reservations.value_objects.ReservationEvent;
import disney.reservation.notification.domain.utils.DateDifference;
import disney.reservation.notification.domain.utils.GetNextDate;
import java.text.ParseException;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class ReservationEventAssembler implements
    Function<List<Reservation>, List<ReservationEvent>> {

  final private DateDifference dateDifference;
  final private GetNextDate getNextDate = new GetNextDate();

  public ReservationEventAssembler(
      DateDifference dateDifference) {
    this.dateDifference = dateDifference;
  }

  @Override
  public List<ReservationEvent> apply(List<Reservation> reservations) {
    return reservations.stream()
        .flatMap(reservation -> Objects.requireNonNull(assembleEvents(reservation)).stream())
        .collect(toList());
  }

  /**
   * Take a Reservation and turn it into multiple ReservationEvents.
   *
   * @param reservation Reservation that came from the database
   * @return a list of ReservationEvents, one event per day, where the day is some day between
   * the startDate (including) and the endDate (including)
   */
  private List<ReservationEvent> assembleEvents(Reservation reservation) {

    final String startDate = reservation.getStartDate();
    final String endDate = reservation.getEndDate();

    List<ReservationEvent> events = asList(createEvent(reservation, startDate));

    events.addAll(of(1, dateDifference.apply(startDate, endDate))
        .mapToObj(i -> {
          try {
            final String nextDate = getNextDate.apply(startDate, i);
            return createEvent(reservation, nextDate);
          } catch (ParseException e) {
            e.printStackTrace();
          }
          return null;
        })
        .collect(toList())
    );

    return events;
  }

  private ReservationEvent createEvent(Reservation reservation, String date) {
    return new ReservationEvent(reservation.getName(),
        reservation.getUrl(),
        reservation.getPartySize(),
        reservation.getTime(),
        date);
  }
}
