import javax.swing.*;
import java.awt.event.*;

public class Sample extends JFrame
{
	public Sample()
	{
		super("Sample App");
	}

	public void frameInit()
	{
		super.frameInit();

		JMenuBar menuBar = new JMenuBar();		
		setJMenuBar(menuBar);

		JMenu viewMenu = new JMenu("View");
		menuBar.add(viewMenu);

		JMenuItem searchByName = new JMenuItem("Search by Name");
		JMenuItem searchBySSN = new JMenuItem("Search by SSN");

		if (System.getProperty("user.country").equals("US"))
		{
			searchByName.setEnabled(false);
		}
		else
		{
			searchBySSN.setEnabled(false);
		}
		viewMenu.add(searchByName);
		viewMenu.add(searchBySSN);

		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent we)
				{
					System.exit(0);
				}
			}
		);

		String msg = "Only some menu items should be enabled if country is not US";

		getContentPane().add(new JLabel(msg));
	}

	public static void main(String[] args)
	{
		JFrame frm = new Sample();
		frm.setBounds(100, 100, 400, 200); 
		frm.setVisible(true);
	}
}