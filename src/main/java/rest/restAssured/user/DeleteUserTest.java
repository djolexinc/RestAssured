package rest.restAssured.user;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import Objects.Users;
import classes.BaseConfig;
import classes.UserActions;

public class DeleteUserTest extends BaseConfig{

	@Test
	public void deleteUser()
	{	
		
		Random rand = new Random();
		int  randomNumber = rand.nextInt(500000) + 1;
		String tempId= Integer.toString(randomNumber);
		
		String tempUsername = "User12345";
		Users user1 = new Users();
		UserActions visitor1 = new UserActions();
		user1.setId(Integer.parseInt(tempId));
		user1.setUsername(tempUsername);
		user1.setFirstName("Name");
		user1.setLastName("LastName");
		user1.setEmail("placebo@dom.com");
		user1.setPassword("false123");
		user1.setPhone("1234567");
		
		visitor1.createNewUser(user1);
		final Response response =  visitor1.getUserInfo(tempUsername);
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		String username = jsonPath.getString("username");
		Assert.assertEquals(username, tempUsername);

		visitor1.deleteUser(tempUsername);
			
		final Response deleteUserResponse = visitor1.deletedUserResponse(tempUsername); 
		int responseCode = deleteUserResponse.statusCode();
	 	Assert.assertEquals(responseCode, 404);

	}
	
	


}
