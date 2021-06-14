package org.testing.Utilities;

import org.json.JSONObject;
import org.json.XML;

public class XmltoJson {

	
	public static String XmltoJson(String xml)
	{
		JSONObject js = XML.toJSONObject(xml);
		return js.toString();
		
	}
}
