package disney.reservation.notification.domain;

import java.util.List;

public interface Repository<T> {

  public List<T> fetchAll();
}
