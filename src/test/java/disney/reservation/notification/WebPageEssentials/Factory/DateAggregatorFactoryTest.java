package disney.reservation.notification.WebPageEssentials.Factory;

import disney.reservation.notification.WebPageEssentials.DateAggregator;
import disney.reservation.notification.WebPageEssentials.DateEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DateAggregatorFactoryTest {

    private ArrayList createMockDateEntities() {
        ArrayList<DateEntity> dateEntities = new ArrayList<DateEntity>();


        for(int i = 19; i < 26; i++) {
            DateEntity mDateEntity = new DateEntity("09/" + i + "/2018", "80000714", 4, "September "+i+", 2018");
            dateEntities.add(mDateEntity);
        }

        return dateEntities;

    }



    @Test
    void createAggregationEqualsTo() {
        DateAggregatorFactory tester = new DateAggregatorFactory();
        DateAggregator mDateAggregator = tester.createAggregation();
        ArrayList<DateEntity> mDateEntities = mDateAggregator.getDateEntities();

        int expectedDay = 18;
        for (int i = 0; i < mDateEntities.size(); i++) {
            expectedDay++;
            assertEquals("DateEntity{" +
                            "date='" + "09/"+expectedDay+"/2018" + '\'' +
                            ", time='" + 80000714 + '\'' +
                            ", seating=" + 4 +
                            ", displayedDate='September "+expectedDay+", 2018" + '\'' +
                            '}',
                    mDateEntities.get(i).toString());
        }
    }

}