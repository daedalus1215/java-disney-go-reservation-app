package config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class UserCredentialConfigTest {

  @Test
  public void constructor_willConfigWithoutException() throws IOException {
    // Arrange
    final UserCredentialConfig target = new UserCredentialConfig();

    // Act

    // Assert - no exception thrown
  }

  @Test
  public void getDatabaseUser_willReturnUserNameFromConfig() throws IOException {
    // Arrange
    final UserCredentialConfig target = new UserCredentialConfig();
    String expected = "admin.user";

    // Act
    String actual = target.getDatabaseUser();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void getDbPassword_willReturnUserPasswordFromConfig() throws IOException {
    // Arrange
    final UserCredentialConfig target = new UserCredentialConfig();
    String expected = "admin.password";

    // Act
    String actual = target.getDbPassword();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void getDb_willReturnDbFromConfig() throws IOException {
    // Arrange
    final UserCredentialConfig target = new UserCredentialConfig();
    String expected = "reservations";

    // Act
    String actual = target.getDb();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void getDbHost_willReturnDbHostFromConfig() throws IOException {
    // Arrange
    final UserCredentialConfig target = new UserCredentialConfig();
    String expected = "localhost";

    // Act
    String actual = target.getDbHost();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void getDbPort_willReturnDbPortFromConfig() throws IOException {
    // Arrange
    final UserCredentialConfig target = new UserCredentialConfig();
    String expected = "27018";

    // Act
    String actual = target.getDbPort();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void getEmailUsername_willReturnEmailUsernameFromConfig() throws IOException {
    // Arrange
    final UserCredentialConfig target = new UserCredentialConfig();
    String expected = "emailAccountWeWillSendFrom";

    // Act
    String actual = target.getEmailUsername();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void getEmailPassword_willReturnEmailPasswordFromConfig() throws IOException {
    // Arrange
    final UserCredentialConfig target = new UserCredentialConfig();
    String expected = "emailAccountPassword";

    // Act
    String actual = target.getEmailPassword();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  public void getRecipient_willReturnRecipientFromConfig() throws IOException {
    // Arrange
    final UserCredentialConfig target = new UserCredentialConfig();
    String expected = "phoneNumberWeWillText/Email";

    // Act
    String actual = target.getRecipient();

    // Assert
    assertEquals(expected, actual);
  }
}