/**
 * @author Venkat Subramaniam
 * DuraSoft, Inc.
 * http://www.durasoftcorp.com/download
 */

package lib;

public class MyClass
{
	public void f1(int a)
	{
		System.out.println("Good method f1(" + a + ")"); 
	}

	public int f2(int a)
	{
		System.out.println("Not good method f2(" + a + ")"); 

		if (a == 1) System.out.println("value of input is 1... code misbehaves");
		
		return a;
	}
}