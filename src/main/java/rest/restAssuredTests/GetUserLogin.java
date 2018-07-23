package rest.restAssuredTests;

import static com.jayway.restassured.RestAssured.given;
import org.testng.annotations.Test;

import classes.BaseConfig;


public class GetUserLogin extends BaseConfig
{
	@Test
	public void getInventory()
	{
        given().when().get("/user/login?username=test&password=abc123").then()
        
       // .body("",equalTo("FirstName"))
        .statusCode(200);
	}
}
