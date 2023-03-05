/**
 * @author Venkat Subramaniam
 * Agile Developer, Inc.
 * http://www.AgileDeveloper.com/download.aspx
 */

package com.agiledeveloper;

import lib.MyClass;

public aspect BypassAspect
{
	pointcut bypass(MyClass ref, int arg) : call(int MyClass.f2(int)) &&
				target(ref) && args(arg);

	// Try compiling and running by commenting out this around advice.
	// Then try again with uncommented around advice				
	int around(MyClass ref, int arg) : bypass(ref, arg)
	{
		if (arg != 1) 
			return proceed(ref, arg);
		else
			System.out.println("bypassed call to f2 at " +
				thisEnclosingJoinPointStaticPart.getSourceLocation());
		
		return 10;
	}	
}
