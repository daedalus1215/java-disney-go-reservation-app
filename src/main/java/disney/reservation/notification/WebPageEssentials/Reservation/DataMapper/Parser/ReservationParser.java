package disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser;

import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser.Exception.ReservationParserException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public interface ReservationParser {
    ArrayList<JSONObject> parse(String directoryName) throws IOException, ParseException, ReservationParserException, ReservationParserException;
}