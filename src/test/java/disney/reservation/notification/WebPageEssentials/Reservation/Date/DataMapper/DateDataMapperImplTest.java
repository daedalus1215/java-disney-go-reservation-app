package disney.reservation.notification.WebPageEssentials.Reservation.Date.DataMapper;


import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ValueObject.Date;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ValueObject.DateImpl;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class DateDataMapperImplTest {
    private DateDataMapperImpl tester;

    private void setup()
    {
        this.tester = new DateDataMapperImpl();
    }

    private String getDatesJSON() {
        return "{" +
                    "\"dates\": [\"12/13/2013\", \"12/14/2013\"]," +
                    "\"time\": \"10:00\"," +
                    "\"seating\": 1 " +
                "}";
    }


    @Test
    void load() throws ParseException {
        this.setup();
        JSONObject mockDatesDTO = new JSONObject();
        mockDatesDTO.put("dates", "[\"12/13/2013\", \"12/14/2013\"]");
        mockDatesDTO.put("time", "10:00");
        mockDatesDTO.put("seating", "1");

        ArrayList<Date> dates = this.tester.load(mockDatesDTO);
        Assert.assertEquals("12/13/2013", dates.get(0).getDate());
        Assert.assertEquals("10:00", dates.get(0).getTime());
        Assert.assertEquals("1", dates.get(0).getSeating());

        Assert.assertEquals("12/14/2013", dates.get(1).getDate());
    }

}