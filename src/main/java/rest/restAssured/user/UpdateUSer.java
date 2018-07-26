package rest.restAssured.user;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import Objects.Users;
import classes.BaseConfig;
import classes.UserActions;

public class UpdateUSer extends BaseConfig
{

	@Test
	public void UpdateUser()
	{	
		JsonPath jsonPath;
		String tempUsername = "User1234";
		Users user1 = new Users();
		UserActions visitor1 = new UserActions();
		user1.setId(1);
		user1.setUsername(tempUsername);
		user1.setFirstName("Name");
		user1.setLastName("LastName");
		user1.setEmail("placebo@dom.com");
		user1.setPassword("false123");
		user1.setPhone("1234567");
		
		visitor1.createNewUser(user1);  //create new user

		final Response response =  visitor1.getUserInfo(tempUsername); //read data
		String responseBody = response.getBody().asString();
		jsonPath = new JsonPath(responseBody);
		String oldName = jsonPath.getString("firstName");

		user1.setFirstName("Namee1");
		user1.setLastName("LastName1");
		user1.setId(4);

		visitor1.updateUser(user1, tempUsername); // update 
		
		final Response updResponse = visitor1.getUserInfo(tempUsername); // read updated data
		String updBody = updResponse.getBody().asString();
		jsonPath = new JsonPath(updBody);
		String newName = jsonPath.getString("firstName");
		
		Assert.assertNotEquals(oldName, newName); // old name and new name not equals
	}
	
	
	
	

}
