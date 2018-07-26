package rest.restAssured.pet;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import Objects.Pet;
import classes.BaseConfig;
import classes.PetActions;


public class CreateNewPetTest extends BaseConfig
{
	@Test
	public void PostPetInfo()
	{
		JsonPath jsonPath;
		Random rand = new Random();
		int  randomNumber = rand.nextInt(500000) + 1;
		String temporaryId= Integer.toString(randomNumber);
		
		Pet ker = new Pet();
		PetActions pets = new PetActions();
		ker.setName("dogoman");
		ker.setStatus("available");
		ker.setId(temporaryId);
		ker.setImg("imgAdress");

		final Response response = pets.createNewPet(ker);
		String responseBody = response.getBody().asString();
		jsonPath = new JsonPath(responseBody);
		String  name = jsonPath.getString("name");	
		
    	final Response getResponse = pets.getPetById(temporaryId);   			
		String getResponseBody = getResponse.getBody().asString();
		jsonPath = new JsonPath(getResponseBody);
		String  nameGet = jsonPath.getString("name");	
		Assert.assertEquals(name, nameGet);
		
	}
}
