/**
 * @author Venkat Subramaniam
 * Agile Developer, Inc.
 * http://www.AgileDeveloper.com/download.aspx
 */

package com.agiledeveloper;

import java.io.*;

public aspect ErrorLoggingAspect
{
	private String logFile = "errors.log";
	
	after() throwing(Exception e) : call(* *(..))
	{
		try
		{
			PrintWriter writer = new PrintWriter(
									new FileWriter(logFile, true));
			
			writer.println("Error occured at " +
					new java.util.Date().toString());
			writer.println("	- " + e);
			writer.println("	- " + thisJoinPoint);
			e.printStackTrace(writer);
			writer.println("==============================================");
			writer.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
