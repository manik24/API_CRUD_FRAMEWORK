package org.testing.Utilities;

import org.json.JSONObject;
import org.json.XML;

public class JsontoXml {

	
	public static String JsontoXml(String json)
	{
		JSONObject js = new JSONObject(json) ;
		String xml = XML.toString(json);
		return xml;
	}
}
