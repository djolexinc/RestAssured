package rest.restAssured.user;

import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;
import classes.BaseConfig;
import classes.UserActions;
import junit.framework.Assert;

public class UserLogOut extends BaseConfig
	{
		@Test
		public void checkUserLogin()
		{
			UserActions users = new UserActions();
			users.userLogin();
			Response response = users.logOutUser();
			int responseCode = response.statusCode();
			Assert.assertEquals(200, responseCode);
		}
	
}
