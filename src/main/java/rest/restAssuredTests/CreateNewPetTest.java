package rest.restAssuredTests;

import static com.jayway.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import classes.BaseConfig;
import classes.Pet;


public class CreateNewPetTest extends BaseConfig
{
	@Test
	public void PostPetInfo()
	{
		Pet ker = new Pet();
		ker.setName("dogie13344");
		ker.setStatus("available");
		ker.setId("123123333");
		final Response response = 
				given()
					.contentType("application/json")
					.body(ker)
				.when()
					.post("/pet")
				.then()
					.statusCode(200)
					.extract()
					.response();
			
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		String  name = jsonPath.getString("name");	
		String status = jsonPath.getString("status");
		String id= jsonPath.getString("id");
		Reporter.log("ID: "+id+ " Status: "+status,true);
		Assert.assertEquals(name, "dogie13344");
		
	}
}
