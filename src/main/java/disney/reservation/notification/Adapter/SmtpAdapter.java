package disney.reservation.notification.Adapter;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SmtpAdapter extends Authenticator {
    private String username;
    private String password;

    public SmtpAdapter(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
}