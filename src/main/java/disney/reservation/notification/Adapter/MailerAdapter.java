package disney.reservation.notification.Adapter;

import javax.mail.MessagingException;

public interface MailerAdapter {
    void setSubjectAndBody(String subject, String body) throws MessagingException;

    void sendMessage() throws Exception;
}
