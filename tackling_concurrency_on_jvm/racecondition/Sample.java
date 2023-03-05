public class Sample
{
    private static int count;

    public Sample()
    {
        count++;
        // Above code is risky, you can't run it to prove its correctness.
        // Not threadsafe. It is equivalent to two separate operations,
        // first fetching the value of count and then setting a new incremented value.
    }

    public static int getCount()
    {
        return count;
    }

    public static void createObjects(int count) throws InterruptedException
    {
        for (int i = 0; i < count; i++)
        {
            new Thread(new Runnable()
            {
                public void run()
                {
                    new Sample();
                }
            }).start();
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        createObjects(1000);
        Thread.sleep(1000); // Use join otherwise.
        System.out.println(Sample.getCount());
    }
}
