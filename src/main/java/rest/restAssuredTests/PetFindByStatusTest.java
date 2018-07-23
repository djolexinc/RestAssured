package rest.restAssuredTests;
import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

import classes.BaseConfig;
import classes.Pet;

public class PetFindByStatusTest extends BaseConfig
{
	String statusValue ="available";
    @Test
    public void findPetByStatus() {
    	
		Pet ker = new Pet();
		ker.setName("dogiex");
		ker.setStatus("available");
				given()
						.contentType("application/json")
						.body(ker)
					.when()
						.get("/pet/findByStatus?status=available")
					.then()
						.statusCode(200)
						.extract()
						.response();     
    }

	
}
