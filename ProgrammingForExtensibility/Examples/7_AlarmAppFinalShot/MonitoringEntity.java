/*
 * Author: Venkat Subramaniam (venkats@durasoftcorp.com)
 */


public interface MonitoringEntity
{
	public void setMonitoredEntity(MonitoredEntity mObj);
	public void setMonitoringTime(int seconds);
	public void startMonitor();
	public void stopMonitor();
}
