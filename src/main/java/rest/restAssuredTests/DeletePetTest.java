package rest.restAssuredTests;

import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import classes.BaseConfig;
import classes.Pet;
import classes.PetMethod;
import junit.framework.Assert;



public class DeletePetTest extends BaseConfig
{
	@Test
	public void DeletePetById()
	{
		String tempId1 = "123123333" ;
		Pet ker2 = new Pet();
		PetMethod pets = new PetMethod();
		
		ker2.setName("dogoman");
		ker2.setStatus("available");
		ker2.setId(tempId1);
		ker2.setImg("imgAdress");
		
		final Response postResponse = pets.createNewPet(ker2);
		String postResponseBody = postResponse.getBody().asString();
		JsonPath jsonPathPost = new JsonPath(postResponseBody);
		String idPost= jsonPathPost.getString("id");
		Assert.assertEquals(idPost, tempId1);
		
		pets.deletePet(ker2, tempId1);
		
		final Response response = pets.getDeletedPetStatus(tempId1);
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		String id= jsonPath.getString("id");
		Assert.assertEquals(id, null);
	
	}
	
}
