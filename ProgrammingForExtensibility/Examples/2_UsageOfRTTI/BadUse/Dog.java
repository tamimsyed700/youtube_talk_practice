public class Dog extends Animal
{
	public void bark()
	{
		System.out.println("bow wow!");
	}
	public void makeNoise()
	{
		bark();
	}
	public boolean play(Animal another)
	{
		boolean result = false;
		
		if (another instanceof Dog)
			result = true;
			
		return result;
	}	
}

