package disney.reservation.notification.domain.mail;

import javax.mail.MessagingException;

public interface Mailer {
    void setSubjectAndBody(String subject, String body) throws MessagingException;

    void sendMessage() throws Exception;
}
