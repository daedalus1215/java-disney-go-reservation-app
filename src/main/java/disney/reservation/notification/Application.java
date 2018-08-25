package disney.reservation.notification;

import disney.reservation.notification.Adapter.InfoLoggerAdapter;
import disney.reservation.notification.WebPageEssentials.Factory.ReservationResolverFactory;
import disney.reservation.notification.WebPageEssentials.Requestor.PageRequestor;
import disney.reservation.notification.WebPageEssentials.Requestor.Factory.PageRequestorFactoryForOhana;
import disney.reservation.notification.WebPageEssentials.ReservationResolver;
import config.UserCredentialConfig;

public class Application {

    public static void main(String[] args) {
        String subject = "testing now";
        String body = "testing body now";
        InfoLoggerAdapter logger = new InfoLoggerAdapter();
        sendFromGMail(logger, UserCredentialConfig.USERNAME, UserCredentialConfig.PASSWORD, UserCredentialConfig.RECIPIENT, subject, body);
    }

    private static void sendFromGMail(InfoLoggerAdapter logger, String from, String pass, String to, String subject, String body) {

        try {
            PageRequestor pageRequestor = (new PageRequestorFactoryForOhana()).createPageRequestor();

            pageRequestor.visitWebPage();

            ReservationResolver reservationResolver = new ReservationResolverFactory().createReservationResolver();

            reservationResolver.checkForAvailabilityAndEmail(pageRequestor);

        } catch (Exception e) {
            logger.info("Exception thrown: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
