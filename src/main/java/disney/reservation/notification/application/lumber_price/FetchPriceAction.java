package disney.reservation.notification.application.lumber_price;

import disney.reservation.notification.domain.lumber_price.FetchLumberPriceAndNotify;
import disney.reservation.notification.infrastructure.log.SystemLogger;
import disney.reservation.notification.infrastructure.mail.LogMailer;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FetchPriceAction {

  @Test(groups = {"lumber"})
  public void apply() {
    final ChromeDriver driver = new ChromeDriver();
    final SystemLogger logger = new SystemLogger();
    final LogMailer logMailer = new LogMailer();

    new FetchLumberPriceAndNotify(driver, logger, logMailer).apply();
  }
}
