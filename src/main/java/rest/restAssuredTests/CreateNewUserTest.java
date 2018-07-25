package rest.restAssuredTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import classes.BaseConfig;
import classes.UserMethod;
import classes.Users;

public class CreateNewUserTest extends BaseConfig{

	
	@Test
	public void CreateNewUser()
	{
		String tempUsername = "User1234";
		Users user1 = new Users();
		UserMethod visitor1 = new UserMethod();
		user1.setId(1);
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
		Reporter.log(responseBody, true);
		String username = jsonPath.getString("username");
		Assert.assertEquals(username, tempUsername);
	}
	

}
