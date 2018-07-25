package rest.restAssuredTests;

import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import classes.BaseConfig;
import classes.Pet;
import classes.PetMethod;
import junit.framework.Assert;

public class UpdatePetTest extends BaseConfig
{

	 @Test
	    public void PostGetUpdateGet()
	    {		
	    	String tempId1 = "1234567" ;
	    	PetMethod pets = new PetMethod();
	    	
			Pet ker3 = new Pet();
			ker3.setName("dogomance");
			ker3.setStatus("available");
			ker3.setId(tempId1);
			ker3.setImg("imgAdress");

			final Response postResponse1 = pets.createNewPet(ker3);
			String postResponseBody1 = postResponse1.getBody().asString();
			JsonPath jsonPathPost1 = new JsonPath(postResponseBody1);
			String idPost1= jsonPathPost1.getString("id");
			
	    	final Response getResponse1 = 	pets.getPetById(idPost1);
			String getResponseBody1 = getResponse1.getBody().asString();
			JsonPath jsonPathGet1 = new JsonPath(getResponseBody1);
			String idGet1= jsonPathGet1.getString("id");
			
			Assert.assertEquals(idGet1, idPost1);
				
			ker3.setName("updated1");
			ker3.setStatus("false");
			ker3.setId(tempId1);
			
			final Response updateResponse2 = pets.updatePet(ker3);
			String updateResponseBody = updateResponse2.getBody().asString();
			JsonPath jsonPathPut = new JsonPath(updateResponseBody);
			String newKerName= jsonPathPut.getString("name");
			String newKerStatus= jsonPathPut.getString("status");
	    
	    	final Response getResponse11 = pets.getPetById(idGet1);	
			String getResponseBody11 = getResponse11.getBody().asString();
			JsonPath jsonPathGet11 = new JsonPath(getResponseBody11);
			String KerName = jsonPathGet11.getString("name");
			String KerStatus = jsonPathGet11.getString("status");
			
			Assert.assertEquals(KerName, newKerName);
			Assert.assertEquals(KerStatus, newKerStatus);
	    }
	
}
