package view;

import javax.swing.JPanel;

import controller.ThemesController;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PThemeForm extends JPanel
{
	private JLabel lblHeading, label;
	private JTextField tfName;
	private JFormattedTextField ftfValue;
	private JTextArea taDesc;
	private JButton btnSubmit, btnQuery, btnRemove, btnSearch;

	private static final long serialVersionUID = 1L;
	private JTextField tfId;

	public Dimension getPreferredSize()
	{
		return new Dimension(460, 300);
	}

	public PThemeForm()
	{
		initComp();
		FMain.setTitle("Cadastro de temas");
	}
	
	public void initComp()
	{
		setLayout(null);
		lblHeading = new JLabel("Cadastro de Temas");
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblHeading.setBounds(0, 10, 450, 30);
		add(lblHeading);

		label = new JLabel("Nome");
		label.setBounds(20, 60, 46, 20);
		add(label);

		tfName = new JTextField();
		tfName.setBounds(20, 79, 316, 20);
		add(tfName);
		tfName.setColumns(10);

		label = new JLabel("Descri\u00E7\u00E3o");
		label.setBounds(20, 109, 94, 20);
		add(label);

		label = new JLabel("Valor");
		label.setBounds(20, 198, 46, 20);
		add(label);

		//		MaskFormatter valor = null;
		//		
		//		try
		//		{
		//			valor = new MaskFormatter("R$ ##.###,##");
		//			valor.setPlaceholderCharacter('_');
		//		}
		//		catch (ParseException e)
		//		{
		//			e.printStackTrace();
		//		}
		ftfValue = new JFormattedTextField();
		ftfValue.setBounds(20, 217, 110, 20);
		add(ftfValue);

		label = new JLabel("ID");
		label.setBounds(320, 198, 46, 20);
		add(label);

		tfId = new JTextField();
		tfId.setEnabled(false);
		tfId.setEditable(false);
		tfId.setBounds(320, 217, 110, 20);
		add(tfId);

		btnSubmit = new JButton("Salvar");
		btnSubmit.setBounds(60, 260, 95, 23);
		add(btnSubmit);

		btnQuery = new JButton("Ver Todos");
		btnQuery.setBounds(295, 260, 95, 23);
		add(btnQuery);

		btnRemove = new JButton("Excluir");
		btnRemove.setBounds(177, 260, 95, 23);
		add(btnRemove);

		btnSearch = new JButton("Pesquisar");
		btnSearch.setBounds(335, 79, 95, 19);
		add(btnSearch);

		tfId.setColumns(10);
		JButton Voltar = new JButton("<");
		Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FMain.refreshFrame(new PMainMenu());
			}
		});
		Voltar.setBounds(10, 14, 41, 23);
		add(Voltar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(20, 127, 410, 60);
		add(scrollPane);

		taDesc = new JTextArea();
		scrollPane.setViewportView(taDesc);

		ThemesController tCtrl = new ThemesController(tfName, taDesc, ftfValue);


		btnSearch.addActionListener(tCtrl);
		btnSubmit.addActionListener(tCtrl);
		btnRemove.addActionListener(tCtrl);
		btnQuery.addActionListener(tCtrl);
	}
}
