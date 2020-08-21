package disney.reservation.notification.domain.lumber_price;

import static disney.reservation.notification.domain.lumber_price.HtmlElementReferrer.PRICE_CSS_PATH;
import static disney.reservation.notification.domain.lumber_price.HtmlElementReferrer.PRODUCE_TITLE_CSS_PATH;

import disney.reservation.notification.domain.log.Logger;
import disney.reservation.notification.domain.mail.Mailer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FetchLumberPriceAndNotify {

  private final String baseUrl = "https://www.lumberliquidators.com/ll/c/Select-Brazilian-Pecan-Solid-Hardwood-Flooring-BELLAWOOD-BWBP2SV/10046136";
  private final RemoteWebDriver driver;
  private final Logger logger;
  private final Mailer mailer;

  public FetchLumberPriceAndNotify(RemoteWebDriver driver, Logger logger, Mailer mailer) {
    this.driver = driver;
    this.logger = logger;
    this.mailer = mailer;
  }

  @Test(groups = {"lumber"})
  public void apply() {
    this.driver.get(baseUrl);
    this.driver.manage().window().maximize();

    final WebDriverWait webDriverWait = new WebDriverWait(this.driver, 10);

    webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PRICE_CSS_PATH)));

    final WebElement price = driver.findElementByCssSelector(PRICE_CSS_PATH);
    final String priceValue = price.getText();

    final WebElement productTitle = driver.findElementByCssSelector(PRODUCE_TITLE_CSS_PATH);
    final String title = productTitle.getText();

    logger.info(title
        .concat("\n with price: ")
        .concat(priceValue));

    this.driver.close();
//    mailer.setSubjectAndBody("Price on the Brazilian");
  }
}
