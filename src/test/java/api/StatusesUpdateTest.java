package api;

import appmanager.TestBase;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Created by Олег Калужин on 26.06.2017.
 */
public class StatusesUpdateTest extends TestBase {

  @Test
  public void testDestroyId() {

    //Add new tweet and after that check that user can't duplicate it
    Map<String,String> message = new HashMap<String,String>();
    message.put("status", "test11");

    given().auth().oauth(auth.consumerKey, auth.consumerSecret, auth.token, auth.tokenSecret)
            .contentType("application/json")
            .body(message)
            .when().post(apiBase + "update.json?status=test11");

    given().auth().oauth(auth.consumerKey, auth.consumerSecret, auth.token, auth.tokenSecret)
            .contentType("application/json")
            .body(message)
            .when().post(apiBase + "update.json?status=test10")
            .then()
            .body(containsString("Status is a duplicate."))
            .statusCode(403);
  }
}
