package disney.reservation.notification.application;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import config.AppConfig;
import disney.reservation.notification.domain.log.Logger;
import disney.reservation.notification.domain.reservations.assemblers.EventAssembler;
import disney.reservation.notification.domain.utils.DateDifference;
import disney.reservation.notification.domain.utils.GetNextDate;
import disney.reservation.notification.infrastructure.reservations.ReservationRepository;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class NotificationContextTest {

  @Autowired
  final private NotificationContext target = new NotificationContext();

  @Test
  void givenAppContext_whenInjected_shouldNotBeNull() {
    // Arrange

    // Act

    // Assert
    assertNotNull(target);
  }

  @Test
  void registerLoggerAdapter__shouldReturnLogger() {
    // Arrange

    // Act
    final Logger actual = target.registerLoggerAdapter();

    // Assert
    assertNotNull(actual);
  }

  @Test
  void registerAppConfig_shouldReturnAppConfig() throws IOException {
    // Arrange

    // Act
    final AppConfig actual = target.registerAppConfig();

    // Assert
    assertNotNull(actual);
  }

  @Test
  void registerMongoClient_shouldReturnMongoClient() throws Exception {
    // Arrange

    // Act
    final MongoClient actual = target.registerMongoClient();

    // Assert
    assertNotNull(actual);
  }

  @Test
  void registerMongoClient_shouldReturnMongoDatabase() throws Exception {
    // Arrange

    // Act
    final MongoDatabase actual = this.target.registerMongoDatabase();

    // Assert
    assertNotNull(actual);
  }

  @Test
  void registerReservationRepository_shouldReturnMongoDatabase() throws Exception {
    // Arrange

    // Act
    final ReservationRepository actual = this.target.registerReservationRepository();

    // Assert
    assertNotNull(actual);
  }

  @Test
  void registerDateDifference_shouldReturnDateDifference() {
    // Arrange

    // Act
    final DateDifference actual = this.target.registerDateDifference();

    // Assert
    assertNotNull(actual);
  }

  @Test
  void registerReservationEventAssembler_shouldReturnReservationEventAssembler() throws Exception {
    // Arrange

    // Act
    final EventAssembler actual = this.target.registerReservationEventAssembler();

    // Assert
    assertNotNull(actual);
  }

  @Test
  void registerGetNextDate_shouldReturnReservationEventAssembler() {
    // Arrange

    // Act
    final GetNextDate actual = this.target.registerGetNextDate();

    // Assert
    assertNotNull(actual);
  }
}