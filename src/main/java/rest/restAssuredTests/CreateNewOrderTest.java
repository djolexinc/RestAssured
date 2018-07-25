package rest.restAssuredTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import classes.BaseConfig;
import classes.OrderMethod;
import classes.Order;

public class CreateNewOrderTest extends BaseConfig{

	
	@Test
	public void CreatingNewOrder()
	{
		String tempId= "123123333";
		int orderId= 1;
		Order order1 = new Order();
		OrderMethod orders = new OrderMethod();
		
		order1.setOrderId(orderId);
		order1.setPetId(tempId);
		order1.setQuantity("1");
		order1.setShipDate("2018-07-23T13:34:13.279Z");
		order1.setStatus("placed");
		order1.setCompleteStatus(false);

		final Response createOrderResponse = orders.createNewOrder(order1);
		String createBody = createOrderResponse.getBody().asString();
		JsonPath jsonPath = new JsonPath(createBody);
		int orderID = jsonPath.getInt("id");
		String petID = jsonPath.getString("petId");
		
		final Response getOrderResponse = orders.getOrderById(orderId); // order id not pet id
		String responseBody = getOrderResponse.getBody().asString();
		JsonPath jsonPath1 = new JsonPath(responseBody);
		
		String petID1 = jsonPath1.getString("petId");
		Assert.assertEquals(orderID, 1);
		Assert.assertEquals(petID, petID1);

	}
	

}
