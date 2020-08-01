package disney.reservation.notification.domain.reservations.assemblers;

import static org.mockito.Mockito.mock;

import disney.reservation.notification.domain.utils.DateDifference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservationEventAssemblerTest {

  private DateDifference mockDateDifference;
  private ReservationEventAssembler target;

  @BeforeEach
  public void setup() {
    this.mockDateDifference = mock(DateDifference.class);
    this.target = new ReservationEventAssembler(mockDateDifference);
  }

  @Test
  public void apply_withReservations_willReturnReservationEvents() {
    // Arrange
    target.apply()
        // Act
    // Assert
  }
}