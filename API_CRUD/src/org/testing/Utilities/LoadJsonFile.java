package org.testing.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.json.JSONTokener;



public class LoadJsonFile {
	
	public  static String loadjsonfile(String path) throws FileNotFoundException
	{
		File f =new File(path);
		FileInputStream fi = new FileInputStream(f);
		
		JSONTokener jt = new JSONTokener(fi);
		JSONObject data = new JSONObject(jt); 
		
		return data.toString();
		
	}

	 public static void main(String[] args) throws Exception 
	 {
		 loadjsonfile("../FRAMEWORK_API_8PM/src/org/testing/resources/SimpleJson");
	}
	 
}
