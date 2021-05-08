package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import controller.ControllerPrincipal;
import controller.ControllerTemas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("rawtypes")
public class PMenuPrinc extends JPanel
{
	private JLabel lblBoasVindas, lblData, lblProximos;
	private JButton btnCadastro, btnConsulta;
	private JList ltProximos;
	private JComboBox listaOpcoes;
	
	private static final long serialVersionUID = 1L;

	public Dimension getPreferredSize()
	{
		return new Dimension(460, 300);
	}
	
	public PMenuPrinc() 
	{
		setLayout(null);
		
		lblBoasVindas = new JLabel("Bem-vinda de volta, Rafaela!");
		lblBoasVindas.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		lblBoasVindas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoasVindas.setBounds(10, 11, 430, 45);
		add(lblBoasVindas);
		
		Date data = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy'.'");  
		String strDate = dateFormat.format(data);
				
		lblData = new JLabel(strDate);
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(10, 48, 430, 26);
		add(lblData);
		
		btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastro.setBounds(175, 113, 100, 23);
		add(btnCadastro);
		
		btnConsulta = new JButton("Consultar");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsulta.setBounds(320, 113, 100, 23);
		add(btnConsulta);
		
		lblProximos = new JLabel("Pr\u00F3ximos agendamentos:");
		lblProximos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProximos.setBounds(10, 160, 212, 33);
		add(lblProximos);
		
		ltProximos = new JList();
		ltProximos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		ltProximos.setModel(new AbstractListModel() {
			String[] values = new String[] {""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		ltProximos.setBounds(10, 196, 430, 93);
		add(ltProximos);
		
		listaOpcoes = new JComboBox();
		listaOpcoes.setModel(new DefaultComboBoxModel(new String[] {"Temas", "Clientes", "Alugueis"}));
		listaOpcoes.setBounds(30, 113, 100, 22);
		add(listaOpcoes);
		
		
		ControllerPrincipal ctrPrinc = new ControllerPrincipal(listaOpcoes, btnCadastro, btnConsulta);
		btnCadastro.addActionListener(ctrPrinc);
		btnConsulta.addActionListener(ctrPrinc);

	}
}
