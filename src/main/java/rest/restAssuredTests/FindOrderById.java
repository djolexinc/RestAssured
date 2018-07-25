package rest.restAssuredTests;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import classes.BaseConfig;
import classes.Order;
import classes.OrderMethod;

public class FindOrderById extends BaseConfig{

	@Test
	public void getInventory()
	{	
		int temp = 4;
		Order order1 = new Order();
		order1.setOrderId(temp);
		
		OrderMethod orders1 = new OrderMethod();
		orders1.createNewOrder(order1);
		final Response response = orders1.getOrderById(temp);
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		int orderID = jsonPath.getInt("id");
		Boolean complete = jsonPath.getBoolean("complete");
		Assert.assertEquals(orderID, 4);
		Assert.assertFalse(complete);
	
	}


}
