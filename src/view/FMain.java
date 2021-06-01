package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.FileController;

public class FMain
{
	static JFrame frame;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					generateFrame();
					FileController.initializeFiles();
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}


	private static void generateFrame()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		refreshFrame(new PMainMenu());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	public static void refreshFrame(JPanel panel)
	{		
		frame.setContentPane(panel);
		frame.repaint();
		frame.pack();
		frame.revalidate();
	}

}