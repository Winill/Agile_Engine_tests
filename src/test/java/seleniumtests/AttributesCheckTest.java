package seleniumtests;

import appmanager.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.TwittPage;

/**
 * Created by Олег Калужин on 27.06.2017.
 */
public class AttributesCheckTest extends TestBase {

  private LoginPage loginPage;
  private HomePage homePage;

  @Test
  public void testTwittAttributes() throws InterruptedException {
    loginPage = new LoginPage(wd);
    loginPage.typeUsername("o_kaluzhyn");
    loginPage.typePassword("Olaneg152");
    loginPage.submitLogin();
    homePage = new HomePage(wd);
    //This check is necessary
    homePage.checkThatTweetIsPresentOnPage();
    homePage.checkDataTime();
    homePage.checkText();
    homePage.checkRetwitt();


  }
}
