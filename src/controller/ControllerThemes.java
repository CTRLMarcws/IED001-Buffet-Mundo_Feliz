package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Theme;
import persistence.ThemeDao;
import view.FPrincipal;
import view.PQuery;
public class ControllerThemes implements ActionListener
{
	private ThemeDao tDao;
	private JTextField tfName;
	private JFormattedTextField ftfValue;
	private JTextArea taDesc;

	public ControllerThemes(JTextField tfName, JTextArea taDesc, JFormattedTextField ftfValue)
	{
		this.tfName = tfName;
		this.ftfValue = ftfValue;
		this.taDesc = taDesc;
		tDao = new ThemeDao();
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();

		if (cmd.equals("Pesquisar"))
		{
			search();
		}
		if (cmd.equals("Salvar"))
		{
			register();
		}
		if (cmd.equals("Excluir"))
		{
			remove();
		}
		if (cmd.equals("Ver Todos"))
		{
			FPrincipal.atualizarFrame(new PQuery());
		}
	}

	private void search()
	{
		String name = tfName.getText();
		String returnMsg;

		if(!tfName.getText().isEmpty())
		{
			if (!tDao.emptyList())
			{
				Theme theme = tDao.findTheme(name);			
				if(theme != null)
				{
					tfName.setText(theme.getName());
					taDesc.setText(theme.getDesc());
					String value = Double.toString(theme.getValue());
					ftfValue.setText(value.replace('.', ','));
				}
				else
				{
					returnMsg = "Tema n�o encontrado.";
					notification(returnMsg, "erro");
				}
			}
			else
			{
				returnMsg = "A lista est� vazia.";
				notification(returnMsg, "erro");
			}
		}
		else
		{
			returnMsg = "O campo nome � obrigat�rio para esta opera��o.";
			notification(returnMsg, "erro");
		}
	}

	private void remove()
	{
		String name = tfName.getText();
		String returnMsg;

		if(!tfName.getText().isEmpty())
		{
			if (!tDao.emptyList())
			{
				Theme theme = tDao.findTheme(name);
				if(theme != null)
				{
					returnMsg = tDao.removeTheme(theme.getId());					
				}
				else
				{
					returnMsg = "Tema n�o encontrado.";
				}
			}
			else
			{
				returnMsg = "A lista est� vazia.";
				clearFields();
			}

		}
		else
		{
			returnMsg = "O campo nome � obrigat�rio para esta opera��o.";
		}

		notification(returnMsg, "removido");
	}

	private void register()
	{
		int id = 1;
		if(validateFields())
		{
			if (!tDao.emptyList())
			{
				id = tDao.getLastTheme().getId() + 1;						
			}

			Theme theme = new Theme(id, tfName.getText(), taDesc.getText(), Double.parseDouble(ftfValue.getText().replace(',', '.')));

			String returnMsg = tDao.addLast(theme);

			notification(returnMsg, "adicionado");
			clearFields();
		}
	}

	private void notification(String returnMsg, String contem)
	{
		if (returnMsg.contains(contem))
		{
			JOptionPane.showMessageDialog(null, returnMsg, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, returnMsg, "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void clearFields()
	{
		tfName.setText("");
		taDesc.setText("");
		ftfValue.setText("");
	}

	private boolean validateFields()
	{
		if(!tfName.getText().isEmpty())
		{
			if(!taDesc.getText().isEmpty())
			{
				if(!ftfValue.getText().isEmpty())
				{
					return true;
				}
			}
		}
		String returnMsg = "Existem campos vazios.";
		notification(returnMsg, "erro");
		return false;
	}

}