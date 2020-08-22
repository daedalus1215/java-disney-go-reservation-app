package disney.reservation.notification.application.lumber;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class DecimalExpressionUnitTest {

  private final DecimalExpression target = new DecimalExpression();

  @Test
  public void apply_withPriceString_willReturnDecimal() {
    // Arrange
    final double expected = 4.45;

    // Act
    final BigDecimal actual = target.apply("$ 4.45 USD");

    // Assert
    assertThat(actual.doubleValue()).isEqualTo(expected);
  }

  @Test
  public void apply_withoutPriceString_willReturnNull() {
    // Arrange

    // Act
    final BigDecimal actual = target.apply("$ asdasdfsdf USD");

    // Assert
    assertThat(actual).isNull();
  }
}