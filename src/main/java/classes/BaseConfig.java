package classes;

import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
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
			Reporter.log("Prosao 1 ", true);
			RestAssured.port = Integer.valueOf(8080);
	    }
		else
	    {
			Reporter.log("Else 1 ", true);	
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