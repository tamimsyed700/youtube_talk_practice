/*
 * Author: Venkat Subramaniam (venkats@durasoftcorp.com)
 */

public class Alarm implements MonitoringEntity
{
	private MonitoredEntity theMonitored;
	private int secondsToMonitor;
	private Thread monitoringThread = null;
	
	public synchronized void setMonitoredEntity(MonitoredEntity mObj) { theMonitored = mObj; }
	public synchronized void setMonitoringTime(int seconds) { secondsToMonitor = seconds; }
	public synchronized void startMonitor()
	{
		monitoringThread = new Thread(
			new Runnable()
			{
				public void run()
				{
					try
					{
						Thread.sleep(secondsToMonitor * 1000);
						if (!theMonitored.isOK())
							raiseAlarm();
					}
					catch(Exception e)
					{
						// return if thread interrupted. Other actions may be necessary however... not the focus of problem here.
						return;
					}
				}
			}
			);
		monitoringThread.start();
	}
	
	public synchronized void stopMonitor()
	{
		if (monitoringThread != null) monitoringThread.interrupt();
	}
	
	public void raiseAlarm()
	{
		// Code to play alarm goes here.
		javax.swing.JOptionPane.showMessageDialog(null, "Door left open, alarm sounded");
	}
}
