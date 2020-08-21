package disney.reservation.notification.infrastructure.WebPageEssentials.Reservation.DataMapper.Parser;


import disney.reservation.notification.infrastructure.WebPageEssentials.Reservation.DataMapper.Parser.Exception.ReservationParserException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


final public class ReservationParserStubFactory {

    public ReservationParser createStub() {
        ReservationParser stubReservationParser = mock(ReservationParser.class);

        try {
            ArrayList<JSONObject> mReservationEvents = this.buildReservationEvents();
            when(stubReservationParser.parse(FileSystems.getDefault().getPath("").toAbsolutePath().toString())).thenReturn(mReservationEvents);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ReservationParserException e) {
            e.printStackTrace();
        }

        return stubReservationParser;
    }

    private ArrayList<JSONObject> buildReservationEvents() {
        ArrayList<JSONObject> mReservationEvents = new ArrayList<>();

        JSONObject mReservationEvent1 = ReservationEventMockFactory.createStub("http://test.com1", "05/12/1986", "05/31/1986", "4");
        JSONObject mReservationEvent2 = ReservationEventMockFactory.createStub("http://test.com2", "08/08/1987", "08/16/1987", "4");
        JSONObject mReservationEvent3 = ReservationEventMockFactory.createStub("http://test.com3", "10/01/1988", "10/16/1988", "4");

        mReservationEvents.add(mReservationEvent1);
        mReservationEvents.add(mReservationEvent2);
        mReservationEvents.add(mReservationEvent3);

        return mReservationEvents;
    }
}
