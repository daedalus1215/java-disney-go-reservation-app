package disney.reservation.notification.domain.reservations.assemblers;

import disney.reservation.notification.domain.reservations.utils.DateDifference;
import disney.reservation.notification.domain.reservations.utils.GetNextDate;
import org.springframework.beans.factory.FactoryBean;

public class EventAssemblerFactory implements FactoryBean<EventAssembler> {

  final private DateDifference dateDifference;
  final private GetNextDate getNextDate;

  public EventAssemblerFactory(DateDifference dateDifference, GetNextDate getNextDate) {
    this.dateDifference = dateDifference;
    this.getNextDate = getNextDate;
  }

  @Override
  public EventAssembler getObject() throws Exception {
    return new EventAssembler(dateDifference, getNextDate);
  }

  @Override
  public Class<?> getObjectType() {
    return null;
  }
}
