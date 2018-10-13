package disney.reservation.notification;

import com.gargoylesoftware.htmlunit.WebClient;
import config.MainConfig;
import config.UserCredentialConfig;
import disney.reservation.notification.Adapter.Logger.InfoLoggerAdapter;
import disney.reservation.notification.Adapter.Logger.Logger;
import disney.reservation.notification.Adapter.MailerAdapter;
import disney.reservation.notification.Adapter.MailerAdapterImpl;
import disney.reservation.notification.Adapter.MailerAdapterLogger;
import disney.reservation.notification.WebPageEssentials.Reference.HtmlElementReferrer;
import disney.reservation.notification.WebPageEssentials.Requestor.PageRequestor;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser.ReservationParser;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser.ReservationParserImpl;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.ReservationDataMapper;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.ReservationDataMapperImpl;
import disney.reservation.notification.WebPageEssentials.Reservation.Date.DataMapper.DateDataMapperImpl;
import disney.reservation.notification.WebPageEssentials.ReservationResolver;
import disney.reservation.notification.WebPageEssentials.ReservationResolverImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.mail.MessagingException;


@Configuration
public class NotificationContext {

    @Autowired
    private ApplicationContext applicationContext;


    @Bean
    public InfoLoggerAdapter Logger() {
        return new InfoLoggerAdapter();
    }

    @Bean
    public MailerAdapter MailerAdapter() throws MessagingException {
        MailerAdapter mailerAdapter;
        if (MainConfig.isDevelopmentMode) {
            mailerAdapter = new MailerAdapterLogger(applicationContext.getBean(InfoLoggerAdapter.class));
        } else {
            mailerAdapter = new MailerAdapterImpl(UserCredentialConfig.USERNAME, UserCredentialConfig.PASSWORD, UserCredentialConfig.RECIPIENT);
        }
        return mailerAdapter;
    }

    @Bean("disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.ReservationDataMapperImpl")
    public ReservationDataMapper ReservationDataMapperImpl() {
        Logger logger = applicationContext.getBean(InfoLoggerAdapter.class, "Logger");
        ReservationParser parser = new ReservationParserImpl(logger);
        return new ReservationDataMapperImpl(parser, new DateDataMapperImpl());
    }

    @Bean()
    public PageRequestor PageRequestor() {
        WebClient webClient = new WebClient();
        return new PageRequestor(webClient);
    }

    @Bean()
    public ReservationResolver ReservationResolver() throws MessagingException {
            InfoLoggerAdapter logger = applicationContext.getBean(InfoLoggerAdapter.class);
            MailerAdapter mailerAdapter = applicationContext.getBean(MailerAdapter.class);
            HtmlElementReferrer htmlElementReferrer = new HtmlElementReferrer();
            return new ReservationResolverImpl(mailerAdapter, htmlElementReferrer, logger);
    }

    @Bean()
    public ReservationParser ReservationParser() {
        InfoLoggerAdapter logger = applicationContext.getBean(InfoLoggerAdapter.class, "Logger");
        return new ReservationParserImpl(logger);
    }
}
