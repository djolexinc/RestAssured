package rest.restAssured.pet;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import Objects.Pet;
import classes.BaseConfig;
import classes.PetActions;



public class UploadImageTest extends BaseConfig
{
	@Test
	public void UploadImage()
	{	
		Random rand = new Random();
		int  randomNumber = rand.nextInt(500000) + 1;
		String tempId1= Integer.toString(randomNumber);
		
		Pet ker = new Pet();
		PetActions pets = new PetActions();
		ker.setId(tempId1);
		ker.setImg("imgUrl");
 
		final Response response = 	pets.createNewPet(ker);
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		String  url = jsonPath.getString("photoUrls");	
		Assert.assertEquals(url, "imgUrl");
	}
	
}
