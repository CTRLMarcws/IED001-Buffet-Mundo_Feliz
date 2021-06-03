package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Theme;
import persistence.ThemesDao;
import view.FMain;
import view.PQuery;
public class ThemesController implements ActionListener
{
	private ThemesDao tDao;
	private JTextField tfName;
	private JFormattedTextField ftfValue;
	private JTextArea taDesc;
	private FileController file;

	public ThemesController(JTextField tfName, JTextArea taDesc, JFormattedTextField ftfValue)
	{
		this.tfName = tfName;
		this.ftfValue = ftfValue;
		this.taDesc = taDesc;
		
		
		tDao = new ThemesDao();
		
		FileController file = new FileController();
		try
		{
			if(file.readFile("themes.csv"))
			{
				tDao = file.readThemes(tDao);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
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
			try {
				register();
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Excluir"))
		{
			remove();
		}
		if (cmd.equals("Ver Todos"))
		{
			FMain.refreshFrame(new PQuery("Temas"));
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
					returnMsg = "Tema não encontrado.";
					notification(returnMsg, "erro");
				}
			}
			else
			{
				returnMsg = "A lista está vazia.";
				notification(returnMsg, "erro");
			}
		}
		else
		{
			returnMsg = "O campo nome é obrigatório para esta operação.";
			notification(returnMsg, "erro");
		}
	}

	private void remove()
	{
		String name = tfName.getText();
		String returnMsg = "";

		if(!tfName.getText().isEmpty())
		{
			if (!tDao.emptyList())
			{
				Theme theme = tDao.findTheme(name);
				if(theme != null)
				{
					try
					{
						returnMsg = tDao.removeById(theme.getId());
						file = new FileController();
						file.deleteTheme(tDao, theme.getId());
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
					
					clearFields();
				}
				else
				{
					returnMsg = "Tema não encontrado.";
				}
			}
			else
			{
				returnMsg = "A lista está vazia.";
			}

		}
		else
		{
			returnMsg = "O campo nome é obrigatório para esta operação.";
		}

		notification(returnMsg, "removido");
	}

	private void register() throws IOException
	{
		int id = 1;
		if(validateFields())
		{
			if (!tDao.emptyList())
			{
				id = tDao.getLastTheme().getId() + 1;						
			}

			Theme theme = new Theme(id, tfName.getText(), taDesc.getText(), Double.parseDouble(ftfValue.getText().replace(',', '.')));

			String returnMsg = tDao.addLast(theme, 1);

			notification(returnMsg, "adicionado");
			clearFields();
		}
	}

	private void notification(String returnMsg, String contains)
	{
		if (returnMsg.contains(contains))
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
		tfName.setText(null);
		taDesc.setText(null);
		ftfValue.setText(null);
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