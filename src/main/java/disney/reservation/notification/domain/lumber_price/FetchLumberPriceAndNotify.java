package disney.reservation.notification.domain.lumber_price;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FetchLumberPriceAndNotify {

  private final String baseUrl = "https://www.lumberliquidators.com/ll/c/Select-Brazilian-Pecan-Solid-Hardwood-Flooring-BELLAWOOD-BWBP2SV/10046136";

  private final ChromeDriver driver = new ChromeDriver();

  @Test(groups = {"lumber"})
  public void apply() throws InterruptedException {
    System.out.println("FetchLumberPrice");
    driver.get(baseUrl);
    driver.manage().window().maximize();

    final WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
    webDriverWait.until(
        ExpectedConditions
            .elementToBeClickable(By.cssSelector(HtmlElementReferrer.PRICE_CSS_PATH)));

    final WebElement price = driver
        .findElementByCssSelector(HtmlElementReferrer.PRICE_CSS_PATH);
    Thread.sleep(1000);
    final String text = price.getText();
    System.out.println("The text is: ".concat(text));
  }
}
