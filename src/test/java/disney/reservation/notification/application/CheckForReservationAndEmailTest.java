package disney.reservation.notification.application;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import disney.reservation.notification.domain.WebPageEssentials.Requestor.PageRequestorInterface;
import disney.reservation.notification.domain.WebPageEssentials.ReservationResolver;
import disney.reservation.notification.domain.log.Logger;
import disney.reservation.notification.domain.reservations.assemblers.EventAssembler;
import disney.reservation.notification.domain.reservations.entities.Reservation;
import disney.reservation.notification.domain.reservations.value_objects.Event;
import disney.reservation.notification.infrastructure.reservations.ReservationRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

class CheckForReservationAndEmailTest {

  final private ApplicationContext mockServiceLocator = mock(ApplicationContext.class);
  private CheckForReservationAndEmail target;

  @BeforeEach
  public void setup() {
    target = new CheckForReservationAndEmail(mockServiceLocator);
  }

  @Test
  public void apply_willInvokeEverythingAsExpected() throws Exception {
    // Arrange
    final Logger mockLogger = mock(Logger.class);
    final PageRequestorInterface mockPageRequestor = mock(PageRequestorInterface.class);
    final ReservationRepository mockReservationRepository = mock(ReservationRepository.class);
    final ReservationResolver mockReservationResolver = mock(ReservationResolver.class);
    final List<Reservation> reservations = asList(
        new Reservation("name",
            "url",
            3,
            "date",
            "date",
            "time"));
    when(mockReservationRepository.fetchAll()).thenReturn(reservations);

    final List<Event> events = asList(new Event("name", "url", 3, "date", "time"));
    final EventAssembler mockEventAssembler = mock(EventAssembler.class);
    when(mockEventAssembler.apply(reservations)).thenReturn(events);

    when(mockServiceLocator.getBean(Logger.class)).thenReturn(mockLogger);
    when(mockServiceLocator.getBean(PageRequestorInterface.class)).thenReturn(mockPageRequestor);
    when(mockServiceLocator.getBean(ReservationRepository.class))
        .thenReturn(mockReservationRepository);
    when(mockServiceLocator.getBean(EventAssembler.class)).thenReturn(mockEventAssembler);
    when(mockServiceLocator.getBean(ReservationResolver.class)).thenReturn(mockReservationResolver);

    // Act
    target.apply();

    // Assert
    verify(mockReservationResolver).checkForAvailabilityAndEmail(events, mockPageRequestor);
  }

  //@TODO: Write test for the exception case
}