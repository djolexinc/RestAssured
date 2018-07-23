package rest.restAssuredTests;

import static com.jayway.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import classes.BaseConfig;
import classes.Pet;


public class UpdateExistingPetTesst extends BaseConfig
{
	@Test
	public void PostPetInfo()
	{
		Pet ker = new Pet();
		ker.setName("dogiex");
		ker.setId("15435006001943");
		
		final Response response = 	
			given()
				.contentType("application/json")
				.body(ker)
			.when()
				.put("/pet/")
			.then()
				.statusCode(200)
				.extract()
				.response();
		
		
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		String  name = jsonPath.getString("name");	
		Assert.assertEquals(name, "dogie1235");

	}
	
}
