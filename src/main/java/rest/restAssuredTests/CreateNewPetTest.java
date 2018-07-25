package rest.restAssuredTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import classes.BaseConfig;
import classes.Pet;
import classes.PetMethod;


public class CreateNewPetTest extends BaseConfig
{
	@Test
	public void PostPetInfo()
	{
		String temporaryId = "123123333";
		Pet ker = new Pet();
		PetMethod pets = new PetMethod();
		ker.setName("dogoman");
		ker.setStatus("available");
		ker.setId(temporaryId);
		ker.setImg("imgAdress");

		final Response response = pets.createNewPet(ker);
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		String  name = jsonPath.getString("name");	
		String status = jsonPath.getString("status");
		String id= jsonPath.getString("id");
		
    	final Response getResponse = pets.getPetById(temporaryId);   			
		String getResponseBody = getResponse.getBody().asString();
		JsonPath jsonPathGet = new JsonPath(getResponseBody);
		String  nameGet = jsonPathGet.getString("name");	
		
		Reporter.log("ID: "+id+ " Status: "+status,true);
		Assert.assertEquals(name, nameGet);
		
	}
}
