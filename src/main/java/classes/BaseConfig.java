package classes;

import org.testng.annotations.BeforeClass;
import com.jayway.restassured.RestAssured;


public class BaseConfig 
{
	  
	@BeforeClass
	public static void setup()
	{
	
		String basePath = System.getProperty("server.base");
		String port = System.getProperty("server.port");
		String baseHost = System.getProperty("server.host");
		
		if (port == null)
		{
			RestAssured.port = Integer.valueOf(8080);
	    }
		else
	    {
			RestAssured.port = Integer.valueOf(port);
		}
	  
	
		if(basePath==null)
		{
			basePath = "/v2/"; 
		}
		RestAssured.basePath = basePath;
		
		 
		 if(baseHost==null)
	 	{
		 	baseHost = "https://petstore.swagger.io";     		
	 	}
	 
	     RestAssured.baseURI = baseHost;
	}
}