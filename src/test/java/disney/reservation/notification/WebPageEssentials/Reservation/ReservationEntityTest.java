package disney.reservation.notification.WebPageEssentials.Reservation;

import disney.reservation.notification.WebPageEssentials.Reservation.Property.ReservationDateInterface;
import disney.reservation.notification.WebPageEssentials.Reservation.Property.ReservationDateVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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


    @Test
    public void testConstructorWithMultipleReservationDateEquals() {
        ReservationDateInterface mockReservationDate = mock(ReservationDateInterface.class);
        when(mockReservationDate.getDate()).thenReturn("09/18/2018");
        when(mockReservationDate.getTime()).thenReturn("8000019");
        when(mockReservationDate.getSeating()).thenReturn("4");

        ReservationDateInterface mockReservationDate2 = mock(ReservationDateInterface.class);
        when(mockReservationDate2.getDate()).thenReturn("09/19/2018");
        when(mockReservationDate2.getTime()).thenReturn("8000019");
        when(mockReservationDate2.getSeating()).thenReturn("4");


        ArrayList<ReservationDateInterface> mockReservationDates = new ArrayList<ReservationDateInterface>();
        mockReservationDates.add(mockReservationDate);
        mockReservationDates.add(mockReservationDate2);


        ReservationEntity tester = new ReservationEntity(mockReservationDates, "http://test");


        Assertions.assertEquals("http://test", tester.getUrl());
        Assertions.assertEquals("09/18/2018", tester.getReservationDates().get(0).getDate());
        Assertions.assertEquals("8000019", tester.getReservationDates().get(0).getTime());
        Assertions.assertEquals("4", tester.getReservationDates().get(0).getSeating());


        Assertions.assertEquals("http://test", tester.getUrl());
        Assertions.assertEquals("09/19/2018", tester.getReservationDates().get(1).getDate());
        Assertions.assertEquals("8000019", tester.getReservationDates().get(1).getTime());
        Assertions.assertEquals("4", tester.getReservationDates().get(1).getSeating());
    }
}
