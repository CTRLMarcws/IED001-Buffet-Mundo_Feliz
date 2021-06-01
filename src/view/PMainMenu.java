package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.FileController;
import controller.MainMenuController;
import model.MainMenuTableModel;
import model.RentsTableModel;
import persistence.RentsDao;

public class PMainMenu extends JPanel
{
	private JLabel lblHeading, lblDate, lblNextRentals;
	private JButton btnForms, btnQuery;
	private JTable table;
	private JComboBox<String> cbOptions;
	private RentsDao rDao;

	private static final long serialVersionUID = 1L;

	public Dimension getPreferredSize()
	{
		return new Dimension(460, 300);
	}

	public PMainMenu() 
	{
		setLayout(null);
		initComp();

		FileController file = new FileController();
		rDao = new RentsDao();

		try
		{
			rDao = file.readRents(rDao);
		}
		catch (Exception e)
		{	
			e.printStackTrace();
		}
		if (!rDao.emptyList())
		{
			RentsTableModel rentModel = new RentsTableModel(rDao);
			table.setModel(rentModel);			
		}
		else
		{
			//não há agendamentos para demonstrar
		}

		MainMenuController ctrPrinc = new MainMenuController(cbOptions, btnForms, btnQuery);
		btnForms.addActionListener(ctrPrinc);
		btnQuery.addActionListener(ctrPrinc);

	}

	private void initComp()
	{
		lblHeading = new JLabel("Bem-vinda de volta, Rafaela!");
		lblHeading.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setBounds(10, 11, 430, 45);
		add(lblHeading);

		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy'.'");  
		String strDate = dateFormat.format(date);

		lblDate = new JLabel(strDate);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDate.setBounds(10, 48, 430, 26);
		add(lblDate);

		btnForms = new JButton("Cadastrar");
		btnForms.setBounds(175, 113, 100, 23);
		add(btnForms);

		btnQuery = new JButton("Consultar");
		btnQuery.setBounds(320, 113, 100, 23);
		add(btnQuery);

		lblNextRentals = new JLabel("Pr\u00F3ximos agendamentos:");
		lblNextRentals.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNextRentals.setBounds(10, 160, 212, 33);
		add(lblNextRentals);

		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFillsViewportHeight(true);
		MainMenuTableModel tableModel = new MainMenuTableModel(rDao); //rDao
		table.setModel(tableModel);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 196, 430, 93);
		add(scrollPane);

		String [] arrayType = {"Temas", "Clientes", "Alugueis"};
		cbOptions = new JComboBox<>(arrayType);
		cbOptions.setBounds(30, 113, 100, 22);
		add(cbOptions);	
	}
}
