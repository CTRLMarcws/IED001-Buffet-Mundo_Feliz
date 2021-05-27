package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Theme;
import persistence.ThemeDao;
import view.FPrincipal;
import view.PConsulta;

public class ControllerTemas implements ActionListener
{
	private ThemeDao tDao;
	private JTextField tfNome;
	private JFormattedTextField ftfValor;
	private JTextArea taDesc;

	public ControllerTemas(JTextField tfNome, JTextArea taDesc, JFormattedTextField ftfValor)
	{
		this.tfNome = tfNome;
		this.ftfValor = ftfValor;
		this.taDesc = taDesc;
		tDao = new ThemeDao();
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();

		if (cmd.equals("Pesquisar"))
		{

		}
		if (cmd.equals("Salvar"))
		{
			salvar();

		}
		if (cmd.equals("Excluir"))
		{

		}
		if (cmd.equals("Ver Todos"))
		{
			Theme tema = new Theme(tfNome.getText(), taDesc.getText(),  ftfValor.getText());			
			//TemaDao.percorrer();
			//FPrincipal.atualizarFrame(new PConsulta());			
		}
	}

	private void salvar()
	{
		Theme tema = new Theme(tfNome.getText(), taDesc.getText(),  ftfValor.getText());
		String retorno = tDao.AdicionarFinal(tema);
		notificacaoRetorno(retorno, "adicionado");
		limpar();
	}

	private void notificacaoRetorno(String retorno, String contem)
	{
		if (retorno.contains(contem))
		{
			JOptionPane.showMessageDialog(null, retorno, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, retorno, "ERRO", JOptionPane.ERROR_MESSAGE);
		}

	}


	private void limpar()
	{
		tfNome.setText("");
		taDesc.setText("");
		ftfValor.setText("");
	}



}