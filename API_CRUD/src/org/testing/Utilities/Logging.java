package org.testing.Utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Logging {

	public static void takeLogs(String classname,String logmsg)
	{
		DOMConfigurator.configure("../API_CRUD/layout.xml");
		Logger l= Logger.getLogger(classname);
		l.info(logmsg);
	}
}
