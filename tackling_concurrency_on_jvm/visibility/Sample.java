public class Sample
{
    private static boolean done;

    public static void main(String[] args) throws InterruptedException
    {
        new Thread(new Runnable()
        {
            public void run()
            {
                int val = 0;
                while(!done) { val += 1; }
                System.out.println("done!");
            }
        }).start();

        Thread.sleep(2000);
        done = true;
    }
}

// Run this first as java Sample and then as java -server Sample
// Now replace 
// private static boolean done;
// with
// private volatile static boolean done;
// and try again both java Sample and java -server Sample
