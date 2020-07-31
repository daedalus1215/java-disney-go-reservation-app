package disney.reservation.notification.application;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import config.AppConfig;
import disney.reservation.notification.infrastructure.log.InfoLoggerAdapter;
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
    final InfoLoggerAdapter actual = target.registerLoggerAdapter();

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
}