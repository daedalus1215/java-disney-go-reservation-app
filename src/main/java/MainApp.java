import Adapter.InfoLoggerAdapter;
import Adapter.MailerAdapter;
import config.UserCredentialConfig;

import javax.mail.*;
import javax.mail.internet.*;

public class MainApp {

    public static void main(String[] args) {
        String subject = "testing now";
        String body = "testing body now";
        InfoLoggerAdapter logger = new InfoLoggerAdapter();
        sendFromGMail(logger, UserCredentialConfig.USERNAME, UserCredentialConfig.PASSWORD, UserCredentialConfig.RECIPIENT, subject, body);
    }

    private static void sendFromGMail(InfoLoggerAdapter logger, String from, String pass, String to, String subject, String body) {




        try {
            MailerAdapter mailer = new MailerAdapter(from, pass, to);
            mailer.setSubjectAndBody(subject, body);
            mailer.sendMessage();

        } catch (AddressException ae) {
            logger.info("Address Exception thrown: " + ae.getMessage());
            ae.printStackTrace();
        } catch (MessagingException me) {
            logger.info("Message Exception thrown: " + me.getMessage());
            me.printStackTrace();
        } catch (Exception e) {
            logger.info("Exception thrown: " + e.getMessage());
            e.printStackTrace();
        }

        logger.info("Worked!");
    }




}
