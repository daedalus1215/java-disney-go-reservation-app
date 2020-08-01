package disney.reservation.notification.infrastructure.reservations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import disney.reservation.notification.application.NotificationContext;
import disney.reservation.notification.domain.reservations.entities.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @TODO: Make this some how tie into a docker spinning up the
 * instance of mongoDB. Cuz, right now I have the mongoDB instance
 * from the `react-disney-reservation-maker` project up to run this test.
 * It at least makes sure that
 * 1. The aforementioned project has had the mongo docker init script
 * kick off.
 * 2. That there is a test record in the database
 * 3. That the Repo is actually able to connect to it.
 */
class ReservationRepositoryIntegrationTest {

  final static private String EXPECTED_NAME = "testing reservation";
  final static private String EXPECTED_START_DATE = "4/14/2020";
  final static private String EXPECTED_END_DATE = "4/15/2020";
  final static private String EXPECTED_TIME = "10:00 AM";
  final static private String EXPECTED_URL = "a test url";
  final static private int EXPECTED_PARTYSIZE = 4;

  final private ApplicationContext applicationContext =
      new AnnotationConfigApplicationContext(NotificationContext.class);

  private ReservationRepository target;

  @BeforeEach
  public void setup() {
    target = applicationContext
        .getBean(ReservationRepository.class);
  }

  @Test
  public void fetchAll_shouldReturnExpectedReservation() {
    // Arrange

    // Act
    final Reservation actual = target.fetchAll()
        .get(0);

    // Assert
    assertEquals(EXPECTED_NAME, actual.getName());
    assertEquals(EXPECTED_START_DATE, actual.getStartDate());
    assertEquals(EXPECTED_END_DATE, actual.getEndDate());
    assertEquals(EXPECTED_TIME, actual.getTime());
    assertEquals(EXPECTED_URL, actual.getUrl());
    assertEquals(EXPECTED_PARTYSIZE, actual.getPartySize());
  }
}