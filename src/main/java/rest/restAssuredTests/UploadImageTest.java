package rest.restAssuredTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import classes.BaseConfig;
import classes.Pet;
import classes.PetMethod;



public class UploadImageTest extends BaseConfig
{
	@Test
	public void UploadImage()
	{
		Pet ker = new Pet();
		PetMethod pets = new PetMethod();
		ker.setId("123123333");
		ker.setImg("imgUrl");
 
		final Response response = 	pets.createNewPet(ker);
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		String  url = jsonPath.getString("photoUrls");	
		Assert.assertEquals(url, "imgUrl");
	}
	
}
