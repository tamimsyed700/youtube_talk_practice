/**
 * @author Venkat Subramaniam
 * Agile Developer, Inc.
 * http://www.AgileDeveloper.com/download.aspx
 */

package com.agiledeveloper;


public aspect MenuEnabling
{	
	public int count = 0;
	
	pointcut pc3(Sample s) : 
			target(s) && call(* *(..))
			&& within(Sample);
	
	before(Sample s) : pc3(s)
	{
		count++;
		System.out.println(count + 
				" Before the exeuction of " + 
					thisJoinPoint);	
	}
	
	after(Sample s) : pc3(s)
	{
		
	}
}
