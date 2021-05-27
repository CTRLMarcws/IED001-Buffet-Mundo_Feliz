package view;

import javax.swing.JPanel;

import controller.ControllerThemes;

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

public class PRegThemes extends JPanel
{

	private JLabel lblTitulo, label;
	private JTextField tfNome;
	private JFormattedTextField ftfValor;
	private JTextArea taDesc;
	private JButton btnSalvar, btnVerTodos, btnExcluir, btnPesquisar;

	private static final long serialVersionUID = 1L;

	public Dimension getPreferredSize()
	{
		return new Dimension(460, 300);
	}

	public PRegThemes()
	{
		setLayout(null);
		lblTitulo = new JLabel("Cadastro de Temas");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblTitulo.setBounds(0, 10, 450, 30);
		add(lblTitulo);

		label = new JLabel("Nome");
		label.setBounds(20, 60, 46, 20);
		add(label);

		tfNome = new JTextField();
		tfNome.setBounds(20, 79, 316, 20);
		add(tfNome);
		tfNome.setColumns(10);

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
		ftfValor = new JFormattedTextField();
		ftfValor.setBounds(20, 217, 110, 20);
		add(ftfValor);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(60, 260, 95, 23);
		add(btnSalvar);

		btnVerTodos = new JButton("Ver Todos");
		btnVerTodos.setBounds(295, 260, 95, 23);
		add(btnVerTodos);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(177, 260, 95, 23);
		add(btnExcluir);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(335, 79, 95, 19);
		add(btnPesquisar);

		JButton Voltar = new JButton("<");
		Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FPrincipal.atualizarFrame(new PMenuPrinc());
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

		ControllerThemes ctrTemas = new ControllerThemes(tfNome, taDesc, ftfValor);

		btnPesquisar.addActionListener(ctrTemas);
		btnSalvar.addActionListener(ctrTemas);
		btnExcluir.addActionListener(ctrTemas);
		btnVerTodos.addActionListener(ctrTemas);
	}
}
