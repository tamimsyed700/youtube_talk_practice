public class Point
{
	private final int x;
	private final int y;
	public Point(int px, int py)
	{
		x = px;
		y = py;
	}
	public boolean equals(Object o)
	{
		if (!(o instanceof Point))
			return false;
		Point p = (Point) o;
		return p.x == x && p.y == y;
	}
}

