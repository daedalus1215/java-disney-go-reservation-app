package MocksAndStubs;

import disney.reservation.notification.WebPageEssentials.Reservation.Date.DataMapper.DateDataMapper;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ValueObject.Date;
import disney.reservation.notification.WebPageEssentials.Reservation.Entity.ValueObject.DateImpl;
import org.json.simple.JSONObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

final public class DateDataMapperStubFactory {

    public DateDataMapper createStub() throws ParseException {
        DateDataMapper stub = mock(DateDataMapper.class);
        when(stub.load(new JSONObject())).thenReturn(this.getMocks());
        return stub;
    }

    private ArrayList<Date> getMocks() {
        ArrayList<Date> mocks = new ArrayList<>();
        mocks.add(new DateImpl("10/12/2013", "10:00", "4"));
        mocks.add(new DateImpl("10/13/2013", "10:00", "4"));
        mocks.add(new DateImpl("10/14/2013", "10:00", "4"));
        return mocks;
    }
}
