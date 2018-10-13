package disney.reservation.notification.WebPageEssentials.Reservation;

import disney.reservation.notification.WebPageEssentials.Reservation.Property.ReservationDateInterface;
import disney.reservation.notification.WebPageEssentials.Reservation.Property.ReservationDateVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ReservationEntityTest {
    @Test
    public void testConstructorEquals() {
        ReservationDateInterface mockReservationDate = mock(ReservationDateInterface.class);
        when(mockReservationDate.getDate()).thenReturn("09/18/2018");
        when(mockReservationDate.getTime()).thenReturn("8000019");
        when(mockReservationDate.getSeating()).thenReturn("4");

        ReservationEntity tester = new ReservationEntity(mockReservationDate, "http://test");

        Assertions.assertEquals("http://test", tester.getUrl());
        Assertions.assertEquals("09/18/2018", tester.getReservationDates().get(0).getDate());
        Assertions.assertEquals("http://test", tester.getUrl());
    }
}
