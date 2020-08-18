package disney.reservation.notification.application;

import disney.reservation.notification.domain.WebPageEssentials.Reference.HtmlElementReferrer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
      final WebElement element = this.driver
          .findElementByXPath(htmlElementReferrer.DINING_RESERVATION_DATE_XPATH);

      this.driver.executeScript(
          "document.querySelector(" + htmlElementReferrer.DATE_SELECTOR + ").value = '10/10/2020';",
          element);
      Thread.sleep(500);

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

