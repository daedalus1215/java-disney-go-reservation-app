package disney.reservation.notification.application.lumber_price;

import disney.reservation.notification.domain.lumber_price.FetchLumberPriceAndNotify;
import disney.reservation.notification.infrastructure.log.SystemLogger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FetchPriceAction {

  @Test(groups = {"lumber"})
  public void apply() {
    final ChromeDriver driver = new ChromeDriver();
    final SystemLogger logger = new SystemLogger();
    new FetchLumberPriceAndNotify(driver, logger)
        .apply();
  }
}
