package apitests;

import appmanager.TestBase;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Created by Олег Калужин on 26.06.2017.
 */
public class HomeTimelineTest extends TestBase{

  @Test
  public void testHomeTimeLine(){
    //Check that response body has fields
    given().auth().oauth(auth.consumerKey, auth.consumerSecret, auth.token, auth.tokenSecret).
             get(apiBase +  "home_timeline.json").then()
            .body(containsString("text"))
            .body(containsString("retweet_count"))
            .body(containsString("text"));
  }
}
