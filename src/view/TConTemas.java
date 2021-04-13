package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TConTemas extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel TConTemas;
	private JTable tableTemas;
	private JTextField tfPesquisar;
	private JButton btnEditar;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					TConTemas frame = new TConTemas();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public TConTemas()
	{
		setTitle("Listagem de temas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 430);
		TConTemas = new JPanel();
		TConTemas.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(TConTemas);
		TConTemas.setLayout(null);
		
		tableTemas = new JTable();
		tableTemas.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableTemas.setModel(new DefaultTableModel());
		tableTemas.setBounds(20, 57, 634, 323);
		TConTemas.add(tableTemas);
		
		tfPesquisar = new JTextField();
		tfPesquisar.setBounds(68, 20, 220, 20);
		TConTemas.add(tfPesquisar);
		tfPesquisar.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(20, 20, 50, 20);
		TConTemas.add(lblNome);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(298, 20, 95, 20);
		TConTemas.add(btnPesquisar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(405, 20, 95, 20);
		TConTemas.add(btnEditar);
	}
}
