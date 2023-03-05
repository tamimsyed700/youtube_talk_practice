import java.awt.Color;

public class ColorPoint extends Point
{
	private Color color;
	
	public ColorPoint(int px, int py, Color clr)
	{
		super(px, py);
		color = clr;
	}
	
	public boolean equals(Object o)
	{
		if (!(o instanceof ColorPoint))
			return false;
		ColorPoint cp = (ColorPoint) o;
		return super.equals(o) && color.equals(cp.color);
	}
}

