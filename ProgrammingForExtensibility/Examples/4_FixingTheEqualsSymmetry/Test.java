import java.awt.Color;

public class Test
{
	public static void main(String[] args)
	{
		ColorPoint p1 = new ColorPoint(1, 2, Color.red);
		Point p2 = new Point(1, 2);
		ColorPoint p3 = new ColorPoint(1, 2, Color.blue);
		
		System.out.println("p1.equals(p2) : " + p1.equals(p2));
		System.out.println("p2.equals(p3) : " + p2.equals(p3));		
		System.out.println("p3.equals(p1) : " + p3.equals(p1));		
	}
}

