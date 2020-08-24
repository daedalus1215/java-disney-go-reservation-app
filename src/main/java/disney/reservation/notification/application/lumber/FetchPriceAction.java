package disney.reservation.notification.application.lumber;

import config.AppConfig;
import disney.reservation.notification.domain.lumber.FetchLumberPriceAndNotify;
import disney.reservation.notification.infrastructure.log.FileLogger;
import disney.reservation.notification.infrastructure.log.SystemLogger;
import disney.reservation.notification.infrastructure.mail.MailerProxy;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchPriceAction {

  public void apply() throws Exception {
    System.out.println("FetchPriceAction");
    final ChromeDriver driver = new ChromeDriver();
//    final SystemLogger logger = new SystemLogger();
    final FileLogger logger = new FileLogger();

    final AppConfig appConfig = new AppConfig();

    final MailerProxy mailerProxy = new MailerProxy(appConfig.getEmailUsername(),
        appConfig.getEmailPassword(), appConfig.getRecipient());

    new FetchLumberPriceAndNotify(driver, logger, mailerProxy)
        .apply();
  }
}
