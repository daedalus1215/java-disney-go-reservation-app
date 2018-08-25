package disney.reservation.notification.WebPageEssentials.Factory;

import disney.reservation.notification.WebPageEssentials.DateEntity;
import disney.reservation.notification.WebPageEssentials.DateEntityInterface;
import disney.reservation.notification.WebPageEssentials.Reference.HtmlElementReferrer;

import java.util.ArrayList;

/**
 * We are really only checking for dates between the 19-26 so that is what this factory creates for DateEntities.
 */
public class DateEntityForSeptemberDinnerFactory implements DateEntityAggregationFactoryInterface {

    public ArrayList<DateEntityInterface> createEntityArrayList() {
        ArrayList<DateEntityInterface> dateEntities = new ArrayList<DateEntityInterface>();

        for(int i = 19; i < 26; i++) {
            DateEntity mDateEntity = new DateEntity("09/" + i + "/2018", new HtmlElementReferrer().DESIRED_TIME_FOR_FIELD_OPTION, "4");
            dateEntities.add(mDateEntity);
        }

        return dateEntities;
    }
}
