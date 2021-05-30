package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
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
import persistence.ClientsDao;

public class PClientForm extends JPanel
{

	private static final long serialVersionUID = 1L;
	private JTextField tfName, tfStreet, tfDistrict,
	tfCity, tfAddrCompl, tfEmail, tfStreetNum;
	private JFormattedTextField ftfId, ftfCpf, ftfRg, ftfPhone, ftfPostalCode;
	private JTextArea taObs;
	private JLabel lblHeading, label;
	private JButton btnConsultar, btnFinanceiro, btnHistorico, btnQuery, btnSalvar;

	public Dimension getPreferredSize()
	{
		return new Dimension(563, 543);
	}


	public PClientForm()
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

		label = new JLabel("Id");
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
		label.setBounds(300, 260, 46, 20);
		add(label);

		label = new JLabel("Observa\u00E7\u00E3o");
		label.setBounds(20, 320, 100, 20);
		add(label);

		label = new JLabel("Complemento");
		label.setBounds(435, 210, 90, 20);
		add(label);

		label = new JLabel("Número");
		label.setBounds(330, 210, 63, 20);
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
		ftfId.setBounds(400, 80, 134, 20);
		add(ftfId);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 340, 354, 60);
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
		ftfPhone.setBounds(340, 130, 194, 19);
		add(ftfPhone);

		tfEmail = new JTextField();
		tfEmail.setBounds(180, 180, 354, 20);
		add(tfEmail);
		tfEmail.setColumns(10);

		tfStreet = new JTextField();
		tfStreet.setBounds(20, 230, 300, 20);
		add(tfStreet);
		tfStreet.setColumns(10);

		tfDistrict = new JTextField();
		tfDistrict.setBounds(20, 280, 270, 20);
		add(tfDistrict);
		tfDistrict.setColumns(10);

		tfCity = new JTextField();
		tfCity.setBounds(304, 280, 230, 20);
		add(tfCity);
		tfCity.setColumns(10);

		tfAddrCompl = new JTextField();
		tfAddrCompl.setBounds(439, 230, 95, 20);
		add(tfAddrCompl);
		tfAddrCompl.setColumns(10);

		tfStreetNum = new JTextField();
		tfStreetNum.setBounds(330, 230, 95, 20);
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

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(110, 465, 100, 25);
		add(btnSalvar);

		btnQuery = new JButton("Ver Todos");
		btnQuery.setBounds(370, 465, 100, 25);
		add(btnQuery);

		btnHistorico = new JButton("Historico");
		btnHistorico.setBounds(384, 341, 150, 25);
		add(btnHistorico);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(240, 465, 100, 25);
		add(btnConsultar);

		btnFinanceiro = new JButton("Situação Financeira");
		btnFinanceiro.setBounds(384, 376, 150, 25);
		add(btnFinanceiro);

		JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FMain.refreshFrame(new PMainMenu());
			}
		});
		btnBack.setBounds(10, 14, 41, 23);
		add(btnBack);

//		ClientsController ctrClientes = new ClientsController(tfName,  tfEmail,  tfStreet, tfDistrict,  tfCity,  tfAddrCompl,  tfStreetNum, ftfId,  ftfCpf,  ftfRg, ftfPhone,  ftfPostalCode,  taObs);
//		
//		btnConsultar.addActionListener(ctrClientes);
//		btnFinanceiro.addActionListener(ctrClientes);
//		btnHistorico.addActionListener(ctrClientes);
//		btnQuery.addActionListener(ctrClientes);
//		btnSalvar.addActionListener(ctrClientes);

	}
}