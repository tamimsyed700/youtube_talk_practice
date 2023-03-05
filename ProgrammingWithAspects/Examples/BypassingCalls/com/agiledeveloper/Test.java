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
		lib.MyClass obj = new lib.MyClass();
		
		obj.f1(1);
		System.out.println(obj.f2(2));
		System.out.println(obj.f2(1));
	}
}

