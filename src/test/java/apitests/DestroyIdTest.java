package apitests;

import appmanager.TestBase;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Created by Олег Калужин on 26.06.2017.
 */
public class DestroyIdTest extends TestBase {

  @Test
  public void testDestroyId(){
    //Delete tweet

    Map<String,String> id = new HashMap<String,String>();
    id.put("id", twittId);

    given().auth().oauth(auth.consumerKey, auth.consumerSecret, auth.token, auth.tokenSecret)
            .contentType("application/json")
            .body(id)
            .when().post(apiBase + "destroy/" + twittId + ".json");

    //check that user can't delete the same tweet
    given().auth().oauth(auth.consumerKey, auth.consumerSecret, auth.token, auth.tokenSecret)
            .contentType("application/json")
            .body(id)
            .when().post(apiBase + "destroy/" + twittId + ".json")
            .then()
            .body(containsString("No status found with that ID."))
            .statusCode(404);
  }
}
