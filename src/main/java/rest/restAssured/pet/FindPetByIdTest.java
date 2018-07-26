package rest.restAssured.pet;

import java.util.Random;

import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import Objects.Pet;
import classes.BaseConfig;
import classes.PetActions;
import junit.framework.Assert;



public class FindPetByIdTest extends BaseConfig
{

    @Test
    public void findPetById()
    {
    	JsonPath jsonPath;
		Random rand = new Random();
		int  randomNumber = rand.nextInt(500000) + 1;
		String temporaryId= Integer.toString(randomNumber);

		Pet ker = new Pet();
		PetActions function = new PetActions();
		ker.setName("dogoman");
		ker.setStatus("available");
		ker.setId(temporaryId);
		ker.setImg("imgAdress");
		
		final Response postResponse = function.createNewPet(ker);
		String postResponseBody = postResponse.getBody().asString();
		jsonPath = new JsonPath(postResponseBody);
		String idPost= jsonPath.getString("id");
	
		
    	final Response getResponse = function.getPetById(temporaryId);   			
		String getResponseBody = getResponse.getBody().asString();
		jsonPath = new JsonPath(getResponseBody);
		String idGet= jsonPath.getString("id");

		Assert.assertEquals(idGet, idPost);
    }
    
   
}
