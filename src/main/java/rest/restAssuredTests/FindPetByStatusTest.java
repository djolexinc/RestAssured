package rest.restAssuredTests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import classes.BaseConfig;
import classes.Pet;
import classes.PetMethod;

public class FindPetByStatusTest extends BaseConfig
{
	String statusValue ="available";
    @Test
    public void findPetByStatus() {
    	
		Pet ker = new Pet();
		PetMethod pets = new PetMethod();
		ker.setName("dogiex");
		ker.setStatus("available");
		
		final Response getResponse = pets.findPetByStatus(ker);
		
		String getResponseBody = getResponse.getBody().asString();
		JsonPath jsonPathGet = new JsonPath(getResponseBody);
		List<Object> petStatus=  jsonPathGet.getList("status");
		Assert.assertEquals("available", (String) petStatus.get(1));
    }

	
}
