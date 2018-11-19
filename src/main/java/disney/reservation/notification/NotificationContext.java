package disney.reservation.notification;

import com.gargoylesoftware.htmlunit.WebClient;
import config.UserCredentialConfig;
import disney.reservation.notification.Adapter.Logger.InfoLoggerAdapter;
import disney.reservation.notification.Adapter.Logger.Logger;
import disney.reservation.notification.Adapter.MailerAdapter;
import disney.reservation.notification.WebPageEssentials.Reference.HtmlElementReferrer;
import disney.reservation.notification.WebPageEssentials.Requestor.PageRequestor;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser.ReservationParser;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser.ReservationParserImpl;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.ReservationDataMapper;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.ReservationDataMapperImpl;
import disney.reservation.notification.WebPageEssentials.Reservation.Date.DataMapper.DateDataMapper;
import disney.reservation.notification.WebPageEssentials.Reservation.Date.DataMapper.DateDataMapperImpl;
import disney.reservation.notification.WebPageEssentials.ReservationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.mail.MessagingException;


@Configuration
public class NotificationContext {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean()
    public InfoLoggerAdapter Logger() {
        return new InfoLoggerAdapter();
    }

    @Bean("disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.ReservationDataMapperImpl")
    public ReservationDataMapper ReservationDataMapperImpl() {
        Logger logger = applicationContext.getBean(InfoLoggerAdapter.class, "Logger");
        ReservationParser parser = new ReservationParserImpl(logger);
        ReservationDataMapper dataMapper = new ReservationDataMapperImpl(parser, new DateDataMapperImpl());
        return dataMapper;
    }


    @Bean("disney.reservation.notification.WebPageEssentials.Requestor.PageRequestor")
    public PageRequestor PageRequestor() {
        WebClient webClient = new WebClient();
        return new PageRequestor(webClient);
    }


    @Bean("disney.reservation.notification.WebPageEssentials.ReservationResolver")
    public ReservationResolver ReservationResolver() throws MessagingException {
            MailerAdapter mailerAdapter = new MailerAdapter(UserCredentialConfig.USERNAME, UserCredentialConfig.PASSWORD, UserCredentialConfig.RECIPIENT);
            InfoLoggerAdapter logger = applicationContext.getBean(InfoLoggerAdapter.class);
            HtmlElementReferrer htmlElementReferrer = new HtmlElementReferrer();
            return new ReservationResolver(mailerAdapter, htmlElementReferrer, logger);
    }

}
