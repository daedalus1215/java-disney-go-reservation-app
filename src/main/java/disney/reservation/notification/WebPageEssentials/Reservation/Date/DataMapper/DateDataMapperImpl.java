package disney.reservation.notification.WebPageEssentials.Reservation.Date.DataMapper;


import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ReservationEvent;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ValueObject.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateDataMapperImpl {

    public DateDataMapperImpl() {

    }

    /**
     * fetch the dates for the event
     * @param ReservationEvent theEvent
     * @return ReservationEvent theEvent
     */
    public ArrayList<Date> fetchDateValueObjects(ReservationEvent theEvent) throws ParseException {

        ReservationEvent event = theEvent.clone();
        SimpleDateFormat sdf = new  SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

        java.util.Date firstDate = sdf.parse(event.startDate);
        java.util.Date endDate = sdf.parse(event.endDate);


        long diffInMillies = Math.abs(endDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);


        //@todo: need to create Dates from the start to the end dates setup.


        ArrayList<Date> dates = new ArrayList<>();

        for (Date date:event.dates) {
            date.
        }

        return null;
    }


    private int
}
