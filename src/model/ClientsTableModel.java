package model;

import javax.swing.table.AbstractTableModel;

import persistence.ClientsDao;

public class ClientsTableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	private String[] columns = {"ID"};
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
		}
		return null;
	}

}
