package WebPageEssentials;

import java.util.ArrayList;

/**
 * Is an aggregation of DateEntities.
 * Probably breaking a rule by having time and seating here,
 * but they will be the same for all DateEntities
 */
public class DateAggregator {

    public ArrayList<DateEntity> dateEntities;


    public DateAggregator(ArrayList<DateEntity> dateEntities) {
        this.dateEntities = dateEntities;
    }

    public ArrayList<DateEntity> getDateEntities() {
        return dateEntities;
    }
}
