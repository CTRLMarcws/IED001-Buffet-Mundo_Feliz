package view;



import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;



import controller.ControllerClientes;



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




public class PCadClientes extends JFrame {



private static final long serialVersionUID = 1L;
private JPanel PCadClientes;
private JTextField tfNome, tfEndereco, tfBairro, tfCidade, tfComp, tfEmail, tfEndNum;
private JFormattedTextField ftfId, ftfCpf, ftfRg, ftfFone, ftfCep;
private JTextArea taObs;



public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
PCadClientes frame = new PCadClientes();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}



public PCadClientes() {
setTitle("Cadastro de Clientes");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 563, 543);
PCadClientes = new JPanel();
PCadClientes.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(PCadClientes);
PCadClientes.setLayout(null);
setResizable(false);
this.setLocationRelativeTo(null);



JLabel lblTitulo = new JLabel("Cadastro de Clientes");
lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
lblTitulo.setFont(new Font("Century Gothic", Font.PLAIN, 18));
lblTitulo.setBounds(68, 10, 414, 30);
PCadClientes.add(lblTitulo);



JLabel lblNewLabel = new JLabel("Nome");
lblNewLabel.setBounds(20, 60, 46, 20);
PCadClientes.add(lblNewLabel);



tfNome = new JTextField();
tfNome.setBounds(20, 80, 370, 20);
PCadClientes.add(tfNome);
tfNome.setColumns(10);

JLabel lblId = new JLabel("Id");
lblId.setBounds(400, 60, 46, 20);
PCadClientes.add(lblId);

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
PCadClientes.add(ftfId);




JScrollPane scrollPane = new JScrollPane();
scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
scrollPane.setBounds(20, 340, 354, 60);
PCadClientes.add(scrollPane);

taObs = new JTextArea();
scrollPane.setViewportView(taObs);

JLabel lblCpf = new JLabel("CPF");
lblCpf.setBounds(20, 110, 46, 20);
PCadClientes.add(lblCpf);

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
PCadClientes.add(ftfCpf);

JLabel lblRg = new JLabel("RG");
lblRg.setBounds(180, 110, 46, 20);
PCadClientes.add(lblRg);

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
PCadClientes.add(ftfRg);

JLabel lblFone = new JLabel("Telefone Celular");
lblFone.setBounds(340, 110, 118, 20);
PCadClientes.add(lblFone);

MaskFormatter Fone = null;

try
{
Fone = new MaskFormatter("(##) # ####-####");



}
catch (ParseException e)
{
e.printStackTrace();
}


ftfFone = new JFormattedTextField(Fone);
ftfFone.setBounds(340, 130, 194, 19);
PCadClientes.add(ftfFone);

JLabel lblEmail = new JLabel("Email");
lblEmail.setBounds(180, 160, 46, 20);
PCadClientes.add(lblEmail);



tfEmail = new JTextField();
tfEmail.setBounds(180, 180, 354, 20);
PCadClientes.add(tfEmail);
tfEmail.setColumns(10);

JLabel lblEndereco = new JLabel("Logradouro");
lblEndereco.setBounds(20, 210, 100, 20);
PCadClientes.add(lblEndereco);



tfEndereco = new JTextField();
tfEndereco.setBounds(20, 230, 300, 20);
PCadClientes.add(tfEndereco);
tfEndereco.setColumns(10);

JLabel lblBairro = new JLabel("Bairro");
lblBairro.setBounds(20, 260, 46, 20);
PCadClientes.add(lblBairro);



tfBairro = new JTextField();
tfBairro.setBounds(20, 280, 270, 20);
PCadClientes.add(tfBairro);
tfBairro.setColumns(10);

JLabel lblCidade = new JLabel("Cidade");
lblCidade.setBounds(300, 260, 46, 20);
PCadClientes.add(lblCidade);



tfCidade = new JTextField();
tfCidade.setBounds(304, 280, 230, 20);
PCadClientes.add(tfCidade);
tfCidade.setColumns(10);

JLabel lblComp = new JLabel("Complemento");
lblComp.setBounds(435, 210, 90, 20);
PCadClientes.add(lblComp);



tfComp = new JTextField();
tfComp.setBounds(439, 230, 95, 20);
PCadClientes.add(tfComp);
tfComp.setColumns(10);

JLabel lblEndNum = new JLabel("Número");
lblEndNum.setBounds(330, 210, 63, 20);
PCadClientes.add(lblEndNum);



tfEndNum = new JTextField();
tfEndNum.setBounds(330, 230, 95, 20);
PCadClientes.add(tfEndNum);
tfEndNum.setColumns(10);

JLabel lblCep = new JLabel("CEP");
lblCep.setBounds(20, 160, 46, 20);
PCadClientes.add(lblCep);

MaskFormatter Cep = null;

try
{
Cep = new MaskFormatter("#####-###");



}
catch (ParseException e)
{
e.printStackTrace();
}

ftfCep = new JFormattedTextField(Cep);
ftfCep.setBounds(20, 180, 150, 20);
PCadClientes.add(ftfCep);

JLabel lblObs = new JLabel("Observa\u00E7\u00E3o");
lblObs.setBounds(20, 320, 100, 20);
PCadClientes.add(lblObs);

JButton btnSalvar = new JButton("Salvar");
btnSalvar.setBounds(110, 465, 100, 25);
PCadClientes.add(btnSalvar);

JButton btnVerTodos = new JButton("Ver Todos");
btnVerTodos.setBounds(370, 465, 100, 25);
PCadClientes.add(btnVerTodos);

JButton btnHistorico = new JButton("Historico");
btnHistorico.setBounds(384, 341, 150, 25);
PCadClientes.add(btnHistorico);

JButton btnConsultar = new JButton("Consultar");
btnConsultar.setBounds(240, 465, 100, 25);
PCadClientes.add(btnConsultar);

JButton btnFinanceiro = new JButton("Situação Financeira");
btnFinanceiro.setBounds(384, 376, 150, 25);
PCadClientes.add(btnFinanceiro);

}
}