package model;

import javax.swing.table.AbstractTableModel;

import persistence.ClientsDao;

public class ClientsTableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	private String[] columns = {"ID", "Nome", "CPF", "Email", "Contato", "Endereço", "Observação"};
	private ClientsDao cDao;


	public ClientsTableModel(ClientsDao cDao)
	{
		this.cDao = cDao;
	}

	@Override
	public String getColumnName(int column)
	{
		return columns[column];
	}

	@Override
	public int getColumnCount()
	{
		return this.columns.length;
	}

	@Override
	public int getRowCount()
	{
		if (cDao != null)
		{
			return cDao.getLenght() + 1;
		}
		return 0;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		switch(columnIndex)
		{
		case 0: return cDao.getClient(rowIndex).getId();

		case 1: return cDao.getClient(rowIndex).getName();

		case 2: return cDao.getClient(rowIndex).getCpf();

		case 3: return cDao.getClient(rowIndex).getEmail();

		case 4: return cDao.getClient(rowIndex).getPhone();

		case 5: return cDao.getClient(rowIndex).getAddress().formatToTableModel();

		case 6: return cDao.getClient(rowIndex).getObs();
		}
		return null;
	}

	public void refreshTable()
	{
		this.fireTableDataChanged();
	}

}
