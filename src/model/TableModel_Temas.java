package model;

import javax.swing.table.AbstractTableModel;

import persistence.TemaDao;

public class TableModel_Temas extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	private String[] columns = {"Nome", "Descrição", "Valor"};
	private TemaDao tDao;


	public TableModel_Temas(TemaDao tDao) {
		this.tDao = tDao;
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
		if (tDao != null)
		{
			return tDao.tamanho() + 1;
		}
		return 0;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		switch(columnIndex)
		{
		case 0: return tDao.getTema(rowIndex).getNome();

		case 1: return tDao.getTema(rowIndex).getDesc();

		case 2: return tDao.getTema(rowIndex).getValor();
		}
		return null;
	}
	
	public void refreshTable()
	{
		this.fireTableDataChanged();
	}

}
