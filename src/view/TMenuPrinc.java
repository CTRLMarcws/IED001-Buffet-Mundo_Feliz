package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class TMenuPrinc extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					TMenuPrinc frame = new TMenuPrinc();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public TMenuPrinc()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBoasVindas = new JLabel("Bem-vinda de volta, Rafaela!");
		lblBoasVindas.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		lblBoasVindas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoasVindas.setBounds(60, 11, 324, 45);
		contentPane.add(lblBoasVindas);
		
		Date today = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy'.'");  
		String strDate = dateFormat.format(today);
				
		JLabel lblData = new JLabel(strDate);
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(60, 48, 324, 26);
		contentPane.add(lblData);
		
		JButton btnCadTemas = new JButton("Cadastrar");
		btnCadTemas.setBounds(10, 123, 124, 23);
		contentPane.add(btnCadTemas);
		
		JButton btnCadClientes = new JButton("Cadastrar");
		btnCadClientes.setBounds(160, 123, 124, 23);
		contentPane.add(btnCadClientes);
		
		JButton btnCadAlugueis = new JButton("Cadastrar");
		btnCadAlugueis.setBounds(310, 123, 124, 23);
		contentPane.add(btnCadAlugueis);
		
		JButton btnConTemas = new JButton("Consultar");
		btnConTemas.setBounds(10, 156, 124, 23);
		contentPane.add(btnConTemas);
		
		JButton btnConClientes = new JButton("Consultar");
		btnConClientes.setBounds(160, 156, 124, 23);
		contentPane.add(btnConClientes);
		
		JButton btnConAlugueis = new JButton("Consultar");
		btnConAlugueis.setBounds(310, 156, 124, 23);
		contentPane.add(btnConAlugueis);
		
		JLabel lblProximos = new JLabel("Pr\u00F3ximos agendamentos:");
		lblProximos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProximos.setBounds(10, 201, 212, 33);
		contentPane.add(lblProximos);
		
		JList list = new JList();
		list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 237, 424, 93);
		contentPane.add(list);
		
		JLabel lblTemas = new JLabel("Temas");
		lblTemas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemas.setBounds(10, 106, 124, 14);
		contentPane.add(lblTemas);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setBounds(160, 106, 124, 14);
		contentPane.add(lblClientes);
		
		JLabel lblAlugueis = new JLabel("Alugueis");
		lblAlugueis.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlugueis.setBounds(310, 106, 124, 14);
		contentPane.add(lblAlugueis);
		
		
	}
}
