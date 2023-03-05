/*
 * Author: Venkat Subramaniam (venkats@durasoftcorp.com)
 */

public class VisualAlarm extends Alarm // of course implements MonitoringEntity
	// Incidentally this implementation is using the Alarm
{
	public void raiseAlarm()
	{
		// Code to play alarm goes here.
		javax.swing.JOptionPane.showMessageDialog(null, "Door left open, Visual alarm sounding");
	}
}
