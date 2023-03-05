public class Horse extends Animal
{
	public void neighs()
	{
		System.out.println("heeeheee!");
	}

	public void makeNoise() { neighs(); }

	public boolean play(Animal anotherAnimal)
	{
		return true;
	}
}