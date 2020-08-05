package disney.reservation.notification.infrastructure.mail;

import disney.reservation.notification.domain.mail.Mailer;
import javax.mail.MessagingException;

/**
 * Swap this Mailer in when we are just dev testing.
 */
public class LogMailer implements Mailer {

  private String subject;
  private String body;

  @Override
  public void setSubjectAndBody(String subject, String body) throws MessagingException {
    this.subject = subject;
    this.body = body;
  }

  @Override
  public void sendMessage() throws Exception {
    System.out.println("Mailer Logger, subject: ".concat(subject)
        .concat(". body: ".concat(body)));
  }
}
