package WebPageEssentials.Factory;

import WebPageEssentials.DateAggregator;
import WebPageEssentials.DateEntity;

import java.util.ArrayList;

public class DateAggregatorFactory {

    public DateAggregator createAggregation() {
        ArrayList<DateEntity> dateEntities = new ArrayList<DateEntity>();

        for(int i = 19; i < 26; i++) {
            DateEntity mDateEntity = new DateEntity("09/" + i + "/2018", "80000714", 4);
            dateEntities.add(mDateEntity);
        }

        DateAggregator dateAggregator = new DateAggregator(dateEntities);

        return dateAggregator;
    }
}
