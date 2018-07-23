package classes;

public class Pet 
{
	@SuppressWarnings("unused")
	private String name;
	private String  id;
	private String status;
	private String photoUrls= "url-photo";
	public Pet()
	{
		
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public void setId( String id)
	{
		this.id = id;
	}
}
