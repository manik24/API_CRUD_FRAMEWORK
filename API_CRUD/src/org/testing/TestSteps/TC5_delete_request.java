
package org.testing.TestSteps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testing.TestMethod.HTTPMethods;
import org.testing.Utilities.LoadJsonFile;
import org.testing.Utilities.loadpropertiesFile;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;


public class TC5_delete_request {
	
	@Test
	public static void TC5_delete_request() throws IOException, InterruptedException
	{
		String path_parameter= TC1_post_request.data_extracted;
		
		Properties pr = loadpropertiesFile.loadpropertiesfile("../FRAMEWORK_API_8PM/src/org/testing/resources/URI.properties");
		String pr_data = pr.getProperty("Uri_key");
		HTTPMethods obj1 = new HTTPMethods(pr_data); 
		Thread.sleep(2000);
		Response res = obj1.delete_request(path_parameter);
		
		System.out.println("Response for the delete request is "+ res.statusCode());
		
	}

}
