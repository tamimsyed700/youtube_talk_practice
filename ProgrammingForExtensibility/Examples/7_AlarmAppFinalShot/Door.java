/*
 * Author: Venkat Subramaniam (venkats@durasoftcorp.com)
*/


public class Door implements MonitoredEntity
{
	private boolean closed = true;
	
	public void open()
	{
		closed = false;
		// Interface with door API at this point.
	
		try
		{
			Class theMonitoredEntityClass = Class.forName(System.getProperty("TheMonitoringEntity"));
			MonitoringEntity monitor = (MonitoringEntity) theMonitoredEntityClass.newInstance();
			monitor.setMonitoredEntity(this);
			monitor.setMonitoringTime(10);
			monitor.startMonitor();
		}
		catch(Exception e)
		{
			// Handle this one as appropriate
			System.out.println(e);
		}
	}
	public void close()
	{
		closed = true;
		// Interface with door API at this point.		
	}
	
	public boolean isClosed() { return closed; }
	
	public boolean isOK() { return isClosed(); }
}
