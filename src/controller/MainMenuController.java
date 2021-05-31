package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import view.FMain;
import view.PClientForm;
import view.PQuery;
import view.PThemeForm;

@SuppressWarnings({"unused", "rawtypes"})
public class MainMenuController implements ActionListener
{
	private JComboBox cbOptions;
	private JButton btnForms, btnQuery;

	public MainMenuController(JComboBox cbOptions, JButton btnForms, JButton btnQuery)
	{
		this.btnForms = btnForms;
		this.btnQuery = btnQuery;
		this.cbOptions = cbOptions;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		String opt = String.valueOf(cbOptions.getSelectedItem());

		if (cmd.equals("Cadastrar"))
		{
			switch(opt)
			{
			case "Temas":
				FMain.refreshFrame(new PThemeForm());
				break;
			case "Clientes":
				FMain.refreshFrame(new PClientForm());				
				break;
			case "Alugueis":
//				FMain.refreshFrame(new PRentalForm());				
				break;
			}

		}

		if (cmd.equals("Consultar"))
		{
			switch(opt)
			{
			case "Temas":
				FMain.refreshFrame(new PQuery("Temas"));
				break;

			case "Clientes":
				FMain.refreshFrame(new PQuery("Clientes"));
				break;

			case "Alugueis":
				break;
			}

//			FMain.refreshFrame(new PQuery());
		}
	}


}
