package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerConsulta;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;

public class PConsulta extends JPanel
{

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField tfPesquisar;
	private JButton btnEditar, btnPesquisar;
	private JLabel lblTituloPesquisa;
	private JComboBox comboBox;

	private String dados[][] = {{"Batman","Festa DC"},
			{"Iron Main", "Marvel do Ceara"}};
	private String colunas[] = {"Nome", "Descrição"};

	public Dimension getPreferredSize()
	{
		return new Dimension(690, 430);
	}

	public PConsulta()
	{
		String tipo = "Clientes";
		setBounds(100, 100, 690, 430);
		setLayout(null);


		tfPesquisar = new JTextField();
		tfPesquisar.setBounds(113, 48, 350, 20);
		add(tfPesquisar);
		tfPesquisar.setColumns(10);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnPesquisar.setBounds(470, 47, 100, 23);
		add(btnPesquisar);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(580, 47, 100, 23);
		add(btnEditar);

		lblTituloPesquisa = new JLabel("Pesquisa de " + tipo);
		lblTituloPesquisa.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPesquisa.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblTituloPesquisa.setBounds(10, 11, 670, 23);
		add(lblTituloPesquisa);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nome", "ID"}));
		comboBox.setBounds(10, 47, 93, 22);
		add(comboBox);

		JButton btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FPrincipal.atualizarFrame(new PCadTemas());
			}
		});
		btnVoltar.setBounds(10, 14, 41, 23);
		add(btnVoltar);

		//tableTemas = new JTable(ControllerConsulta.getDados(), ControllerConsulta.getColunas());
		table = new JTable(dados, colunas);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 81, 670, 338);
		add(scrollPane);

		
	}
}
