package org.testing.ReportsHandling;

import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;

public class Reports {
	
	public static  ExtentReports extent;
	
	@BeforeMethod
	public  static  void reporthandling()
	{   
		 
	     extent = new ExtentReports("../API_CRUD/report.html",false);
	}

}
