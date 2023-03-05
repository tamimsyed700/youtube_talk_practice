/**
 * @author Venkat Subramaniam
 * Agile Developer, Inc.
 * http://www.AgileDeveloper.com/download.aspx
 */

package com.agiledeveloper;

public class Test
{
	public static void main(String[] args)
	{
		try
		{
			MyClass1 obj = new MyClass1();
			
			obj.f1(1);
			obj.f2(1);
			obj.f1(0);
		}
		catch (MyException e)
		{
			System.out.println(e);
		}
	}
}
