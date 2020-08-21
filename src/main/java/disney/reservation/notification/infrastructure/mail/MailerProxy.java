package disney.reservation.notification.infrastructure.mail;

public class MailerProxy {

  private final String emailUsername;
  private final String emailPassword;
  private final String recipient;

  public MailerProxy(String emailUsername, String emailPassword, String recipient) {
    this.emailUsername = emailUsername;
    this.emailPassword = emailPassword;
    this.recipient = recipient;
  }

  public void send(String subject, String message) throws Exception {
    new GmailMailer(emailUsername, emailPassword, recipient)
        .setSubjectAndBody(subject, message)
        .sendMessage();
  }
}
