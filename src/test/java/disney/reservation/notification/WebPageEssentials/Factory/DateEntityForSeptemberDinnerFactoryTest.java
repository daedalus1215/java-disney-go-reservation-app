package disney.reservation.notification.WebPageEssentials.Factory;

import disney.reservation.notification.WebPageEssentials.DateEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DateEntityForSeptemberDinnerFactoryTest {


    private ArrayList createMockDateEntities() {
        ArrayList<DateEntity> dateEntities = new ArrayList<DateEntity>();


        for(int i = 19; i < 26; i++) {
            DateEntity mDateEntity = new DateEntity("09/" + i + "/2018", "80000714", "4");
            dateEntities.add(mDateEntity);
        }

        return dateEntities;

    }



    @Test
    void createAggregationEqualsTo() {
        DateEntityForSeptemberDinnerFactory tester = new DateEntityForSeptemberDinnerFactory();
        ArrayList<DateEntity> mockDateEntities = this.createMockDateEntities();

        int expectedDay = 18;
        for (int i = 0; i < mockDateEntities.size(); i++) {
            expectedDay++;
            assertEquals("DateEntity{" +
                            "date='" + "09/"+expectedDay+"/2018" + '\'' +
                            ", time='" + 80000714 + '\'' +
                            ", seating=" + 4 +
                            '}',
                    mockDateEntities.get(i).toString());
        }
    }
}