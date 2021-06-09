package org.testing.validation;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import com.jayway.restassured.response.Response;

public class ResponseValidation {

	
	public static void datavalidation(Response res,String expected_data,String data)
	{
		String actual_data=res.jsonPath().getString(data).toString();
		if(actual_data.equals(expected_data))
				{
			System.out.println("The  "+ data +" value is matching the response" );
				}
		else 
			System.out.println("The "+ data +" valye is not matching with the response");
		
	}
	
	
	public static void responseCodValidation(Response res,int expected_data)
	{
		int actual_data=res.getStatusCode();
		if(actual_data==expected_data)
				{
			System.out.println("The  "+ actual_data +" value is matching the response:   "+ expected_data );
				}
		else 
			System.out.println("The "+ actual_data +" valye is not matching with the response:  "+expected_data);
		
	}
}
