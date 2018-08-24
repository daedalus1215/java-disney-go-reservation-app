import Adapter.InfoLoggerAdapter;
import WebPageEssentials.Factory.ReservationResolverFactory;
import WebPageEssentials.Requestor.PageRequestor;
import WebPageEssentials.Requestor.Factory.PageRequestorFactoryForOhana;
import WebPageEssentials.ReservationResolver;
import com.gargoylesoftware.htmlunit.html.*;
import config.UserCredentialConfig;


import java.util.ArrayList;

public class MainApp {

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
