package rest.restAssuredTests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;
import classes.BaseConfig;
import classes.UserMethod;
import junit.framework.Assert;

public class UserLogOut extends BaseConfig
	{
		@Test
		public void checkUserLogin()
		{
			UserMethod users = new UserMethod();
			users.userLogin();
			Response response = users.logOutUser();
			String responseBody = response.getBody().asString();
			Reporter.log(responseBody,true);
			int responseCode = response.statusCode();
			Assert.assertEquals(200, responseCode);
		}
	
}
