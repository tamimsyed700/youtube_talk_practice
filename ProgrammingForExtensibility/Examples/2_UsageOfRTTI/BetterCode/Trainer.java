public class Trainer
{
	public void train(Animal anAnimal)
	{
		anAnimal.eat();

		anAnimal.makeNoise();
		// This code is closed against addition of new types of animals.
		//However, it is only closed for that extension. 
		//What if training involves some thing else, like say rolling over?
		// As is this is not covered. You may plan for these as well.
	}
}