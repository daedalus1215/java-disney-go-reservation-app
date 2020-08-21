package disney.reservation.notification.infrastructure.WebPageEssentials.Reservation.Date.DataMapper;


import disney.reservation.notification.infrastructure.WebPageEssentials.Reservation.Entity.ValueObject.Date;
import disney.reservation.notification.infrastructure.WebPageEssentials.Reservation.Entity.ValueObject.DateImpl;
import org.json.simple.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;


public class DateDataMapperImpl implements DateDataMapper{

    public DateDataMapperImpl() {}

    public ArrayList<Date> load(JSONObject reservationDTO) throws ParseException {

        ArrayList<Date> dates = new ArrayList<>();
        ArrayList<String> datesDTO = (ArrayList<String>) reservationDTO.get("dates");

        for (String date:datesDTO) {
           Date voDate = new DateImpl(date,
                   (String) reservationDTO.get("time"),
                   (String) reservationDTO.get("partySize"));
           dates.add(voDate);
        }
        return dates;
    }
}
