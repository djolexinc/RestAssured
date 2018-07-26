package rest.restAssured.order;

import java.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import Objects.Order;
import classes.BaseConfig;
import classes.OrderActions;

import java.util.Random;

public class CreateNewOrderTest extends BaseConfig{

	
	@Test
	public void CreatingNewOrder()
	{
		JsonPath jsonPath;
		
		Random rand = new Random();
		int  randomNumber = rand.nextInt(500000) + 1;
		int  randomNumber1 = rand.nextInt(50) + 1;
		String tempId= Integer.toString(randomNumber);
		
		LocalDateTime now = LocalDateTime.now();  
		String dateString = now.toString();
		int orderId= randomNumber1;
		Order order1 = new Order();
		OrderActions orders = new OrderActions();
		
		order1.setOrderId(orderId);
		order1.setPetId(tempId);
		order1.setQuantity("0");
		order1.setShipDate(dateString);
		order1.setStatus("placed");
		order1.setCompleteStatus(false);

		final Response createOrderResponse = orders.createNewOrder(order1);
		
		String createBody = createOrderResponse.getBody().asString();
		jsonPath = new JsonPath(createBody);
		int orderID = jsonPath.getInt("id");
		String petID = jsonPath.getString("petId");
		
		final Response getOrderResponse = orders.getOrderById(orderId); // order id not pet id
		String responseBody = getOrderResponse.getBody().asString();
		jsonPath = new JsonPath(responseBody);
		
		String petID1 = jsonPath.getString("petId");
		Assert.assertEquals(orderID, randomNumber1);
		Assert.assertEquals(petID, petID1);

	}
	

}
