package org.testing.TestSteps;

import java.io.IOException;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testing.TestMethod.HTTPMethods;
import org.testing.Utilities.LoadJsonFile;
import org.testing.Utilities.loadpropertiesFile;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TC3_getall_request 
{
		@Test
	public static void TC3_getall_request() throws IOException
	{
		
		Properties pr = loadpropertiesFile.loadpropertiesfile("../FRAMEWORK_API_8PM/src/org/testing/resources/URI.properties");
		String pr_data = pr.getProperty("Uri_key");
		HTTPMethods obj1 = new HTTPMethods(pr_data); 
		Response res = obj1.getAll_request();
		
		System.out.println("reponse all"+ res.asString());
		JSONArray ar = new JSONArray(res.asString());
		int len=ar.length();
		System.out.println("array length "+len);
		for(int i=1;i<=len-1;i++)
		{
		      String data_extracted=ar.getJSONObject(i).getString("email").toString();
		      System.out.println("The value extracted for the field id is "+data_extracted.toString());
              System.out.println("===================================================");
          	JSONObject obj = ar.getJSONObject(i);
          	String data_extracted_1=obj.getString("id").toString();
        	System.out.println("The value extracted for the field id is "+data_extracted_1);
         
		}		
	}
}
