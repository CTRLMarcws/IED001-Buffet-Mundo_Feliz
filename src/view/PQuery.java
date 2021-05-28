package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.FileController;
import model.ClientsTableModel;
import model.ThemesTableModel;
import persistence.ClientsDao;
import persistence.ThemesDao;

public class PQuery extends JPanel
{

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField tfSearch;
	private JButton btnEdit, btnSearch;
	private JLabel lblHeading;
	private JComboBox cbOptions;
	private ThemesDao tDao;
	private ClientsDao cDao;
	

	public Dimension getPreferredSize()
	{
		return new Dimension(690, 430);
	}

	public PQuery()
	{
		FileController file = new FileController();
		/*
		 * Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException: Cannot invoke "model.Theme.getId()"
		 * because the return value of "persistence.ThemeDao.getTheme(int)" is null
		 * 
		 * at model.TableModel_Themes.getValueAt(TableModel_Themes.java:47)
		 */
/*
 * 		Resposabilidade:
 * 
 * 		1. Iniciar componentes
 * 		2. Iniciar controller
 * 
 * 		Responsabilidades ControllerConsulta:
 * 		Informar o tipo
 * 		criar a tablemodel
 * 		popular a tablemodel
 */
		
		initComp();
		
		int i = 0;

		switch(i)
		{
		case 0:
			tDao = new ThemesDao();
			
			try
			{
				tDao = file.readThemes(tDao);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			ThemesTableModel themesModel = new ThemesTableModel(tDao);
			table.setModel(themesModel);
			break;
			
		case 1:
			cDao = new ClientsDao();
			
			try
			{
				cDao = file.readClients(cDao);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			ClientsTableModel clientModel = new ClientsTableModel(cDao);
			table.setModel(clientModel);
			break;
			
		case 2:
			System.out.println("Em progresso");
			break;
		}
		
	}

	private void initComp()
	{
		String tipo = "Clientes";
		setBounds(100, 100, 690, 430);
		setLayout(null);


		tfSearch = new JTextField();
		tfSearch.setBounds(113, 48, 350, 20);
		add(tfSearch);
		tfSearch.setColumns(10);

		btnSearch = new JButton("Pesquisar");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnSearch.setBounds(470, 47, 100, 23);
		add(btnSearch);

		btnEdit = new JButton("Editar");
		btnEdit.setBounds(580, 47, 100, 23);
		add(btnEdit);

		lblHeading = new JLabel("Pesquisa de " + tipo);
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblHeading.setBounds(10, 11, 670, 23);
		add(lblHeading);

		cbOptions = new JComboBox();
		cbOptions.setModel(new DefaultComboBoxModel(new String[] {"Nome", "ID"}));
		cbOptions.setBounds(10, 47, 93, 22);
		add(cbOptions);

		JButton btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FMain.refreshFrame(new PRegThemes());
			}
		});
		btnVoltar.setBounds(10, 14, 41, 23);
		add(btnVoltar);
		

		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 81, 670, 338);
		add(scrollPane);
	}
}
