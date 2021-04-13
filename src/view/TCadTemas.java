package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.ControllerTemas;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class TCadTemas extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel TCadTemas;
	private JTextField tfNome;
	private JFormattedTextField ftfValor;
	private JTextArea taDesc;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					TCadTemas frame = new TCadTemas();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public TCadTemas()
	{
		setTitle("Cadastro de Temas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		TCadTemas = new JPanel();
		TCadTemas.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(TCadTemas);
		TCadTemas.setLayout(null);
		setResizable(false);
		
		JLabel lblTitulo = new JLabel("Cadastro de Temas");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblTitulo.setBounds(10, 10, 414, 30);
		TCadTemas.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(20, 60, 46, 20);
		TCadTemas.add(lblNewLabel);
		
		tfNome = new JTextField();
		tfNome.setBounds(20, 79, 300, 20);
		TCadTemas.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(20, 109, 94, 20);
		TCadTemas.add(lblDescrio);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(20, 198, 46, 20);
		TCadTemas.add(lblValor);
		
		MaskFormatter valor = null;
		
		try
		{
			valor = new MaskFormatter("R$ ##.###,##");
			valor.setPlaceholderCharacter('_');
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		ftfValor = new JFormattedTextField(valor);
		ftfValor.setBounds(20, 217, 110, 20);
		TCadTemas.add(ftfValor);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(60, 260, 95, 23);
		TCadTemas.add(btnSalvar);
		
		JButton btnVerTodos = new JButton("Ver Todos");
		btnVerTodos.setBounds(280, 260, 94, 23);
		TCadTemas.add(btnVerTodos);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(170, 260, 94, 23);
		TCadTemas.add(btnExcluir);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(319, 79, 95, 19);
		TCadTemas.add(btnPesquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(20, 127, 394, 60);
		TCadTemas.add(scrollPane);
		
		taDesc = new JTextArea();
		scrollPane.setViewportView(taDesc);
		
		ControllerTemas ctrTemas = new ControllerTemas(tfNome, taDesc, ftfValor);
		
		btnVerTodos.addActionListener(ctrTemas);
	}
}
