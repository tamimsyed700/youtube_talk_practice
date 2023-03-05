/*
 * Author: Venkat Subramaniam (venkats@durasoftcorp.com)
 */

class AbstractMonitoredEntity
{
	public MonitoringEntity getAlarm()
	{
		Sring nameofclass = System.getProperty(
					"THEWONDERFULALARMCLASSNAME");
		
		Class theClass = Class.forName(nameofclass);
		MonitoringEntity monitoringEntity =
			(MonitoringEntity) theClass.newInstance();
		return monitoringEntity;
	}
}

public class Door extends AbstractMonitoredEntity
{
	private boolean closed = true;
	
	public void open()
	{
		closed = false;
		// Interface with door API at this point.
		
		//Alarm anAlarm = new Alarm(this, 10);
		MonitoringEntity monitor = super.getAlarm();
	}
	public void close()
	{
		closed = true;
		// Interface with door API at this point.		
	}
	
	public boolean isClosed() { return closed; }
	
	public boolean isOK() { return isClosed(); }
}
