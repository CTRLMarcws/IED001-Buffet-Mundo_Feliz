package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PConsulta extends JPanel
{

	private static final long serialVersionUID = 1L;
	private JTable tableTemas;
	private JTextField tfPesquisar;
	private JButton btnEditar, btnPesquisar;
	private JLabel lblTituloPesquisa;
	private JComboBox comboBox;

	public Dimension getPreferredSize()
	{
		return new Dimension(690, 430);
	}

	public PConsulta()
	{
		String tipo = "Clientes";
		setBounds(100, 100, 690, 430);
		setLayout(null);
		
		tableTemas = new JTable();
		tableTemas.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableTemas.setModel(new DefaultTableModel());
		tableTemas.setBounds(10, 81, 670, 338);
		add(tableTemas);
		
		tfPesquisar = new JTextField();
		tfPesquisar.setBounds(113, 48, 350, 20);
		add(tfPesquisar);
		tfPesquisar.setColumns(10);
		
		btnPesquisar = new JButton("Pesquisar");
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
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FPrincipal.atualizarFrame(new PCadTemas());
			}
		});
		btnNewButton.setBounds(10, 14, 41, 23);
		add(btnNewButton);
	}
}
