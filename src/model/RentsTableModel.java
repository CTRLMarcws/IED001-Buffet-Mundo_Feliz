package model;

import javax.swing.table.AbstractTableModel;

import persistence.RentsDao;

public class RentsTableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	private String[] columns = {"ID", "Cliente", "Tema", "Data", "Hora-Inicio", "Hora-Fim", "Endereço", "Valor"};
	private RentsDao rDao;

	public RentsTableModel(RentsDao rDao)
	{
		this.rDao = rDao; 
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
		if (rDao != null)
		{
			return rDao.getLenght() + 1;
		}
		return 0;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		switch(columnIndex)
		{
		case 0: return rDao.getRent(rowIndex).getId();
		
		case 1: return rDao.getRent(rowIndex).getClient();
		
		case 2: return rDao.getRent(rowIndex).getTheme();
		
		case 3: return rDao.getRent(rowIndex).getDate();
		
		case 4: return rDao.getRent(rowIndex).getStartTime();
		
		case 5: return rDao.getRent(rowIndex).getEndTime();
		
		case 6: return rDao.getRent(rowIndex).getAddress();
		
		case 7: return rDao.getRent(rowIndex).getValue();
		}
		return null;
	}
	
	public void refreshTable()
	{
		this.fireTableDataChanged();
	}

}
