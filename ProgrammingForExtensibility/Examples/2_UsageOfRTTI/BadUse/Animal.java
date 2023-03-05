abstract public class Animal
{
	public void eat()
	{
		System.out.println("Animal eating");
	}
	public abstract void makeNoise();
	public boolean play(Animal another)
	{
		return false;
	}
}
