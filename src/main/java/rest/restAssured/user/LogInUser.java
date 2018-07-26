package rest.restAssured.user;

import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;
import classes.BaseConfig;
import classes.UserActions;
import junit.framework.Assert;


public class LogInUser extends BaseConfig
{
	@Test
	public void logInUser()
	{
		UserActions users = new UserActions();
		Response response = users.userLogin();
		int responseCode = response.statusCode();
		Assert.assertEquals(200, responseCode);
	}
}
