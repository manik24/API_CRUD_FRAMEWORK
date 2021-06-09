package org.testing.TestSteps;


import java.io.IOException;
import java.util.Properties;

import org.testing.TestMethod.HTTPMethods;
import org.testing.Utilities.LoadJsonFile;
import org.testing.Utilities.Logging;
import org.testing.Utilities.ParseJsonData;
import org.testing.Utilities.loadpropertiesFile;
import org.testng.annotations.*;

import com.jayway.restassured.response.Response;


public class TC1_post_request 
{
  public static String data_extracted;
  		
  	@Test
	public static void TC1_post_request() throws IOException 
	{
	
		Properties pr = loadpropertiesFile.loadpropertiesfile("../FRAMEWORK_API_8PM/src/org/testing/resources/URI.properties");
		String body = LoadJsonFile.loadjsonfile("../API_CRUD/src/org/testing/resources/SimpleJson");
		System.out.println(body.toString());
		String pr_data = pr.getProperty("Uri_key");
		HTTPMethods obj1 = new HTTPMethods(pr_data); 
		Response res = obj1.post_request(body);
		
		System.out.println("Response code :"+ res.statusCode());
		System.out.println("Response code :"+ res.asString());
		Logging.takeLogs("TC1_post_request","\" response data is \""+res.asString());
		
		
		
		
		data_extracted=ParseJsonData.getJsondata(res, "id");
		System.out.println("data extracted from response:  "+ data_extracted);
	}
	
  
  
}
