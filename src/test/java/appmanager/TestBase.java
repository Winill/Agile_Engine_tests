package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by Олег Калужин on 26.06.2017.
 */
public class TestBase {

  protected WebDriver wd;
  protected final AuthHelper auth = new AuthHelper();
  protected String apiBase = "https://apitests.twitter.com/1.1/statuses/";
  protected String twittId = "879296039475449858";

  public AuthHelper getAuth() {
    return auth;
  }

  @BeforeMethod
  public void setup(){
    System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wd.get("https://twitter.com/");
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

}
