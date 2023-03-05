/**
 * @author Venkat Subramaniam
 * Agile Developer, Inc.
 * http://www.AgileDeveloper.com/download.aspx
 */

package com.agiledeveloper;

public class MyClass1
{
	public void f1(int a) throws MyException
	{
		if (a <= 0) throw new MyException("f1 value should be greater than zero, you gave " + a);
	}
	
	public void f2(int a) throws MyException
	{
		try
		{
			f1(a - 1);
		}
		catch(Exception e)
		{
			f1(1);
		}
	}
}
