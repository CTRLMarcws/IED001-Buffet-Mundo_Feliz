package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.ClientsTableModel;
import model.ThemesTableModel;
import persistence.ClientsDao;
import persistence.ThemesDao;
import view.FMain;
import view.PQuery;

@SuppressWarnings({"unused","rawtypes"})
public class QueryController implements ActionListener
{
	private JTextField tfSearch;
	private JButton btnEdit, btnSearch, btnRemove;
	private JTable table;
	private JComboBox cbOptions; //fazer o modelo do cb
	private ThemesDao tDao;
	private ClientsDao cDao;
	//private RentsDao rDao;

	public QueryController(JButton btnSearch, JButton btnEdit, JButton btnRemove)
	{
		this.btnSearch = btnSearch;
		this.btnEdit = btnEdit;
		this.btnRemove = btnRemove;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		String opt = String.valueOf(cbOptions.getSelectedItem());

		if(cmd.equals("Pesquisar"))
		{

		}
		if(cmd.equals("Editar"))
		{

		}
		if(cmd.equals("Excluir"))
		{

		}
	}


}
