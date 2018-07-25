package classes;

public class Order extends BaseConfig
{
	  int id;
	  String petId;
	  String quantity;
	  String shipDate;
	  String status;
	  Boolean complete;
	
	public Order()
	{
		
	}
	
	public void setOrderId(int orderId)
	{
		this.id = orderId;
	}
	public void setPetId(String petId)
	{
		this.petId = petId;
	}
	public void setQuantity (String quantity)
	{
		this.quantity = quantity;
	}
	public void setStatus (String status)
	{
		this.status = status;
	}
	public void setShipDate(String shipDate)
	{
		this.shipDate = shipDate;
	}
	public void setCompleteStatus(Boolean complete)
	{
		this.complete = complete;
	}
}
