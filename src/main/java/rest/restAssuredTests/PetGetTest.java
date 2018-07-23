package rest.restAssuredTests;
import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

import classes.BaseConfig;



public class PetGetTest extends BaseConfig
{

    @Test
    public void findPetById() {
        given().when().get("/pet/1032").then().statusCode(200);

    }

	
}
