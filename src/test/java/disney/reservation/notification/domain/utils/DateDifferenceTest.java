package disney.reservation.notification.domain.utils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import disney.reservation.notification.infrastructure.log.FileLogger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateDifferenceTest {

  private FileLogger mockLogger;
  private DateDifference target;

  @BeforeEach
  public void setup() {
    mockLogger = mock(FileLogger.class);
    target = new DateDifference(mockLogger);
  }

  @Test
  public void apply_withValidDates_returnExpectedDifferenceInDates() {
    // Arrange
    final String startDate = "10/10/2020";
    final String endDate = "11/20/2020";
    final Integer expected = 41;

    // Act
    final Integer actual = target.apply(startDate, endDate);

    // Assert
    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void apply_withInvalidValidDates_returnNull() {
    // Arrange
    final String startDate = "1ds0";
    final String endDate = "11/120/2020";
    final String expected = "Issue with parsing dates: Unparseable date: \"".concat(startDate).concat("\"");

    // Act
    final Integer actual = target.apply(startDate, endDate);

    // Assert
    verify(mockLogger).info(expected);
    Assertions.assertNull(actual);
  }
}