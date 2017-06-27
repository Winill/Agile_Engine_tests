package seleniumtests;

import appmanager.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

/**
 * Created by Олег Калужин on 27.06.2017.
 */
public class DeleteTwittTest extends TestBase {

  LoginPage loginPage;
  HomePage homePage;

  @Test
  public void testDeleteTwitt() throws InterruptedException {
    loginPage = new LoginPage(wd);
    loginPage.typeUsername("o_kaluzhyn");
    loginPage.typePassword("Olaneg152");
    loginPage.submitLogin();
    homePage = new HomePage(wd);
    homePage.getAttribute();
    homePage.pressAdditionalMenu();
    homePage.pressTwittDelete();
    homePage.submitDelete();
    homePage.checkThatTwittDeleted();
  }
}
