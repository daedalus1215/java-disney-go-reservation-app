package Adapter;

import Authentication.SmtpAuthenticator;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailerAdapter {
    private String from;
    private String pass;
    private String to;
    private MimeMessage message;
    private Session session;

    private boolean isSubjectAndTextSet = false;

    public MailerAdapter(String from, String pass, String to) throws MessagingException {
        this.from = from;
        this.pass = pass;
        this.to = to;

        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        SmtpAuthenticator authenticator = new SmtpAuthenticator(from, pass);
        session = Session.getDefaultInstance(props, authenticator);

        message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        InternetAddress[] toAddress = new InternetAddress[1];

        toAddress[0] = new InternetAddress(to);

        message.addRecipient(Message.RecipientType.TO, toAddress[0]);
    }

    public void setSubjectAndBody(String subject, String body) throws MessagingException {
        message.setSubject(subject);
        message.setText(body);
        isSubjectAndTextSet = true;
    }

    public void sendMessage() throws Exception {
        if (isSubjectAndTextSet == false) {
            throw new Exception("Set the subject and body with setSubjectAndBody() method");
        }

        Transport transport = session.getTransport("smtp");
        transport.connect();
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
