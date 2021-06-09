package org.testing.Utilities;

import com.jayway.restassured.response.Response;

public class ParseJsonData {

	public static String getJsondata(Response res,String data)
	{
		
		String data_extracted = res.jsonPath().get(data);
		return data_extracted;
		
	}
}
