package rest.restAssured.pet;

import java.util.Random;

import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import Objects.Pet;
import classes.BaseConfig;
import classes.PetActions;
import junit.framework.Assert;



public class DeletePetTest extends BaseConfig
{
	@Test
	public void DeletePetById()
	{	JsonPath jsonPath;
	
		Random rand = new Random();
		int  randomNumber = rand.nextInt(500000) + 1;
		String tempId1= Integer.toString(randomNumber);
		
		Pet ker2 = new Pet();
		PetActions pets = new PetActions();
		
		ker2.setName("dogoman");
		ker2.setStatus("available");
		ker2.setId(tempId1);
		ker2.setImg("imgAdress");
		
		final Response postResponse = pets.createNewPet(ker2);
		String postResponseBody = postResponse.getBody().asString();
		jsonPath = new JsonPath(postResponseBody);
		String idPost= jsonPath.getString("id");
		Assert.assertEquals(idPost, tempId1);
		
		pets.deletePet (tempId1);
		
		final Response response = pets.getDeletedPetStatus(tempId1);
		String responseBody = response.getBody().asString();
		jsonPath = new JsonPath(responseBody);
		String id= jsonPath.getString("id");
		String statusOfPet = jsonPath.getString("status");
		
		Assert.assertEquals(id, null);
		Assert.assertEquals(null, statusOfPet);
	}
	
}
