package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertFalse;

/**
 * Created by Олег Калужин on 27.06.2017.
 */
public class HomePage {

  private WebDriver wd;
  private By buttonTwitt = By.xpath(".//*[@id='global-new-tweet-button']");
  private By additionalMenu = By.xpath("//ol[@id='stream-items-id']/li[1]//div[@class='dropdown']");
  private By buttonTwittDelete = By.xpath("//ol[@id='stream-items-id']/li[1]//ul[@role='menu']//li[@class='js-actionDelete']/button");
  private By submitDelete = By.xpath(".//*[@id='delete-tweet-dialog-dialog']/div[2]/div[4]/button[2]");
  private By lastTweet = By.xpath("//ol[@id='stream-items-id']/li[1]");
  private By dataTime = By.xpath("//ol[@id='stream-items-id']/li[1]//span[contains(@class, '_timestamp')]");
  private By text = By.xpath("//ol[@id='stream-items-id']/li[1]//div[@class='js-tweet-text-container']/p");
  private By reTwitt = By.xpath("//ol[@id='stream-items-id']/li[1]//button[@data-modal='ProfileTweet-retweet']");
  private String tweetId = "";

  public HomePage(WebDriver driver) {
    this.wd = driver;
  }

  public void pressTwitt(){
    wd.findElement(buttonTwitt).click();
  }

  public void pressAdditionalMenu(){
    wd.findElement(additionalMenu).click();
  }

  public void pressTwittDelete(){
    wd.findElement(buttonTwittDelete).click();
  }

  public void submitDelete() throws InterruptedException {
    wd.findElement(submitDelete).click();
    Thread.sleep(2000);
  }

  public void getAttribute() {
    String id =wd.findElement(lastTweet).getAttribute("data-item-id");
    tweetId +=id;
  }

  public void checkThatTwittDeleted() {
    assertFalse(isElementPresent(By.xpath("./*//*[@id='stream-item-tweet-" + tweetId + "']")));
  }

  public void checkThatTweetIsPresentOnPage() {
    isElementPresent(lastTweet);
  }

  public void checkDataTime() {
    String time = wd.findElement(dataTime).getAttribute("data-time");
    System.out.println(time);
  }

  public void checkText() {
    String text = wd.findElement(this.text).getText();
    System.out.println(text);
  }

  public void checkRetwitt() {
    isElementPresent(reTwitt);
  }

  public boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
