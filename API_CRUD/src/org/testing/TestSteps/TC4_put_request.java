package org.testing.TestSteps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testing.ReportsHandling.Reports;
import org.testing.TestMethod.HTTPMethods;
import org.testing.Utilities.LoadJsonFile;
import org.testing.Utilities.loadpropertiesFile;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TC4_put_request extends Reports 

{
	
	@Test
	public static void TC4_put_request() throws IOException
	{
		ExtentTest test = extent.startTest("Test Case4");
		
		String path_parameter= TC1_post_request.data_extracted;
		
		Properties pr = loadpropertiesFile.loadpropertiesfile("../API_CRUD/src/org/testing/resources/URI.properties");
		String body = LoadJsonFile.loadjsonfile("../API_CRUD/src/org/testing/resources/SimpleJson");
		String body_data_replaced=body.replaceAll("first_name", "name_first");
		String pr_data = pr.getProperty("Uri_key");
		HTTPMethods obj1 = new HTTPMethods(pr_data); 
		Response res = obj1.PutMethod(body_data_replaced,path_parameter);
		
		
		System.out.println("Response for the put request is "+ res.asString());
		
	}

}
