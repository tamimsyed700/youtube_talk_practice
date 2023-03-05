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
		 if (!(o instanceof Point)) return false; 
		 // If o a normal Point, color-blind comparison 

		if (!(o instanceof ColorPoint))
			return o.equals(this); 
		
		// o is a ColorPoint; do a full comparison 
		 ColorPoint cp = (ColorPoint) o; 
		 return super.equals(o) && 
					color.equals(cp.color); 
	}  	
}
