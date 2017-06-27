package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Олег Калужин on 27.06.2017.
 */
public class LoginPage {
  private WebDriver wd;
  private By loginLocator = By.xpath(".//*[@id='signin-email']");
  private By passwordLocator = By.xpath(".//*[@id='signin-password']");
  private By submitLocator = By.xpath(".//*[@id='front-container']/div[2]/div[2]/form/table/tbody/tr/td[2]/button");


  public LoginPage(WebDriver driver) {
    this.wd = driver;
  }

  public LoginPage typeUsername(String username) {
    wd.findElement(loginLocator).sendKeys(username);
    return this;
  }

  public LoginPage typePassword(String password) {
    wd.findElement(passwordLocator).sendKeys(password);
    return this;
  }


  public void submitLogin() throws InterruptedException {
    wd.findElement(submitLocator).submit();
    Thread.sleep(3000);
  }
}

