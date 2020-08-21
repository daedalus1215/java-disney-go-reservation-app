package disney.reservation.notification.application.reservations;

import disney.reservation.notification.infrastructure.WebPageEssentials.Reference.HtmlElementReferrer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Example1 {

  public static String baseUrl = "https://www.disneyworld.eu/dining/epcot/le-cellier-steakhouse/";
  final ChromeDriver driver = new ChromeDriver();


  @BeforeClass
  public void setUp() {

  }

  @Test(groups = {"fast"})
  public void aFastTest() {
    final HtmlElementReferrer htmlElementReferrer = new HtmlElementReferrer();
    System.out.println("Fast test");
    this.driver.get(baseUrl);
    this.driver.manage().window().maximize();
    final String title = this.driver.getTitle();
    System.out.println("Title + " + title);

    // Wait for the for an input to be clickable
    WebDriverWait wait = new WebDriverWait(this.driver, 10);
    wait.until(ExpectedConditions
        .elementToBeClickable((By.xpath(htmlElementReferrer.DINING_RESERVATION_DATE_XPATH))));

    try {
      final WebElement date = this.driver
          .findElementByXPath(htmlElementReferrer.DINING_RESERVATION_DATE_XPATH);
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", date);
      Thread.sleep(1000);

      this.driver.executeScript(
          "document.querySelector(" + htmlElementReferrer.DATE_SELECTOR + ").value = '10/17/2020';",
          date);
      Thread.sleep(1000);

      //@TODO: Having an issue setting the Time and Date, the drop downs are giving me an issue.
      final WebElement time = this.driver.findElementByXPath(htmlElementReferrer.TIME_ID_XPATH);

      final Select timeSelect = new Select(time);
      timeSelect.selectByVisibleText("2:30 PM");
//      this.driver.executeScript(
//          "document.querySelector(" + htmlElementReferrer.TIME_SELECTOR + ").value = '14:30';",
//          time);
      Thread.sleep(1000);

      final WebElement party = this.driver.findElementByXPath(htmlElementReferrer.PARTY_SIZE_XPATH);
      this.driver.executeScript(
          "document.querySelector(" + htmlElementReferrer.PARTY_SELECTOR + ").value = '1';",
          party);
      Thread.sleep(1000);

      //@TODO: 1. Need to make references for all fields
      //@TODO: 1.1. Make sure we can touch all fields
      //@TODO: 1.2. Make sure we can see if there is a result on the page correctly.
      //@TODO: 2. Need to move existing pieces (WebPageEssentials) over to infrastructure area
      //@TODO: 3. Rename alot of those classes
      //@TODO: 4. Make a new copy
      //@TODO: 5. Probably fill in the tests




    } catch (InterruptedException e) {
      e.printStackTrace();
    }
//      driver.quit();
  }
}

