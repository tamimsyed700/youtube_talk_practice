public abstract class Animal
{
	public void eat()
	{
		System.out.println("Animal eating");
	}

	abstract public void makeNoise();

	abstract public boolean play(Animal anotherAnimal);
}