package disney.reservation.notification;

import disney.reservation.notification.Adapter.Logger.InfoLoggerAdapter;
import disney.reservation.notification.WebPageEssentials.Requestor.PageRequestor;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser.Exception.ReservationParserException;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.ReservationDataMapper;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.ReservationDataMapperImpl;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ReservationEvent;
import disney.reservation.notification.WebPageEssentials.ReservationResolver;
import config.UserCredentialConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        String subject = "testing now";
        String body = "testing body now";
        InfoLoggerAdapter logger = new InfoLoggerAdapter();
        sendFromGMail(
                logger,
                UserCredentialConfig.USERNAME,
                UserCredentialConfig.PASSWORD,
                UserCredentialConfig.RECIPIENT,
                subject,
                body
        );
    }

    private static void sendFromGMail(InfoLoggerAdapter logger, String from, String pass, String to, String subject, String body) {
        String url = "https://disneyworld.disney.go.com/dining/polynesian-resort/ohana/";

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(NotificationContext.class);
        try {
            PageRequestor pageRequestor = applicationContext.getBean(PageRequestor.class);
            ReservationDataMapper dataMapper = applicationContext.getBean(ReservationDataMapperImpl.class);
            ArrayList<ReservationEvent> events = dataMapper.load();

            // visit the site //@todo: moved this over to the Resolver.
//            pageRequestor.visitWebPage(url);

            ReservationResolver reservationResolver = applicationContext.getBean(ReservationResolver.class);

            reservationResolver.checkForAvailabilityAndEmail(events, pageRequestor);

        } catch (Exception e) {
            logger.info("Exception thrown: " + e.getMessage());
            e.printStackTrace();
        } catch (ReservationParserException e) {
            e.printStackTrace();
        }
    }


}
