public class Sample
{
    private static int count;

    private synchronized void setCount(int newValue)
    {
        count = newValue;
    }

    public Sample()
    {
        setCount(getCount()); // Is This Safe?
        // Java 6 can apply Lock Coarsening to combine the two locks
        // Without that*, tough luck! You'd have to synchronize around
        // the two calls.
        // * Lock Coarsening does not happen always, however.

    }

    public synchronized static int getCount()
    {
        return count;
    }
//...
