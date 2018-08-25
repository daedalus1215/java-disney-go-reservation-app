package disney.reservation.notification.WebPageEssentials.Factory;

import disney.reservation.notification.WebPageEssentials.DateEntity;

import java.util.ArrayList;

/**
 * We are really only checking for dates between the 19-26 so that is what this factory creates for DateEntities.
 */
public class DateEntityForSeptemberDinnerFactory implements DateEntityAggregationFactoryInterface {

    public ArrayList<DateEntity> createEntityArrayList() {
        ArrayList<DateEntity> dateEntities = new ArrayList<DateEntity>();

        for(int i = 19; i < 26; i++) {
            DateEntity mDateEntity = new DateEntity("09/" + i + "/2018", "80000714", "4");
            dateEntities.add(mDateEntity);
        }

        return dateEntities;
    }
}
