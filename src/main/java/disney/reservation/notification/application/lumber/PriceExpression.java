package disney.reservation.notification.application.lumber;

import static java.util.regex.Pattern.compile;

import java.math.BigDecimal;
import java.util.function.Function;
import java.util.regex.Matcher;

public class PriceExpression implements Function<String, BigDecimal> {

  private static final String DECIMAL_EXPRESSION = "[0-9].[0-9]+|[0-9]+";

  public BigDecimal apply(final String priceWithDollar) {
    final Matcher matcher = compile(DECIMAL_EXPRESSION)
        .matcher(priceWithDollar);

    if (matcher.find()) {
      final String group = matcher.group();
      return new BigDecimal(group);
    }
    return null;
  }
}