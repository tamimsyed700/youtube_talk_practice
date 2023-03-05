public class Cat extends Animal
{
	public void meow()
	{
		System.out.println("meow!");
	}

	public void makeNoise() { meow(); }

	public boolean play(Animal anotherAnimal)
	{
		System.out.println("Go away");
		return false;
	}
}