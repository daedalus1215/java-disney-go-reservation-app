package disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Factory;

import disney.reservation.notification.Adapter.Logger.InfoLoggerAdapter;
import disney.reservation.notification.Adapter.Logger.Logger;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser.ReservationParser;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser.ReservationParserImpl;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.ReservationDataMapper;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.ReservationDataMapperImpl;
import org.springframework.context.ApplicationContext;

public class ReservationDataMapperImplFactory {
    public ReservationDataMapper createDataMapper(ApplicationContext applicationContext) {
        //@todo: left off here.
        Logger logger = applicationContext.getBean(InfoLoggerAdapter.class, "Logger");
        ReservationParser parser = new ReservationParserImpl(logger);
        //@todo: wire this up
        ReservationDataMapper dataMapper = new ReservationDataMapperImpl();
        return null;
    }
}
