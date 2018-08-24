package WebPageEssentials.Factory;

import WebPageEssentials.DateAggregator;
import WebPageEssentials.DateEntity;

import java.util.ArrayList;

/**
 * We are really only checking for dates between the 19-26 so that is what this factory creates for DateEntities.
 */
public class DateAggregatorFactory {

    public DateAggregator createAggregation() {
        ArrayList<DateEntity> dateEntities = new ArrayList<DateEntity>();

        for(int i = 13; i < 20; i++) {
            DateEntity mDateEntity = new DateEntity("02/" + i + "/2019", "80000714", 4, "September "+i+", 2018");
            dateEntities.add(mDateEntity);
        }

        DateAggregator dateAggregator = new DateAggregator(dateEntities);

        return dateAggregator;
    }
}
