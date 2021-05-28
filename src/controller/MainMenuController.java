package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import view.FMain;
import view.PQuery;
import view.PThemeForm;

@SuppressWarnings("unused")
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
				//FPrincipal.atualizarFrame(new PCadClientes());
				break;
			case "Alugueis":
				//FPrincipal.atualizarFrame(new PCadAlugueis());
				break;
			}

		}

		if (cmd.equals("Consultar"))
		{
			switch(opt)
			{
			case "Temas":
				QueryController.setKind(0);
				break;

			case "Clientes":
				//consultaTipo(1);
				break;

			case "Alugueis":
				//consultaTipo(2);
				break;
			}

			FMain.refreshFrame(new PQuery());
		}
	}


}
