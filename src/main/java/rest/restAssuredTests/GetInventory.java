package rest.restAssuredTests;

import static com.jayway.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class GetInventory {

	@Test
	public void getInventory()
	{
        given().when().get("https://petstore.swagger.io/v2/store/order/10").then().statusCode(200);
	}


}
