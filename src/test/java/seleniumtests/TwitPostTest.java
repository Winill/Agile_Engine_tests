package seleniumtests;

import appmanager.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.TwittPage;

/**
 * Created by Олег Калужин on 27.06.2017.
 */
public class TwitPostTest extends TestBase {
  private LoginPage loginPage;
  private HomePage homePage;
  private TwittPage twittPage;

  @Test
  public void testTwittPost() throws InterruptedException {
    loginPage = new LoginPage(wd);
    loginPage.typeUsername("o_kaluzhyn");
    loginPage.typePassword("Olaneg152");
    loginPage.submitLogin();
    homePage = new HomePage(wd);
    homePage.pressTwitt();
    twittPage = new TwittPage(wd);
    twittPage.fiilTextField("test26");
    twittPage.submitTwitt();
    //Check that twit can't be duplicated
    homePage.pressTwitt();
    twittPage = new TwittPage(wd);
    twittPage.fiilTextField("test26");
    twittPage.submitTwitt();
    twittPage.checkError();
    }
}
