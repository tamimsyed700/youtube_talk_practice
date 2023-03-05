public class Alarm
{
	public Alarm(final Door aDoor, final int seconds)
	{
		Thread monitoringThread = new Thread(
			new Runnable()
			{
				public void run()
				{
					try
					{
						Thread.sleep(seconds * 1000);
						if (!aDoor.isClosed())
								raiseAlarm();
					}
					catch(Exception e)
					{
						// return if thread interrupted. Other actions may be necessary however... not the focus of problem here.
					}
				}
			}
			);
		monitoringThread.start();
	}
}
