package rest.restAssured.order;

import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;
import classes.BaseConfig;
import classes.OrderActions;
import junit.framework.Assert;


public class GetStoreInventoryTest extends BaseConfig
{
	@Test
	public void getInventory()
	{
		OrderActions orders1 = new OrderActions();
		final Response response = orders1.getInventory();
		int responseCode = response.statusCode();
		Assert.assertEquals(200, responseCode);
	}
}
