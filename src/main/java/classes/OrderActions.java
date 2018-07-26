package classes;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.response.Response;

import Objects.Order;

public class OrderActions 
{
	public Response getOrderById( int randomId)
	{
		return(		
				given()
					.contentType("application/json")
				.when()
					.get("https://petstore.swagger.io/v2/store/order/"+randomId)
				.then()
					.statusCode(200)
					.extract()
					.response()
				);
	}
	
	public Response createNewOrder(Order order1)
	{
		return(		
			given()
				.contentType("application/json")
				.body(order1)
			.when()
				.post("/store/order")
			.then()
				.statusCode(200)
				.extract()
				.response()
				);
	}
	
	public Response deleteOrder(int orderID)
	{
		return(				
			given()
				.contentType("application/json")
			.when()
				.delete("https://petstore.swagger.io/v2/store/order/"+orderID)
			.then()
				.statusCode(200)
				.extract()
				.response()
			);
	}
		public Response deletedOrderResponse(int orderID)
		{	
		return (
			given()
				.contentType("application/json")
			.when()
				.get("https://petstore.swagger.io/v2/store/order/"+orderID)
			.then()
				.statusCode(404)
				.extract()
				.response()
				);

	}
		public Response getInventory()
		{	
		return (
				given()
				.contentType("application/json")
			.when()
				.get("/store/inventory")
			.then()
				.statusCode(200)
				.extract()
				.response()
				);

	}

	
	
}
