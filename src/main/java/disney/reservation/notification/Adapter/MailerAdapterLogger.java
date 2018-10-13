package disney.reservation.notification.Adapter;

import disney.reservation.notification.Adapter.Logger.Logger;
import disney.reservation.notification.Adapter.MailerAdapter;

import javax.mail.MessagingException;

/**
 * NullMailerAdapter
 */
public class MailerAdapterLogger implements MailerAdapter{
    private Logger logger;

    public MailerAdapterLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void setSubjectAndBody(String subject, String body) throws MessagingException {
        this.logger.info("set Subject to: " + subject + " and body to:" + body);

    }

    @Override
    public void sendMessage() throws Exception {
        this.logger.info("Sending message from MailerAdapterLogger");
    }
}
