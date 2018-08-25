package disney.reservation.notification.WebPageEssentials.Factory;

import disney.reservation.notification.Adapter.InfoLoggerAdapter;
import disney.reservation.notification.Adapter.MailerAdapter;
import disney.reservation.notification.WebPageEssentials.DateAggregator;
import disney.reservation.notification.WebPageEssentials.Reference.HtmlElementReferrer;
import disney.reservation.notification.WebPageEssentials.ReservationResolver;
import config.UserCredentialConfig;

import javax.mail.MessagingException;

public class ReservationResolverFactory {

    public ReservationResolver createReservationResolver() throws MessagingException {
        MailerAdapter mailerAdapter = new MailerAdapter(UserCredentialConfig.USERNAME, UserCredentialConfig.PASSWORD, UserCredentialConfig.RECIPIENT);
        HtmlElementReferrer htmlElementReferrer = new HtmlElementReferrer();
        DateAggregator dateAggregator = (new DateAggregatorFactory()).createAggregation();
        InfoLoggerAdapter infoLoggerAdapter = new InfoLoggerAdapter();

        return new ReservationResolver(mailerAdapter, htmlElementReferrer, dateAggregator, infoLoggerAdapter);
    }
}
