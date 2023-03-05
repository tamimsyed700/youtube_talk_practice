/**
 * @author Venkat Subramaniam
 * Agile Developer, Inc.
 * http://www.AgileDeveloper.com/download.aspx
 */

package com.agiledeveloper;

public class Derived extends Base
{
	public void f1()
	{
		super.f1();
		System.out.println("Derived.f1");
	}
}
