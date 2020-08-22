package disney.reservation.notification.domain.reservations.assemblers;

import disney.reservation.notification.domain.reservations.utils.DateDifference;
import disney.reservation.notification.domain.reservations.utils.GetNextDate;
import org.springframework.beans.factory.FactoryBean;

public class EventAssemblerFactory implements FactoryBean<EventAssembler> {

  private final DateDifference dateDifference;
  private final GetNextDate getNextDate;

  public EventAssemblerFactory(DateDifference dateDifference, GetNextDate getNextDate) {
    this.dateDifference = dateDifference;
    this.getNextDate = getNextDate;
  }

  public EventAssembler getObject() {
    return new EventAssembler(dateDifference, getNextDate);
  }

  public Class<?> getObjectType() {
    return null;
  }
}