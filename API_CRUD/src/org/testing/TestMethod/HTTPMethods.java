package org.testing.TestMethod;

import static com.jayway.restassured.RestAssured.given;

import java.util.Properties;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class HTTPMethods {

	public static String pr;
	
	public HTTPMethods(String pr)
	{
	    this.pr=pr;	
	}
	
	
	public static Response post_request(String data)
	{   
		
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.body(data)
				.when()
				.post(pr);
		
		return res;
		
	}
	
	public static Response get_request(String parameter)
	{   
		
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.when()
				.get(pr+"/"+parameter);
		
		return res;
		
	}
	
	public static Response getAll_request()
	{   
		
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.when()
				.get(pr);
		
		return res;
		
	}
	
	public  Response PutMethod(String body_data,String Path_parameter)
	{

		

		String uri=pr+"/"+Path_parameter;
				
		Response res=
		 given()
		.contentType(ContentType.JSON)
		.body(body_data)
		.when()
		.put(uri);
		
		return res;
		
		
	}
	
	public static Response delete_request(String parameter)
	{   
		
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.when()
				.delete(pr+"/"+parameter);
		
		return res;
		
	}
}
