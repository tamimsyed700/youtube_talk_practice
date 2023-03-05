/**
 * @author Venkat Subramaniam
 * Agile Developer, Inc.
 * http://www.AgileDeveloper.com/download.aspx
 */

package com.agiledeveloper;

import javax.swing.*;
import java.awt.event.*;

public class Sample extends JFrame
{
	public Sample()
	{
		super("What does AspectJ do?");
	}

	public void frameInit()
	{
		super.frameInit();

		JMenuBar menuBar = new JMenuBar();		
		setJMenuBar(menuBar);

		JMenu viewMenu = new JMenu("View");
		menuBar.add(viewMenu);

		JMenuItem searchByName = new JMenuItem("Search  by Name");
		JMenuItem searchBySSN = new JMenuItem("Search  by SSN");

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
		Sample frm = new Sample();
		frm.setBounds(100, 100, 400, 200); 
		frm.setVisible(true);

	}
}