package appmanager;

/**
 * Created by Олег Калужин on 26.06.2017.
 */
public class TestBase {

  protected final AuthHelper auth = new AuthHelper();
  protected String apiBase = "https://api.twitter.com/1.1/statuses/";

  public AuthHelper getAuth() {
    return auth;
  }
}
