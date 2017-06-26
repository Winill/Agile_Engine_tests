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
public class DestroyIdTest extends TestBase {

  @Test
  public void testDestroyId(){
    //Delete tweet and after that check that user can't delete the same tweet
    Map<String,String> id = new HashMap<String,String>();
    id.put("id", "879296039475449858");

    given().auth().oauth(auth.consumerKey, auth.consumerSecret, auth.token, auth.tokenSecret)
            .contentType("application/json")
            .body(id)
            .when().post(apiBase + "destroy/879296039475449858.json");

    given().auth().oauth(auth.consumerKey, auth.consumerSecret, auth.token, auth.tokenSecret)
            .contentType("application/json")
            .body(id)
            .when().post(apiBase + "destroy/879296039475449858.json")
            .then()
            .body(containsString("No status found with that ID."))
            .statusCode(404);
  }
}
