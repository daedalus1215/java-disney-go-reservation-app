package disney.reservation.notification.domain.mail;

import javax.mail.MessagingException;

public interface MailerAdapter {
    void setSubjectAndBody(String subject, String body) throws MessagingException;

    void sendMessage() throws Exception;
}
