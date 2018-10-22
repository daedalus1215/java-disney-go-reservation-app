package disney.reservation.notification;

import disney.reservation.notification.Adapter.Logger.InfoLoggerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationContext {


    @Bean()
    public InfoLoggerAdapter Logger() {
        return new InfoLoggerAdapter();
    }


}
