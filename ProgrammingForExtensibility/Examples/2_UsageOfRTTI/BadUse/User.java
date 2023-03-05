public class User
{
	public static void main(String[] args)
	{
		Dog rover = new Dog();
		
		Cat snow = new Cat();

		Trainer trainer = new Trainer();

		trainer.train(rover);
		trainer.train(snow);
	}
}
