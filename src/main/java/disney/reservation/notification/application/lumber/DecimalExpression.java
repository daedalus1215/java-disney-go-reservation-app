package disney.reservation.notification.application.lumber;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecimalExpression implements Function<String, Integer> {

    public Integer apply(final String priceValue) {
        final Matcher matcher = Pattern.compile("[0-9].[0-9]+|[0-9]+").matcher(priceValue);
        if (matcher.find()) {
            final String group = matcher.group();
            return Integer.getInteger(group);
        }
        return null;
    }
}