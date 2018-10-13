package disney.reservation.notification.WebPageEssentials.Reservation.Date.DataMapper;

import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ValueObject.Date;
import org.json.simple.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;

public interface DateDataMapper {
    public ArrayList<Date> load(JSONObject reservationDTO) throws ParseException;
}