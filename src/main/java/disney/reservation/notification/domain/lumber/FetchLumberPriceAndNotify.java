package disney.reservation.notification.domain.lumber;

import static disney.reservation.notification.domain.lumber.HtmlElementReferrer.PRICE_CSS_PATH;
import static disney.reservation.notification.domain.lumber.HtmlElementReferrer.PRODUCE_TITLE_CSS_PATH;

import disney.reservation.notification.domain.log.Logger;
import disney.reservation.notification.infrastructure.mail.MailerProxy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FetchLumberPriceAndNotify {

  private static final String BASE_URL = "https://www.lumberliquidators.com/ll/c/Select-Brazilian-Pecan-Solid-Hardwood-Flooring-BELLAWOOD-BWBP2SV/10046136";
  private static final int TEN_SECONDS = 10;

  private final RemoteWebDriver driver;
  private final Logger logger;
  private final MailerProxy mailer;

  public FetchLumberPriceAndNotify(RemoteWebDriver driver, Logger logger, MailerProxy mailer) {
    this.driver = driver;
    this.logger = logger;
    this.mailer = mailer;
  }

  @Test(groups = {"lumber"})
  public void apply() {
    this.driver.get(BASE_URL);
    this.driver.manage().window().maximize();

    final WebDriverWait webDriverWait = new WebDriverWait(this.driver, TEN_SECONDS);

    webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PRICE_CSS_PATH)));

    final WebElement price = driver.findElementByCssSelector(PRICE_CSS_PATH);
    final String priceValue = price.getText();

    final WebElement productTitle = driver.findElementByCssSelector(PRODUCE_TITLE_CSS_PATH);
    final String title = productTitle.getText();

    logger.info(title
        .concat("\n with price: ")
        .concat(priceValue));

    try {

      final Matcher matcher = Pattern.compile("[0-9].[0-9]+|[0-9]+").matcher(priceValue);
      while (matcher.find()) {
        final String group = matcher.group();
        final String group1 = matcher.group(1);
        final Integer integer = Integer.getInteger(group);
        if (integer > Integer.getInteger("5.00")) {

          logger.info("\n below 5.00"
              .concat(title)
              .concat("\n")
              .concat(priceValue)
          );
        } else {
          logger.info("\n greater than 5.00"
              .concat(title)
              .concat("\n")
              .concat(priceValue)
          );

        }
      }
      //mailer.send(title, priceValue);
    } catch (Exception e) {
      logger.info("Error sending out a message: "
          .concat(title)
          .concat("\n")
          .concat(priceValue)
          .concat("\n--")
          .concat(e.getMessage()));
    } finally {
      this.driver.close();
    }
  }
}
