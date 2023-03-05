import java.awt.Color;

public class Test
{
	public static void main(String[] args)
	{
		Point p = new Point(1, 2);
		ColorPoint cp = new ColorPoint(1, 2, Color.red);
		
		System.out.println("p.equals(cp) : " + p.equals(cp));
		System.out.println("cp.equals(p) : " + cp.equals(p));		
	}
}

