package disney.reservation.notification.application;

import disney.reservation.notification.domain.WebPageEssentials.Requestor.PageRequestorInterface;
import disney.reservation.notification.domain.WebPageEssentials.ReservationResolver;
import disney.reservation.notification.domain.log.Logger;
import disney.reservation.notification.domain.reservations.assemblers.EventAssembler;
import disney.reservation.notification.domain.reservations.value_objects.Event;
import disney.reservation.notification.infrastructure.reservations.ReservationRepository;
import java.util.List;
import org.springframework.context.ApplicationContext;

final public class CheckForReservationAndEmail {

  private final ApplicationContext serviceLocator;

  public CheckForReservationAndEmail(ApplicationContext serviceLocator) {
    this.serviceLocator = serviceLocator;
  }

  public void apply() {
    System.out.println("CheckForReservationAndEmail: main.java");
    final ReservationRepository reservationRepository = serviceLocator
        .getBean(ReservationRepository.class);
    final EventAssembler eventAssembler = serviceLocator.getBean(EventAssembler.class);
    final List<Event> events = eventAssembler.apply(reservationRepository.fetchAll());

    final ReservationResolver reservationResolver = serviceLocator
        .getBean(ReservationResolver.class);

    final PageRequestorInterface pageRequestor = serviceLocator
        .getBean(PageRequestorInterface.class);

    reservationResolver.checkForAvailabilityAndEmail(events, pageRequestor);
  }
}
