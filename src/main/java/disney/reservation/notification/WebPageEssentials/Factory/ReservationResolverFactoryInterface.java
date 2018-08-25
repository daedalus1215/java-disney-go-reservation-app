package disney.reservation.notification.WebPageEssentials.Factory;

import disney.reservation.notification.WebPageEssentials.ReservationResolver;

import javax.mail.MessagingException;

public interface ReservationResolverFactoryInterface {
    ReservationResolver createReservationResolver() throws MessagingException;
}
