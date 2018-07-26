package rest.restAssured.pet;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import Objects.Pet;
import classes.BaseConfig;
import classes.PetActions;

public class FindPetByStatusTest extends BaseConfig
{
	String statusValue ="available";
    @Test
    public void findPetByStatus()
    {
    	JsonPath jsonPath;
		Pet ker = new Pet();
		PetActions pets = new PetActions();
		ker.setName("dogiex");
		ker.setStatus("available");
		
		final Response getResponse = pets.findPetByStatus(ker);
		
		String getResponseBody = getResponse.getBody().asString();
		jsonPath = new JsonPath(getResponseBody);
		List<Object> petStatus=  jsonPath.getList("status");
		Assert.assertEquals("available", (String) petStatus.get(1));
    }

	
}
