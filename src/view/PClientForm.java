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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.ClientsController;

public class PClientForm extends JPanel
{

	private static final long serialVersionUID = 1L;
	private JTextField tfName,  tfEmail;
	private JFormattedTextField ftfId, ftfCpf, ftfRg, ftfPhone;
	private JTextArea taObs;

	private JTextField tfStreet, tfDistrict, tfCity, tfAddrCompl, tfStreetNum;
	private JFormattedTextField ftfPostalCode;

	private JLabel lblHeading, label;
	private JButton btnSearch, btnHistory, btnQuery, btnSubmit, btnRemove, btnBack, btnClear;

	public Dimension getPreferredSize()
	{
		return new Dimension(550, 500);
	}


	public PClientForm()
	{
		initComp();
		FMain.setTitle("Cadastro de Clientes");
	}
	public void initComp()
	{
		setLayout(null);

		lblHeading = new JLabel("Cadastro de Clientes");
		lblHeading.setBounds(0, 10, 546, 30);
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		add(lblHeading);

		label = new JLabel("Nome");
		label.setBounds(20, 60, 46, 20);
		add(label);

		label = new JLabel("ID");
		label.setBounds(400, 60, 46, 20);
		add(label);

		label = new JLabel("CPF");
		label.setBounds(20, 110, 46, 20);
		add(label);

		label = new JLabel("RG");
		label.setBounds(180, 110, 46, 20);
		add(label);

		label = new JLabel("Telefone Celular");
		label.setBounds(340, 110, 118, 20);
		add(label);

		label = new JLabel("Email");
		label.setBounds(180, 160, 46, 20);
		add(label);

		label = new JLabel("Logradouro");
		label.setBounds(20, 210, 100, 20);
		add(label);

		label = new JLabel("Bairro");
		label.setBounds(20, 260, 46, 20);
		add(label);

		label = new JLabel("Cidade");
		label.setBounds(370, 260, 46, 20);
		add(label);

		label = new JLabel("Observa\u00E7\u00E3o");
		label.setBounds(20, 310, 100, 20);
		add(label);

		label = new JLabel("Complemento");
		label.setBounds(390, 210, 90, 20);
		add(label);

		label = new JLabel("Número");
		label.setBounds(280, 210, 63, 20);
		add(label);

		label = new JLabel("CEP");
		label.setBounds(20, 160, 46, 20);
		add(label);

		tfName = new JTextField();
		tfName.setBounds(20, 80, 370, 20);
		add(tfName);
		tfName.setColumns(10);

		MaskFormatter Id = null;

		try
		{
			Id = new MaskFormatter("#####");
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

		ftfId = new JFormattedTextField(Id);
		ftfId.setEnabled(false);
		ftfId.setEditable(false);
		ftfId.setBounds(400, 80, 130, 20);
		add(ftfId);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 330, 510, 60);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);

		taObs = new JTextArea();
		scrollPane.setViewportView(taObs);

		MaskFormatter Cpf = null;

		try
		{
			Cpf = new MaskFormatter("###.###.###-##");
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

		ftfCpf = new JFormattedTextField(Cpf);
		ftfCpf.setBounds(20, 130, 150, 20);
		add(ftfCpf);

		MaskFormatter Rg = null;

		try
		{
			Rg = new MaskFormatter("##.###.###-#");
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

		ftfRg = new JFormattedTextField(Rg);
		ftfRg.setBounds(180, 130, 150, 20);
		add(ftfRg);

		MaskFormatter Fone = null;

		try
		{
			Fone = new MaskFormatter("(##) # ####-####");
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

		ftfPhone = new JFormattedTextField(Fone);
		ftfPhone.setBounds(340, 130, 190, 20);
		add(ftfPhone);

		tfEmail = new JTextField();
		tfEmail.setBounds(180, 180, 350, 20);
		add(tfEmail);
		tfEmail.setColumns(10);

		tfStreet = new JTextField();
		tfStreet.setBounds(20, 230, 250, 20);
		add(tfStreet);
		tfStreet.setColumns(10);

		tfDistrict = new JTextField();
		tfDistrict.setBounds(20, 280, 270, 20);
		add(tfDistrict);
		tfDistrict.setColumns(10);

		tfCity = new JTextField();
		tfCity.setBounds(370, 280, 160, 20);
		add(tfCity);
		tfCity.setColumns(10);

		tfAddrCompl = new JTextField();
		tfAddrCompl.setBounds(390, 230, 140, 20);
		add(tfAddrCompl);
		tfAddrCompl.setColumns(10);

		tfStreetNum = new JTextField();
		tfStreetNum.setBounds(280, 230, 100, 20);
		add(tfStreetNum);
		tfStreetNum.setColumns(10);

		MaskFormatter Cep = null;

		try
		{
			Cep = new MaskFormatter("#####-###");
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

		ftfPostalCode = new JFormattedTextField(Cep);
		ftfPostalCode.setBounds(20, 180, 150, 20);
		add(ftfPostalCode);

		btnSubmit = new JButton("Salvar");
		btnSubmit.setBounds(40, 410, 130, 25);
		add(btnSubmit);

		btnQuery = new JButton("Ver Todos");
		btnQuery.setBounds(380, 410, 130, 25);
		add(btnQuery);

		btnHistory = new JButton("Historico");
		btnHistory.setBounds(380, 445, 130, 25);
		add(btnHistory);

		btnSearch = new JButton("Consultar");
		btnSearch.setBounds(210, 410, 130, 25);
		add(btnSearch);

		btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FMain.refreshFrame(new PMainMenu());
			}
		});
		btnBack.setBounds(10, 14, 41, 23);
		add(btnBack);

		btnClear = new JButton("Limpar");
		btnClear.setBounds(210, 445, 130, 25);
		add(btnClear);

		ClientsController ctrClientes = new ClientsController(ftfId, tfName, ftfCpf, ftfRg, tfEmail,
				ftfPhone, taObs, tfStreet, tfDistrict, tfCity, tfAddrCompl, tfStreetNum, ftfPostalCode);

		String arrayStates[] = {"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS",
				"MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};
		
		JComboBox<String> cbStates = new JComboBox<>(arrayStates);
		cbStates.setBounds(300, 280, 60, 20);
		add(cbStates);

		label = new JLabel("Estado");
		label.setBounds(304, 260, 46, 20);
		add(label);

		btnRemove = new JButton("Excluir");
		btnRemove.setBounds(40, 445, 130, 25);
		add(btnRemove);

		btnRemove.addActionListener(ctrClientes);
		btnSearch.addActionListener(ctrClientes);
		btnClear.addActionListener(ctrClientes);
		btnHistory.addActionListener(ctrClientes);
		btnQuery.addActionListener(ctrClientes);
		btnSubmit.addActionListener(ctrClientes);

	}
}