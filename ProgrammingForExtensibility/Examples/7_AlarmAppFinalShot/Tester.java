/*
 * Author: Venkat Subramaniam (venkats@durasoftcorp.com)
*/

import javax.swing.*;
import java.awt.event.*;

public class Tester extends JFrame
{
	private JButton doorButton;
	private Door theDoor;
		
	public void frameInit()
	{
		super.frameInit();
		
		theDoor = new Door();
		doorButton = new JButton("Open Door");
		
		getContentPane().add(doorButton);
		
		doorButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent actionEvent)
					{
						if (theDoor.isClosed())
						{
							theDoor.open();
							doorButton.setText("Close Door");
						}
						else
						{
							theDoor.close();
							doorButton.setText("Open Door");
						}
					}
				}
				);
	}
	
	public static void printUsageAndExit(String msg)
	{
				javax.swing.JOptionPane.showMessageDialog(null, msg);
				System.exit(0);
	}
	
	public static void main(String[] args)
	{
		// First we will make sure a good MonitoringEntity is provided.
		
		String theMonitoringEntityClassName = System.getProperty("TheMonitoringEntity");
		
		if (theMonitoringEntityClassName == null) printUsageAndExit("Please use the run.cmd script provided: Monitoring class name not provided");
		
		try
		{
			Class.forName(theMonitoringEntityClassName);
		}
		catch(Exception e)
		{
			System.out.println(e);
			printUsageAndExit(e.toString());
		}
		
		final JFrame frame = new Tester();
		
		frame.setBounds(100, 100, 500, 400);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		frame.addWindowListener(
			new WindowAdapter()
			{
				public void windowClosed(WindowEvent e)
				{
					System.exit(0);
				}
			}
			);
	}
}
