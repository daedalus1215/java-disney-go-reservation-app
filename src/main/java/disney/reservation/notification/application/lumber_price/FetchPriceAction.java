package disney.reservation.notification.application.lumber_price;

import disney.reservation.notification.domain.lumber_price.FetchLumberPriceAndNotify;
import org.testng.annotations.Test;

public class FetchPriceAction {

  @Test(groups = {"lumber"})
  public void apply() throws InterruptedException {
    new FetchLumberPriceAndNotify();
  }
}
