package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by Олег Калужин on 27.06.2017.
 */
public class TwittPage {

  private WebDriver wd;
  private By textField = By.xpath(".//*[@id='tweet-box-global']");
  private By submitTwitt = By.xpath(".//*[@id='global-tweet-dialog-dialog']/div[2]/div[4]/form/div[3]/div[2]/button");
  private By errorMessage = By.xpath(".//*[@id='message-drawer']/div/div/span");


  public TwittPage(WebDriver driver) {
    this.wd = driver;
  }

  public TwittPage fiilTextField(String text) {
    wd.findElement(textField).sendKeys(text);
    return this;
  }

  public void submitTwitt() throws InterruptedException {
    wd.findElement(submitTwitt).click();
    Thread.sleep(3000);
  }

  public void checkError() {
    wd.findElement(errorMessage).isDisplayed();
    String s = wd.findElement(errorMessage).getText();
    Assert.assertEquals(s, "Вы уже отправили этот твит.");
  }



}
