package rest.restAssuredTests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;
import classes.BaseConfig;
import classes.OrderMethod;
import junit.framework.Assert;


public class GetStoreInventoryTest extends BaseConfig
{
	@Test
	public void getInventory()
	{
		OrderMethod orders1 = new OrderMethod();
		final Response response = orders1.getInventory();
		String responseBody = response.getBody().asString();
		Reporter.log("JSON: "+responseBody, true);
		int responseCode = response.statusCode();
		Assert.assertEquals(200, responseCode);
	}
}
