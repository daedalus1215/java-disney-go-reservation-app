package disney.reservation.notification.application.lumber;

import config.AppConfig;
import disney.reservation.notification.domain.lumber.FetchLumberPriceAndNotify;
import disney.reservation.notification.infrastructure.log.SystemLogger;
import disney.reservation.notification.infrastructure.mail.MailerProxy;
import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FetchPriceAction {

  @Test(groups = {"lumber"})
  public void apply() throws IOException {
    final ChromeDriver driver = new ChromeDriver();
    final SystemLogger logger = new SystemLogger();
    //final LogMailer logMailer = new LogMailer();

    final AppConfig appConfig = new AppConfig();

    final MailerProxy mailerProxy = new MailerProxy(appConfig.getEmailUsername(),
        appConfig.getEmailPassword(), appConfig.getRecipient());

    new FetchLumberPriceAndNotify(driver, logger, mailerProxy).apply();
  }
}
