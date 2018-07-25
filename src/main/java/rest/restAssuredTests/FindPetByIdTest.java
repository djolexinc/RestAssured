package rest.restAssuredTests;

import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import classes.BaseConfig;
import classes.PetMethod;
import classes.Pet;
import junit.framework.Assert;



public class FindPetByIdTest extends BaseConfig
{

    @Test
    public void findPetById()
    {
    	String temporaryId = "123123333" ;
		Pet ker = new Pet();
		PetMethod function = new PetMethod();
		ker.setName("dogoman");
		ker.setStatus("available");
		ker.setId(temporaryId);
		ker.setImg("imgAdress");
		
		final Response postResponse = function.createNewPet(ker);
		String postResponseBody = postResponse.getBody().asString();
		JsonPath jsonPathPost = new JsonPath(postResponseBody);
		String idPost= jsonPathPost.getString("id");
	
		
    	final Response getResponse = function.getPetById(temporaryId);   			
		String getResponseBody = getResponse.getBody().asString();
		JsonPath jsonPathGet = new JsonPath(getResponseBody);
		String idGet= jsonPathGet.getString("id");

		Assert.assertEquals(idGet, idPost);
    }
    
   
}
