/*
 * Author: Venkat Subramaniam (venkats@durasoftcorp.com)
 */

public class Alarm
{
	public Alarm(final MonitoredEntity theMonitored, final int seconds)
	{
		Thread monitoringThread = new Thread(
			new Runnable()
			{
				public void run()
				{
					try
					{
						Thread.sleep(seconds * 1000);
						if (!theMonitored.isOK())
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

	public void raiseAlarm()
	{
		// Code to play alarm goes here.
		javax.swing.JOptionPane.showMessageDialog(null, "Door left open, alarm sounded");
	}
}
