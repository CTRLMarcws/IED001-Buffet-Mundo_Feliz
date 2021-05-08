package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FPrincipal
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
					criarFrame();
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}


	private static void criarFrame()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		atualizarFrame(new PMenuPrinc());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void atualizarFrame(JPanel painel)
	{		
		frame.setContentPane(painel);
		frame.repaint();
		frame.pack();
		frame.revalidate();
	}

}