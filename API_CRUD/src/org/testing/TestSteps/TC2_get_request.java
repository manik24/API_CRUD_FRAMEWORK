package org.testing.TestSteps;


import java.io.IOException;
import java.util.Properties;

import org.testing.ReportsHandling.Reports;
import org.testing.TestMethod.HTTPMethods;
import org.testing.Utilities.LoadJsonFile;
import org.testing.Utilities.Logging;
import org.testing.Utilities.ParseJsonData;
import org.testing.Utilities.loadpropertiesFile;
import org.testing.validation.ResponseValidation;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TC2_get_request extends Reports

{

	@Test
	public static void TC2_get_request() throws IOException 
	{
		ExtentTest test = extent.startTest("Test Case2");
		
		String req_param= TC1_post_request.data_extracted;
		Properties pr = loadpropertiesFile.loadpropertiesfile("../API_CRUD/src/org/testing/resources/URI.properties");
		String pr_data = pr.getProperty("Uri_key");
		HTTPMethods obj1 = new HTTPMethods(pr_data); 
		Response res = obj1.get_request(req_param);
		
		System.out.println("Response code :"+ res.statusCode());
		System.out.println("Response code :"+ res.asString());
		Logging.takeLogs("TC2_get_request","\" response code is \""+res.statusCode());
		/* validating id in the response */
		
		System.out.println("Data Validation started");
		ResponseValidation.datavalidation(res, "UT322","id");
		System.out.println();
		
		
		/* validating status code in the response */
		
		System.out.println("Status code Validation started");
		ResponseValidation.responseCodValidation(res, 200);
		System.out.println();
		
		 if(res.statusCode()==200)
		 {
			 test.log(LogStatus.PASS, "correct status code is coming ");
		 }
		 else 
		 {
			 test.log(LogStatus.FAIL, "wrong status code is  coming");
		 }
		
		Logging.takeLogs("TC1_post_request","\" response data is \""+res.asString());
		
		extent.endTest(test);
		extent.flush();
		
	}
	
}
