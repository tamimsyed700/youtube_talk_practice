/**
 * @author Venkat Subramaniam
 * Agile Developer, Inc.
 * http://www.AgileDeveloper.com/download.aspx
 */

package com.agiledeveloper;

public aspect MyAspect
{
	pointcut callToF1() : call(void Base.f1());
	
	before() : callToF1()
	{
		System.out.println("before callToF1: " + thisJoinPoint);
	}
	after() : callToF1()
	{
		System.out.println("after callToF1: " + thisJoinPoint);
	}


	pointcut executionOfF1() : execution(void Base.f1());
	
	before() : executionOfF1()
	{
		System.out.println("before executionOfF1: " + thisJoinPoint);
	}

	after() : executionOfF1()
	{
		System.out.println("after executionOfF1: " + thisJoinPoint);
	}
}
