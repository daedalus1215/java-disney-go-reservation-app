package disney.reservation.notification.domain.reservations.assemblers;

import disney.reservation.notification.domain.utils.DateDifference;
import org.springframework.beans.factory.FactoryBean;

public class ReservationEventAssemblerFactory implements FactoryBean<ReservationEventAssembler> {

  final private DateDifference dateDifference;

  public ReservationEventAssemblerFactory(DateDifference dateDifference) {
    this.dateDifference = dateDifference;
  }

  @Override
  public ReservationEventAssembler getObject() throws Exception {
    return new ReservationEventAssembler(dateDifference);
  }

  @Override
  public Class<?> getObjectType() {
    return null;
  }
}
