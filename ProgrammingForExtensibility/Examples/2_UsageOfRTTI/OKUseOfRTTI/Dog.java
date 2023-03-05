public class Dog extends Animal
{
	public void bark()
	{
		System.out.println("bow wow!");
	}

	public void makeNoise() { bark(); }

	public boolean play(Animal anotherAnimal)
	{
		if (anotherAnimal instanceof Dog)
		{
			System.out.println("I like playing with you");
			return true;
		}
		else
		{
			System.out.println("chase");
			return false;
		}
	}
}