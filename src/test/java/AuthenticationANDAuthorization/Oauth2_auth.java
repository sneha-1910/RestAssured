package AuthenticationANDAuthorization;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_auth {

	@Test
	public void oauth2()
	{
		//create a request to generate acces token 
		         Response res = given()
		           .formParam("client_id", "SDET_50")
		           .formParam("client_secret", "1fabb87089fcdb590c3b329c059ee27c")
		            .formParam("grant_type", "client_credentials")
		            .formParam("redirect_uri", "http://example.com")
		            .formParam("code", "authorization_code ")
		            
		            .when()
		            .post("http://coop.apps.symfonycasts.com/token");
		            
		            
		   //capture the access token from the response of the above request
		            
		            String token = res.jsonPath().get("access_token");
		            System.out.println(token);
		            
		  //create another request and use the use the token to access the apis 
		              
		            given().auth().oauth2(token).pathParam("user_id", "4675")
		            
		            .when()
		            .post("http://coop.apps.symfonycasts.com/api/{user_id}/eggs-count")
		            .then().log().all();
		            
		            
		 //another request
		            
		            given()
		            .auth().oauth2(token).pathParam("user_id", "4675")
		            .when().post("http://coop.apps.symfonycasts.com/api/{user_id}/eggs-collect")
		            .then().log().all();
		            
		            given()
		            .auth().oauth2(token).pathParam("user_id", "4675")
		            .when().post("http://coop.apps.symfonycasts.com/api/{user_id}/chickens-feed")
		            .then().log().all();
		            
		            given()
		            .auth().oauth2(token).pathParam("user_id", "4675")
		            .when().post("http://coop.apps.symfonycasts.com/api/{user_id}/toiletseat-down")
		            .then().log().all();
		            
		            given()
		            .auth().oauth2(token).pathParam("user_id", "4675")
		            .when().post("http://coop.apps.symfonycasts.com/api/{user_id}/barn-unlock")
		            .then().log().all();
		            
		            
		            given()
		            .auth().oauth2(token)
		            .when().get("http://coop.apps.symfonycasts.com/api/me")
		            .then().log().all();
	            
	}	
	
	

	
	
	
	
	
	
	
	
	
	
}
