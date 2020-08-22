package disney.reservation.notification.domain.lumber;

import static disney.reservation.notification.domain.lumber.FetchLumberPriceAndNotify.BASE_URL;
import static disney.reservation.notification.domain.lumber.HtmlElementReferrer.PRICE_CSS_PATH;
import static disney.reservation.notification.domain.lumber.HtmlElementReferrer.PRODUCE_TITLE_CSS_PATH;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import disney.reservation.notification.domain.log.Logger;
import disney.reservation.notification.infrastructure.mail.MailerProxy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

class FetchLumberPriceAndNotifyUnitTest {

  private static final String EXPECTED_TITLE = "title";
  private static final String EXPECTED_PRICE = "$ 3.45 USD";
  private static final String EXPECTED_MORE_THAN_THRESHOLD_PRICE = "$ 4.05 USD";

  @Test
  public void apply_whenPriceIsLessThanThreshold_willSendOutMail() throws Exception {
    // Arrange
    final RemoteWebDriver mockRemoteWebDriver = mock(RemoteWebDriver.class);
    final Logger mockLogger = mock(Logger.class);
    final MailerProxy mockMailerProxy = mock(MailerProxy.class);
    final String expectedMessage = "was less than threshold! Sending out txt message!";

    mockProductTitle(mockRemoteWebDriver);
    mockPriceWidgetWithPriceLessThanThreshold(mockRemoteWebDriver);

    final FetchLumberPriceAndNotify target =
        new FetchLumberPriceAndNotify(mockRemoteWebDriver, mockLogger, mockMailerProxy);

    // Act
    target.apply();

    // Assert
    verify(mockRemoteWebDriver).get(BASE_URL);
    verify(mockLogger).info(EXPECTED_TITLE
        .concat("\n with price: ")
        .concat(EXPECTED_PRICE));
    verify(mockMailerProxy)
        .send(EXPECTED_TITLE, EXPECTED_PRICE);
    verify(mockLogger).info(expectedMessage);
  }

  @Test
  public void apply_whenPriceIsMoreThanThreshold_willNotSendOutMail() throws Exception {
    // Arrange
    final RemoteWebDriver mockRemoteWebDriver = mock(RemoteWebDriver.class);
    final Logger mockLogger = mock(Logger.class);
    final MailerProxy mockMailerProxy = mock(MailerProxy.class);
    final String expectedMessage = "was more than threshold. Not sending out txt message.";

    mockProductTitle(mockRemoteWebDriver);
    mockPriceWidgetWithPriceMoreThanThreshold(mockRemoteWebDriver);

    final FetchLumberPriceAndNotify target =
        new FetchLumberPriceAndNotify(mockRemoteWebDriver, mockLogger, mockMailerProxy);

    // Act
    target.apply();

    // Assert
    verify(mockRemoteWebDriver).get(BASE_URL);
    verify(mockLogger).info(EXPECTED_TITLE
        .concat("\n with price: ")
        .concat(EXPECTED_MORE_THAN_THRESHOLD_PRICE));
    verify(mockLogger).info(expectedMessage);
  }

  private void mockProductTitle(RemoteWebDriver mockRemoteWebDriver) {
    final WebElement mockProductTitle = mock(WebElement.class);

    when(mockProductTitle.getText())
        .thenReturn(EXPECTED_TITLE);
    when(mockRemoteWebDriver.findElementByCssSelector(PRODUCE_TITLE_CSS_PATH))
        .thenReturn(mockProductTitle);
  }

  private void mockPriceWidgetWithPriceLessThanThreshold(RemoteWebDriver mockRemoteWebDriver) {
    final WebElement mockPriceWidget = mock(WebElement.class);

    when(mockPriceWidget.getText())
        .thenReturn(EXPECTED_PRICE);
    when(mockRemoteWebDriver.findElementByCssSelector(PRICE_CSS_PATH))
        .thenReturn(mockPriceWidget);
  }

  private void mockPriceWidgetWithPriceMoreThanThreshold(RemoteWebDriver mockRemoteWebDriver) {
    final WebElement mockPriceWidget = mock(WebElement.class);

    when(mockPriceWidget.getText())
        .thenReturn(EXPECTED_MORE_THAN_THRESHOLD_PRICE);
    when(mockRemoteWebDriver.findElementByCssSelector(PRICE_CSS_PATH))
        .thenReturn(mockPriceWidget);
  }
}