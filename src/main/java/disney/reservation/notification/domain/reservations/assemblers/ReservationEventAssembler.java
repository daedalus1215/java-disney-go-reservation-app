package disney.reservation.notification.domain.reservations.assemblers;

import static java.util.stream.Collectors.toList;

import disney.reservation.notification.domain.reservations.entities.Reservation;
import disney.reservation.notification.domain.reservations.value_objects.ReservationEvent;
import disney.reservation.notification.domain.utils.DateDifference;
import java.util.List;

public class ReservationEventAssembler {

  final private DateDifference dateDifference;

  public ReservationEventAssembler(
      DateDifference dateDifference) {
    this.dateDifference = dateDifference;
  }

  public List<ReservationEvent> assemble(List<Reservation> reservations) {
    return reservations.stream()
        .map(reservation -> {
          final String startDate = reservation.getStartDate();
          final String endDate = reservation.getEndDate();

          //@TODO: Need to wire in DateDifference into the Context
          //@TODO: Need to use it here.
          return new ReservationEvent("n", "n", 1, "n", "n");
        })
        .collect(toList());
  }
}
