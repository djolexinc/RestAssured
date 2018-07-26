package rest.restAssured.order;


import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import Objects.Order;
import classes.BaseConfig;
import classes.OrderActions;

public class FindOrderById extends BaseConfig{

	@Test
	public void getInventory()
	{	
		Random rand = new Random();
		int  randomNumber = rand.nextInt(50) + 1;
		
		Order order1 = new Order();
		order1.setOrderId(randomNumber);
		
		OrderActions orders1 = new OrderActions();
		orders1.createNewOrder(order1);
		final Response response = orders1.getOrderById(randomNumber);
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		int orderID = jsonPath.getInt("id");
		Boolean complete = jsonPath.getBoolean("complete");
		Assert.assertEquals(orderID, randomNumber);
		Assert.assertFalse(complete);
	
	}


}
