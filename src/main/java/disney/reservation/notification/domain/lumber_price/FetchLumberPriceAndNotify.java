package disney.reservation.notification.domain.lumber_price;

import static disney.reservation.notification.domain.lumber_price.HtmlElementReferrer.PRICE_CSS_PATH;

import disney.reservation.notification.domain.log.Logger;
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

  public FetchLumberPriceAndNotify(RemoteWebDriver driver, Logger logger) {
    this.driver = driver;
    this.logger = logger;
  }

  @Test(groups = {"lumber"})
  public void apply() {
    this.driver.get(baseUrl);
    this.driver.manage().window().maximize();

    final WebDriverWait webDriverWait = new WebDriverWait(this.driver, 10);

    webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PRICE_CSS_PATH)));

    final WebElement price = driver.findElementByCssSelector(PRICE_CSS_PATH);
    final String priceValue = price.getText();

    logger.info("The price for Brazilian wood: ".concat(priceValue));
  }
}
