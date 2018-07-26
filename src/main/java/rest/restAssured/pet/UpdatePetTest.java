package rest.restAssured.pet;

import java.util.Random;

import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import Objects.Pet;
import classes.BaseConfig;
import classes.PetActions;
import junit.framework.Assert;

public class UpdatePetTest extends BaseConfig
{

	 @Test
	    public void PostGetUpdateGet()
	    {	
		 	JsonPath jsonPath;
			Random rand = new Random();
			int  randomNumber = rand.nextInt(500000) + 1;
			String tempId1= Integer.toString(randomNumber);
			
	    	PetActions pets = new PetActions();
	    	
			Pet ker3 = new Pet();
			ker3.setName("dogomance");
			ker3.setStatus("available");
			ker3.setId(tempId1);
			ker3.setImg("imgAdress");

			final Response postResponse1 = pets.createNewPet(ker3);
			String postResponseBody1 = postResponse1.getBody().asString();
			jsonPath = new JsonPath(postResponseBody1);
			String idPost1= jsonPath.getString("id");
			
	    	final Response getResponse1 = 	pets.getPetById(idPost1);
			String getResponseBody1 = getResponse1.getBody().asString();
			jsonPath = new JsonPath(getResponseBody1);
			String idGet1= jsonPath.getString("id");
			
			Assert.assertEquals(idGet1, idPost1);
				
			ker3.setName("updated1");
			ker3.setStatus("false");
			ker3.setId(tempId1);
			
			final Response updateResponse2 = pets.updatePet(ker3);
			String updateResponseBody = updateResponse2.getBody().asString();
			jsonPath = new JsonPath(updateResponseBody);
			String newKerName= jsonPath.getString("name");
			String newKerStatus= jsonPath.getString("status");
	    
	    	final Response getResponse11 = pets.getPetById(idGet1);	
			String getResponseBody11 = getResponse11.getBody().asString();
			jsonPath = new JsonPath(getResponseBody11);
			String KerName = jsonPath.getString("name");
			String KerStatus = jsonPath.getString("status");
			
			Assert.assertEquals(KerName, newKerName);
			Assert.assertEquals(KerStatus, newKerStatus);
	    }
	
}
