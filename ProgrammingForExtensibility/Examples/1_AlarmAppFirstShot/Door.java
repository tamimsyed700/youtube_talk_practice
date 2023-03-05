public class Door
{
	private boolean closed = true;

	public void open()
	{
		closed = false;
		// Interface with door API at this point.
		
		Alarm anAlarm = new Alarm(this, 10);
	}
	public void close()
	{
		closed = true;
		// Interface with door API at this point.		
	}
	
	public boolean isClosed() { return closed; }
}
