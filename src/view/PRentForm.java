package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
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
import controller.RentsController;
import model.ThemesComboBoxModel;
import persistence.ThemesDao;

public class PRentForm extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JTextField tfClientName, tfStreet, tfDistrict, tfCity, tfAddrCompl, tfStreetNum, tfId;

	private JFormattedTextField ftfDate, ftfStartTime, ftfEndTime, ftfValue, ftfDiscount, ftfTotal, ftfPostalCode;
	private JTextArea taObs;

	private JLabel label, lblHeading;
	private JComboBox<String> cbStates;
	private JComboBox<Object> cbThemes;
	private JButton btnSearchClient, btnSearch, btnQuery, btnSubmit, btnRemove, btnBack, btnClear;
	private ThemesDao tDao;
	private JRadioButton rbAddressYes, rbAddressNo;

	public Dimension getPreferredSize()
	{
		return new Dimension(550, 540);
	}

	public PRentForm()
	{
		initComp();
		initList();
		initCBStates();
	}

	private void initCBStates() {
		//		String arrayStates[] = {"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS",
		//				"MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};

		cbStates = new JComboBox<String>();
		cbStates.setBounds(430, 279, 100, 20);
		add(cbStates);

		cbStates.addItem("AC");
		cbStates.addItem("AL");
		cbStates.addItem("AM");
		cbStates.addItem("AP");
		cbStates.addItem("BA");
		cbStates.addItem("CE");
		cbStates.addItem("DF");
		cbStates.addItem("ES");
		cbStates.addItem("GO");
		cbStates.addItem("MA");
		cbStates.addItem("MG");
		cbStates.addItem("MS");
		cbStates.addItem("MT");
		cbStates.addItem("PA");
		cbStates.addItem("PB");
		cbStates.addItem("PE");
		cbStates.addItem("PI");
		cbStates.addItem("PR");
		cbStates.addItem("RJ");
		cbStates.addItem("RN");
		cbStates.addItem("RO");
		cbStates.addItem("RR");
		cbStates.addItem("RS");
		cbStates.addItem("SC");
		cbStates.addItem("SE");
		cbStates.addItem("SP");
		cbStates.addItem("TO");
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

		labels();
		textFields();
		formattedTextFields();
		buttons();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(20, 340, 510, 60);
		add(scrollPane);

		taObs = new JTextArea();
		scrollPane.setViewportView(taObs);

		cbThemes = new JComboBox<Object>();
		cbThemes.setBounds(360, 70, 170, 20);
		add(cbThemes);


	}

	private void labels()
	{
		lblHeading = new JLabel("Cadastro de Alugueis");
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblHeading.setBounds(0, 10, 550, 30);
		add(lblHeading);

		label = new JLabel("Nome");
		label.setBounds(20, 50, 50, 20);
		add(label);

		label = new JLabel("Temas");
		label.setBounds(360, 50, 50, 20);
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

		label = new JLabel("ID");
		label.setBounds(410, 100, 50, 20);
		add(label);

		label = new JLabel("Usar endere\u00E7o de cadastro do cliente?");
		label.setBounds(20, 160, 250, 20);
		add(label);

		label = new JLabel("Logradouro");
		label.setBounds(20, 210, 100, 20);
		add(label);

		label = new JLabel("Número");
		label.setBounds(280, 210, 63, 20);
		add(label);

		label = new JLabel("CEP");
		label.setBounds(340, 210, 63, 20);
		add(label);

		label = new JLabel("Complemento");
		label.setBounds(420, 210, 110, 20);
		add(label);

		label = new JLabel("Bairro");
		label.setBounds(20, 260, 46, 20);
		add(label);

		label = new JLabel("Cidade");
		label.setBounds(260, 260, 46, 20);
		add(label);

		label = new JLabel("UF");
		label.setBounds(430, 260, 45, 20);
		add(label);

		label = new JLabel("Observa\u00E7\u00F5es");
		label.setBounds(20, 320, 110, 20);
		add(label);		

		label = new JLabel("Valor");
		label.setBounds(20, 410, 60, 20);
		add(label);

		label = new JLabel("Descontos");
		label.setBounds(150, 410, 65, 20);
		add(label);

		label = new JLabel("Valor Total");
		label.setBounds(280, 410, 65, 20);
		add(label);
	}

	private void textFields()
	{
		tfClientName = new JTextField();
		tfClientName.setBounds(20, 70, 236, 20);
		add(tfClientName);
		tfClientName.setColumns(10);

		tfId = new JTextField();
		tfId.setEnabled(false);
		tfId.setEditable(false);
		tfId.setColumns(10);
		tfId.setBounds(410, 120, 120, 20);
		add(tfId);

		tfStreet = new JTextField();
		tfStreet.setBounds(20, 230, 250, 20);
		add(tfStreet);
		tfStreet.setColumns(10);

		tfStreetNum = new JTextField();
		tfStreetNum.setBounds(280, 230, 50, 20);
		add(tfStreetNum);
		tfStreetNum.setColumns(10);

		tfAddrCompl = new JTextField();
		tfAddrCompl.setBounds(420, 230, 110, 20);
		add(tfAddrCompl);
		tfAddrCompl.setColumns(10);

		tfDistrict = new JTextField();
		tfDistrict.setBounds(20, 280, 230, 20);
		add(tfDistrict);
		tfDistrict.setColumns(10);

		tfCity = new JTextField();
		tfCity.setBounds(260, 280, 160, 20);
		add(tfCity);
		tfCity.setColumns(10);
	}

	private void formattedTextFields()
	{
		MaskFormatter maskDate = null, maskStartTime = null, maskEndTime = null, maskValue = null, maskDiscount = null, maskTotal = null, maskPostalCode = null;

		try
		{
			maskDate = new MaskFormatter("##/##/####");
			maskStartTime = new MaskFormatter("##:##");
			maskEndTime = new MaskFormatter("##:##");
			maskValue = new MaskFormatter("R$ ####,##");
			maskDiscount = new MaskFormatter("R$ ####,##");
			maskTotal = new MaskFormatter("R$ ####,##");
			maskPostalCode = new MaskFormatter("#####-###");
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

		ftfPostalCode = new JFormattedTextField(maskPostalCode);
		ftfPostalCode.setColumns(10);
		ftfPostalCode.setBounds(340, 230, 70, 20);
		add(ftfPostalCode);

		ftfValue = new JFormattedTextField(maskValue);
		ftfValue.setBounds(20, 430, 100, 20);
		add(ftfValue);

		ftfDiscount = new JFormattedTextField(maskDiscount);
		ftfDiscount.setBounds(150, 430, 100, 20);
		add(ftfDiscount);

		ftfTotal = new JFormattedTextField(maskTotal);
		ftfTotal.setBounds(280, 430, 100, 20);
		add(ftfTotal);
	}

	private void buttons()
	{
		btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FMain.refreshFrame(new PMainMenu());
			}
		});
		btnBack.setBounds(10, 14, 41, 23);
		add(btnBack);


		btnSearchClient = new JButton("Pesquisar");
		btnSearchClient.setBounds(255, 70, 95, 20);
		add(btnSearchClient);

		rbAddressYes = new JRadioButton("Sim");
		rbAddressYes.setSelected(true);
		rbAddressYes.setBounds(20, 180, 55, 20);
		add(rbAddressYes);

		rbAddressNo = new JRadioButton("Não");
		rbAddressNo.setBounds(80, 180, 55, 20);
		add(rbAddressNo);

		ButtonGroup group = new ButtonGroup();
		group.add(rbAddressYes);
		group.add(rbAddressNo);

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



		RentsController rCtrl = new RentsController(tfId, tfClientName, tfStreet, tfDistrict, tfCity, tfAddrCompl, tfStreetNum,
				ftfDate, ftfStartTime, ftfEndTime, ftfPostalCode, ftfValue, ftfDiscount, ftfTotal, taObs,
				rbAddressYes, rbAddressNo, cbStates, cbThemes);
		btnSearchClient.addActionListener(rCtrl);
		btnSearch.addActionListener(rCtrl);
		btnQuery.addActionListener(rCtrl);
		btnSubmit.addActionListener(rCtrl);
		btnRemove.addActionListener(rCtrl);
		btnClear.addActionListener(rCtrl);
		rbAddressYes.addActionListener(rCtrl);
		rbAddressNo.addActionListener(rCtrl);
	}
}
