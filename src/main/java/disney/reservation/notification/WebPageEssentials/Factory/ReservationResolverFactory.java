package disney.reservation.notification.WebPageEssentials.Factory;

import disney.reservation.notification.Adapter.InfoLoggerAdapter;
import disney.reservation.notification.Adapter.MailerAdapter;
import disney.reservation.notification.WebPageEssentials.DateEntity;
import disney.reservation.notification.WebPageEssentials.Reference.HtmlElementReferrer;
import disney.reservation.notification.WebPageEssentials.ReservationResolver;
import config.UserCredentialConfig;

import javax.mail.MessagingException;
import java.util.ArrayList;

public class ReservationResolverFactory implements ReservationResolverFactoryInterface {

    public ReservationResolver createReservationResolver() throws MessagingException {
        MailerAdapter mailerAdapter = new MailerAdapter(UserCredentialConfig.USERNAME, UserCredentialConfig.PASSWORD, UserCredentialConfig.RECIPIENT);
        HtmlElementReferrer htmlElementReferrer = new HtmlElementReferrer();
        ArrayList<DateEntity> dateEntityAggregation = (new DateEntityForSeptemberDinnerFactory()).createEntityArrayList();
        InfoLoggerAdapter infoLoggerAdapter = new InfoLoggerAdapter();

        return new ReservationResolver(mailerAdapter, htmlElementReferrer, dateEntityAggregation, infoLoggerAdapter);
    }
}
