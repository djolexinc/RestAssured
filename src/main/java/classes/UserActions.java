package classes;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.response.Response;

import Objects.Users;


public class UserActions 
{
	public Response userLogin()
	{
		return (
	        given()
		        .when()
		        	.get("/user/login?username=test&password=abc123")
		        .then()
		        	.statusCode(200)	
		        	.extract()
		        	.response()
				);
		
	}
	public Response logOutUser()
	{
		return (
	        given()
		        .when()
		        	.get("/user/logout")
		        .then()
		        	.statusCode(200)	
		        	.extract()
		        	.response()
				);
		
	}
	
	
	public Response createNewUser(Users user1)
	{
		return (
			given()
					.contentType("application/json")
					.body(user1)
				.when()
					.post("/user/")
				.then()
					.statusCode(200)
					.extract()
					.response()
					);
		
	}
	
	public Response updateUser(Users user1, String username)
	{
		return (
			given()
					.contentType("application/json")
					.body(user1)
				.when()
					.put("/user/"+username)
				.then()
					.statusCode(200)
					.extract()
					.response()
					);
		
	}
		
	
	public Response getUserInfo(String username) 
	{
		return (
				given()
						.contentType("application/json")
					.when()
						.get("/user/"+username)
					.then()
						.statusCode(200)
						.extract()
						.response()
						);
	}
	
	
	public Response deleteUser(String user)
	{
		return(				
			given()
				.contentType("application/json")
			.when()
				.delete("https://petstore.swagger.io/v2/user/"+user)
			.then()
				.statusCode(200)
				.extract()
				.response()
			);
	}
	public Response deletedUserResponse(String username)
	{	
	return (
		given()
			.contentType("application/json")
		.when()
			.get("https://petstore.swagger.io/v2/user/"+username)
		.then()
			.statusCode(404)
			.extract()
			.response()
			);

}
}
