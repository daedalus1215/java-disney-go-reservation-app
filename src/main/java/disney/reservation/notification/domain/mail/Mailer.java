package disney.reservation.notification.domain.mail;

import javax.mail.MessagingException;

public interface Mailer {

  void setSubjectAndBody(String s, String concat) throws MessagingException;

  void sendMessage() throws Exception;
}
