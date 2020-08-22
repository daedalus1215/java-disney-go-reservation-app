package disney.reservation.notification.application;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import config.AppConfig;
import disney.reservation.notification.domain.log.Logger;
import disney.reservation.notification.domain.reservations.assemblers.EventAssembler;
import disney.reservation.notification.domain.reservations.assemblers.EventAssemblerFactory;
import disney.reservation.notification.domain.reservations.utils.DateDifference;
import disney.reservation.notification.domain.reservations.utils.GetNextDate;
import disney.reservation.notification.infrastructure.log.SystemLogger;
import disney.reservation.notification.infrastructure.mongo.MongoDatabaseConnectionFactory;
import disney.reservation.notification.infrastructure.reservations.ReservationRepository;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class NotificationContext {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public Logger registerLoggerAdapter() {
        //return new FileLogger();
        return new SystemLogger();
    }

    @Bean
    public AppConfig registerAppConfig() throws IOException {
        return new AppConfig();
    }

    @Bean
    public MongoClient registerMongoClient() throws Exception {
        final AppConfig appConfig = registerAppConfig();
        return new MongoDatabaseConnectionFactory(appConfig).getObject();
    }

    @Bean
    public MongoDatabase registerMongoDatabase() throws Exception {
        return registerMongoClient().getDatabase("test");
    }

    @Bean
    public ReservationRepository registerReservationRepository() throws Exception {
        return new ReservationRepository(registerMongoDatabase());
    }

    @Bean
    public DateDifference registerDateDifference() {
        return new DateDifference(registerLoggerAdapter());
    }

    //@TODO: Need to test this factory/egistry
    @Bean
    public GetNextDate registerGetNextDate() {
        return new GetNextDate(this.registerLoggerAdapter());
    }

    @Bean
    public EventAssembler registerReservationEventAssembler() {
        final DateDifference dateDifference = registerDateDifference();
        final GetNextDate getNextDate = registerGetNextDate();

        return new EventAssemblerFactory(dateDifference, getNextDate).getObject();
    }
}
