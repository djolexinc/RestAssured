package classes;

public class Users extends BaseConfig
{
	  int id;
	  String username;
	  String firstName;
	  String lastName;
	  String email;
	  String password;
	  String phone;
	  int userStatus;
	
	public Users()
	{
		
	}
	
	public void setId(int orderId)
	{
		this.id = orderId;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public void setFirstName (String firstName)
	{
		this.firstName = firstName;
	}
	public void setEmail (String email)
	{
		this.email = email;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public void setUserStatus(int userStatus)
	{
		this.userStatus = userStatus;
	}
}
