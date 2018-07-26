package classes;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.response.Response;

import Objects.Pet;

public class PetActions 
{

	public Response getPetById( String temp)
	{
	return(	
		given()
		.contentType("application/json")
		.when()
			.get("/pet/"+temp)
		.then()
			.statusCode(200)
			.extract()
			.response()
		);
	}
	
	public Response createNewPet(Pet ker)
	{
	return (		
		given()
			.contentType("application/json")
			.body(ker)
		.when()
			.post("/pet")
		.then()
			.statusCode(200)
			.extract()
			.response()
		);			
	}
	
	public void deletePet (String id)
	{
		given()
			.contentType("application/json")
		.when()
			.delete("/pet/"+id)
		.then()
			.statusCode(200);
	}
	
	public Response getDeletedPetStatus( String randomId)
	{
	return
			(	
		given()
			.contentType("application/json")
			.when()
				.get("/pet/"+randomId)
			.then()
				.statusCode(404)
				.extract()
				.response()
		);
	}
	
	public Response updatePet(Pet ker)
	{
		return
		(			
			given()
				.contentType("application/json")
				.body(ker)
			.when()
				.put("/pet") 	
			.then()
				.statusCode(200)
				.extract()
				.response()			
		);
	}
	
	public Response findPetByStatus(Pet ker)
	{
		return
			(
			given()
				.contentType("application/json")
				.body(ker)
			.when()
				.get("/pet/findByStatus?status=available")
			.then()
				.statusCode(200)
				.extract()
				.response()
				);     
	}
	
}
