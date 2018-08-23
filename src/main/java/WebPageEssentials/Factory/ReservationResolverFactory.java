package WebPageEssentials.Factory;

import Adapter.InfoLoggerAdapter;
import Adapter.MailerAdapter;
import WebPageEssentials.DateAggregator;
import WebPageEssentials.Reference.HtmlElementReferrer;
import WebPageEssentials.ReservationResolver;
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
