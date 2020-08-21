package disney.reservation.notification.domain.reservations.assemblers;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import disney.reservation.notification.domain.reservations.entities.Reservation;
import disney.reservation.notification.domain.reservations.value_objects.Event;
import disney.reservation.notification.domain.reservations.utils.DateDifference;
import disney.reservation.notification.domain.reservations.utils.GetNextDate;
import disney.reservation.notification.infrastructure.log.FileLogger;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventAssemblerTest {

  private EventAssembler target;

  /**
   * Not mocking here, rather just test all the pieces straight through as if it was all one unit.
   * TBH, these 2 classes prob should just live in the same package, it would indicate a "functional
   * cohesive" structure (Larry Constantine).
   */
  @BeforeEach
  public void setup() {
    // @TODO: I probs should create a NullLoggerAdapter. No need to use the real one straight.
    final DateDifference dateDifference = new DateDifference(new FileLogger());
    final GetNextDate getNextDate = new GetNextDate(new FileLogger());
    this.target = new EventAssembler(dateDifference, getNextDate);
  }

  @Test
  public void apply_withReservations_willReturnReservationEvents() {
    // Arrange
    List<Reservation> reservations = asList(
        new Reservation(
            "name",
            "url",
            4,
            "10/01/2020",
            "10/05/2020",
            "10:00"
        ),
        new Reservation(
            "name",
            "url",
            4,
            "10/11/2020",
            "10/16/2020",
            "10:00"
        ));

    // Act
    final List<Event> actual = target.apply(reservations);

    //@TODO: Circle back to test the other fields. The piece I wanted to make sure was working was the
    //@TODO: date exploding that essentially happens with the difference between `startDate` and `endDate`.
    assertThat(actual)
        .extracting(Event::getDate)
        .containsOnlyOnce("10/01/2020", "10/02/2020", "10/03/2020", "10/04/2020", "10/05/2020",
            "10/11/2020", "10/12/2020", "10/13/2020", "10/14/2020", "10/15/2020", "10/16/2020");
  }
}