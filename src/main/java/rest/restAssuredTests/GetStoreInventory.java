package rest.restAssuredTests;

import static com.jayway.restassured.RestAssured.given;
import org.testng.annotations.Test;

import classes.BaseConfig;


public class GetStoreInventory extends BaseConfig
{
	@Test
	public void getInventory()
	{
        given().when().get("/store/inventory").then().statusCode(200);
	}
}
