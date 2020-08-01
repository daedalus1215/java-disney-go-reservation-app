package disney.reservation.notification.application;

import disney.reservation.notification.domain.WebPageEssentials.Requestor.PageRequestor;
import disney.reservation.notification.domain.WebPageEssentials.ReservationResolver;
import disney.reservation.notification.infrastructure.log.InfoLoggerAdapter;
import disney.reservation.notification.infrastructure.reservations.ReservationRepository;
import java.util.function.BiFunction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

final public class CheckForReservationAndEmail {

  final ApplicationContext serviceLocator =
      new AnnotationConfigApplicationContext(NotificationContext.class);

  public void apply() {
    final InfoLoggerAdapter logger = serviceLocator.getBean(InfoLoggerAdapter.class);
    final PageRequestor pageRequestor = serviceLocator.getBean(PageRequestor.class);
    final ReservationRepository reservationRepository =
        serviceLocator.getBean(ReservationRepository.class);

    final ReservationResolver reservationResolver =
        serviceLocator.getBean(ReservationResolver.class);

    final String subject = "testing now";
    final String body = "testing body now";
    final String url = "https://disneyworld.disney.go.com/dining/polynesian-resort/ohana/";

    try {
      reservationResolver
          .checkForAvailabilityAndEmail(reservationRepository.fetchAll(), pageRequestor);

    } catch (Exception e) {
      logger.info("Exception thrown: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
