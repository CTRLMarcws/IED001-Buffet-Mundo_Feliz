package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.FileController;
import controller.QueryController;
import model.ClientsTableModel;
import model.RentsTableModel;
import model.ThemesTableModel;
import persistence.ClientsDao;
import persistence.RentsDao;
import persistence.ThemesDao;

public class PQuery extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField tfSearch;
	private JButton btnEdit, btnSearch, btnRemove;
	private JLabel lblHeading;
	private JComboBox<String> cbOptions;
	private ThemesDao tDao;
	private ClientsDao cDao;
	private RentsDao rDao;

	public PQuery(String headingType)
	{
		initComp(headingType);
		initList(headingType);
		FMain.frame.revalidate();
	}

	private void initList(String headingType)
	{
		FileController file = new FileController();
		
		switch(headingType)
		{
		case "Temas":
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
			
		case "Clientes":
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
			
		case "Alugueis":
			rDao = new RentsDao();
			
			try
			{
				rDao = file.readRents(rDao);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			RentsTableModel rentModel = new RentsTableModel(rDao);
			table.setModel(rentModel);
			break;
		}
	}

	public Dimension getPreferredSize()
	{
		return new Dimension(690, 430);
	}

	private void initComp(String headingType)
	{
		setBounds(100, 100, 690, 430);
		setLayout(null);


		tfSearch = new JTextField();
		tfSearch.setBounds(113, 48, 350, 20);
		add(tfSearch);
		tfSearch.setColumns(10);

		btnSearch = new JButton("Pesquisar");
		btnSearch.setBounds(470, 47, 100, 23);
		add(btnSearch);

		btnEdit = new JButton("Editar");
		btnEdit.setBounds(580, 47, 100, 23);
		add(btnEdit);
		
		btnRemove = new JButton("Excluir");
		btnRemove.setBounds(0,0,0,0);
		add(btnRemove);
		System.out.println(headingType);
		lblHeading = new JLabel("Pesquisa de " + headingType);
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblHeading.setBounds(10, 11, 670, 23);
		add(lblHeading);

		String [] arraySearch = {"Nome", "ID"};
		cbOptions = new JComboBox<>(arraySearch);
		cbOptions.setBounds(10, 47, 93, 22);
		add(cbOptions);

		JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FMain.refreshFrame(new PMainMenu());
			}
		});
		btnBack.setBounds(10, 14, 41, 23);
		add(btnBack);


		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 81, 670, 338);
		add(scrollPane);
		
		QueryController qCtrl = new QueryController(btnSearch, btnEdit, btnRemove);
		
		btnSearch.addActionListener(qCtrl);
		btnEdit.addActionListener(qCtrl);
		btnRemove.addActionListener(qCtrl);
	}
}
