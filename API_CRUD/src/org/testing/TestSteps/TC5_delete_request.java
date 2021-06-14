
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


public class TC5_delete_request extends Reports
{
	
	@Test
	public static void TC5_delete_request() throws IOException, InterruptedException
	{
		ExtentTest test = extent.startTest("Test Case5");
		
		String path_parameter= TC1_post_request.data_extracted;
		
		Properties pr = loadpropertiesFile.loadpropertiesfile("../API_CRUD/src/org/testing/resources/URI.properties");
		String pr_data = pr.getProperty("Uri_key");
		HTTPMethods obj1 = new HTTPMethods(pr_data); 
		Thread.sleep(2000);
		Response res = obj1.delete_request(path_parameter);
		
		 if(res.statusCode()==200)
		 {
			 test.log(LogStatus.PASS,"correct status code is coming");
		 }
		 else 
		 {
			 test.log(LogStatus.FAIL,"wrong status code is coming");
		 }
		 
		System.out.println("Response for the delete request is "+ res.statusCode());
		
		extent.endTest(test);
		extent.flush();
		
	}

}
