public class Sample
{
    private static AtomicLong count = new AtomicLong();

    public Sample()
    {
        count.incrementAndGet();
    }

    public static int getCount()
    {
        return count.intValue();
    }

//...
