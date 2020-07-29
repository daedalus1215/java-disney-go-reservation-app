package disney.reservation.notification.application;

import disney.reservation.notification.domain.reservations.Reservation;
import disney.reservation.notification.infrastructure.reservations.ReservationRepository;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * If we want to make sure we are wired into a mongo database and that there is a table of
 * reservations
 * <p>
 * It is also showing how we will use the mongoDB with Repository-like adapters.
 */
public class ApplicationToTestReservationRepository {

  public static void main(String[] args) {
    final ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(NotificationContext.class);

    ReservationRepository reservationRepository = applicationContext
        .getBean(ReservationRepository.class);
    List<Reservation> reservations = reservationRepository.fetchAll();

    //@TODO: Prob make a test out of this.
    System.out.println("Name should be 'testing reservation': ".concat(reservations.get(0).getName()));
  }
}
