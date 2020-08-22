package disney.reservation.notification.domain.lumber;

import static disney.reservation.notification.domain.lumber.HtmlElementReferrer.PRICE_CSS_PATH;
import static disney.reservation.notification.domain.lumber.HtmlElementReferrer.PRODUCE_TITLE_CSS_PATH;

import disney.reservation.notification.application.lumber.DecimalExpression;
import disney.reservation.notification.domain.log.Logger;
import disney.reservation.notification.infrastructure.mail.MailerProxy;
import java.math.BigDecimal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FetchLumberPriceAndNotify {

  private static final String BASE_URL = "https://www.lumberliquidators.com/ll/c/Select-Brazilian-Pecan-Solid-Hardwood-Flooring-BELLAWOOD-BWBP2SV/10046136";
  private static final int TEN_SECONDS = 10;
  private static final Double THRESH_HOLD = 3.50;

  private final RemoteWebDriver driver;
  private final Logger logger;
  private final MailerProxy mailer;

  private final DecimalExpression decimalExpression = new DecimalExpression();

  public FetchLumberPriceAndNotify(RemoteWebDriver driver, Logger logger, MailerProxy mailer) {
    this.driver = driver;
    this.logger = logger;
    this.mailer = mailer;
  }

  @Test(groups = {"lumber"})
  public void apply() throws Exception {
    this.driver.get(BASE_URL);
    this.driver.manage().window().maximize();

    final WebDriverWait webDriverWait = new WebDriverWait(this.driver, TEN_SECONDS);

    webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PRICE_CSS_PATH)));

    final WebElement priceWidget = driver.findElementByCssSelector(PRICE_CSS_PATH);
    final String priceWidgetValue = priceWidget.getText();

    final WebElement productTitle = driver.findElementByCssSelector(PRODUCE_TITLE_CSS_PATH);
    final String title = productTitle.getText();

    logger.info(title
        .concat("\n with price: ")
        .concat(priceWidgetValue));

    final BigDecimal price = decimalExpression.apply(priceWidgetValue);

    if (price.doubleValue() < THRESH_HOLD) {
      mailer.send(title, priceWidgetValue);
      logger.info("was less than threshold! Sending out txt message!");
    } else {
      logger.info("was more than threshold. Not sending out txt message.");
    }
  }
}
