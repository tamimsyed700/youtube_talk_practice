/**
 * @author Venkat Subramaniam
 * Agile Developer, Inc.
 * http://www.AgileDeveloper.com/download.aspx
 */

package com.agiledeveloper;

public class Test
{
	public static void play1(Base b)
	{
		b.f1();
	}
	
	public static void play2(Derived d)
	{
		d.f1();
	}

	public static void main(String[] args)
	{
		System.out.println("-------------------------");
		play1(new Base());
		System.out.println("-------------------------");
		play1(new Derived());
		System.out.println("-------------------------");
		play2(new Derived());
	}
}

