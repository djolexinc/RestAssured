package classes;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.response.Response;

public class OrderMethod 
{
	public Response getOrderById( int temp)
	{
		return(		
				given()
					.contentType("application/json")
				.when()
					.get("https://petstore.swagger.io/v2/store/order/"+temp)
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
