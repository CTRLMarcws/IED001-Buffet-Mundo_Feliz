package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.FileController;
import model.ThemesComboBoxModel;
import persistence.ThemesDao;

public class PRentForm extends JPanel
{

	private static final long serialVersionUID = 1L;
	private JTextField tfName, tfStreet, tfDistrict, tfCity, tfAddrCompl, tfStreetNum, tfId;

	private JFormattedTextField ftfDate, ftfStartTime, ftfEndTime, ftfValue, ftfDiscount, ftfTotal;
	private JTextArea taObs;

	private JLabel label, lblHeading;
	private JComboBox<String> cbStates;
	private JComboBox<Object> cbThemes;
	private JButton btnSearch, btnQuery, btnSubmit, btnRemove, btnBack, btnClear;
	private ThemesDao tDao;

	public Dimension getPreferredSize()
	{
		return new Dimension(550, 540);
	}

	public PRentForm()
	{
		initComp();
		initList();
	}

	private void initList()
	{
		tDao = new ThemesDao();
		FileController file = new FileController();

		try
		{
			tDao = file.readThemes(tDao);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if(!tDao.emptyList())
		{
			ThemesComboBoxModel ComboBoxModel = new ThemesComboBoxModel(tDao);
			cbThemes.setModel(ComboBoxModel);
		}
	}

	private void initComp()
	{
		setLayout(null);
		setBounds(100, 100, 550, 540);

		btnSearch = new JButton("Pesquisar");
		btnSearch.setBounds(255, 70, 85, 20);
		add(btnSearch);

		lblHeading = new JLabel("Cadastro de Alugueis");
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblHeading.setBounds(0, 10, 550, 30);
		add(lblHeading);

		label = new JLabel("Temas");
		label.setBounds(360, 50, 50, 20);
		add(label);

		label = new JLabel("Logradouro");
		label.setBounds(20, 210, 100, 20);
		add(label);

		label = new JLabel("Bairro");
		label.setBounds(20, 260, 46, 20);
		add(label);

		label = new JLabel("Cidade");
		label.setBounds(260, 260, 46, 20);
		add(label);

		label = new JLabel("Complemento");
		label.setBounds(420, 210, 110, 20);
		add(label);

		label = new JLabel("Número");
		label.setBounds(330, 210, 63, 20);
		add(label);

		label = new JLabel("Nome");
		label.setBounds(20, 50, 50, 20);
		add(label);

		label = new JLabel("Data");
		label.setBounds(20, 100, 50, 20);
		add(label);

		label = new JLabel("In\u00EDcio");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(150, 100, 60, 20);
		add(label);

		label = new JLabel("T\u00E9rmino");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(230, 100, 60, 20);
		add(label);

		label = new JLabel("Usar endere\u00E7o de cadastro do cliente?");
		label.setBounds(20, 160, 250, 20);
		add(label);

		label = new JLabel("Valor");
		label.setBounds(20, 410, 60, 20);
		add(label);

		label = new JLabel("Descontos");
		label.setBounds(150, 410, 60, 20);
		add(label);

		label = new JLabel("Valor Total");
		label.setBounds(280, 410, 63, 20);
		add(label);

		label = new JLabel("UF");
		label.setBounds(430, 260, 45, 20);
		add(label);

		label = new JLabel("Observa\u00E7\u00F5es");
		label.setBounds(20, 320, 110, 20);
		add(label);

		tfName = new JTextField();
		tfName.setBounds(20, 70, 320, 20);
		add(tfName);
		tfName.setColumns(10);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(20, 340, 510, 60);
		add(scrollPane);

		taObs = new JTextArea();
		scrollPane.setViewportView(taObs);

		tfStreet = new JTextField();
		tfStreet.setBounds(20, 230, 300, 20);
		add(tfStreet);
		tfStreet.setColumns(10);


		tfDistrict = new JTextField();
		tfDistrict.setBounds(20, 280, 230, 20);
		add(tfDistrict);
		tfDistrict.setColumns(10);


		tfCity = new JTextField();
		tfCity.setBounds(260, 280, 160, 20);
		add(tfCity);
		tfCity.setColumns(10);


		tfAddrCompl = new JTextField();
		tfAddrCompl.setBounds(420, 230, 110, 20);
		add(tfAddrCompl);
		tfAddrCompl.setColumns(10);


		tfStreetNum = new JTextField();
		tfStreetNum.setBounds(330, 230, 80, 20);
		add(tfStreetNum);
		tfStreetNum.setColumns(10);

		cbThemes = new JComboBox<Object>();
		cbThemes.setBounds(360, 70, 170, 20);
		add(cbThemes);

		MaskFormatter maskDate = null, maskStartTime = null, maskEndTime = null, maskValue = null, maskDiscount = null, maskTotal = null;

		try
		{
			maskDate = new MaskFormatter("##/##/####");
			maskStartTime = new MaskFormatter("##:##");
			maskEndTime = new MaskFormatter("##:##");
			maskValue = new MaskFormatter("R$ ####,##");
			maskDiscount = new MaskFormatter("R$ ####,##");
			maskTotal = new MaskFormatter("R$ ####,##");

		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

		ftfDate = new JFormattedTextField(maskDate);
		ftfDate.setHorizontalAlignment(SwingConstants.CENTER);
		ftfDate.setBounds(20, 120, 110, 20);
		add(ftfDate);


		ftfStartTime = new JFormattedTextField(maskStartTime);
		ftfStartTime.setHorizontalAlignment(SwingConstants.CENTER);
		ftfStartTime.setBounds(230, 120, 60, 20);
		add(ftfStartTime);



		ftfEndTime = new JFormattedTextField(maskEndTime);
		ftfEndTime.setHorizontalAlignment(SwingConstants.CENTER);
		ftfEndTime.setBounds(150, 120, 60, 20);
		add(ftfEndTime);

		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setBounds(20, 180, 55, 20);
		add(rdbtnSim);

		JRadioButton rdbtnNao = new JRadioButton("Não");
		rdbtnNao.setBounds(80, 180, 55, 20);
		add(rdbtnNao);


		ftfValue = new JFormattedTextField(maskValue);
		ftfValue.setBounds(20, 430, 100, 20);
		add(ftfValue);



		ftfDiscount = new JFormattedTextField(maskDiscount);
		ftfDiscount.setBounds(150, 430, 100, 20);
		add(ftfDiscount);




		ftfTotal = new JFormattedTextField(maskTotal);
		ftfTotal.setBounds(280, 430, 100, 20);
		add(ftfTotal);

		btnSubmit = new JButton("Salvar");
		btnSubmit.setBounds(40, 470, 130, 25);
		add(btnSubmit);

		btnQuery = new JButton("Ver Todos");
		btnQuery.setBounds(380, 470, 130, 25);
		add(btnQuery);

		btnSearch = new JButton("Consultar");
		btnSearch.setBounds(210, 470, 130, 25);
		add(btnSearch);

		btnRemove = new JButton("Excluir");
		btnRemove.setBounds(125, 505, 130, 25);
		add(btnRemove);

		btnClear = new JButton("Limpar");
		btnClear.setBounds(295, 505, 130, 25);
		add(btnClear);

		btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FMain.refreshFrame(new PMainMenu());
			}
		});
		btnBack.setBounds(10, 14, 41, 23);
		add(btnBack);


		String arrayStates[] = {"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS",
				"MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};

		cbStates = new JComboBox<>(arrayStates);
		cbStates.setBounds(430, 279, 100, 20);
		add(cbStates);

		label = new JLabel("ID");
		label.setBounds(410, 100, 50, 20);
		add(label);

		tfId = new JTextField();
		tfId.setEnabled(false);
		tfId.setEditable(false);
		tfId.setColumns(10);
		tfId.setBounds(410, 120, 120, 20);
		add(tfId);


	}
}
