package myProject;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtSenha;

	

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(53, 18, 326, 224);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
		lblEmail.setBounds(10, 11, 86, 51);
		mainPanel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(10, 53, 254, 20);
		mainPanel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(10, 131, 254, 20);
		mainPanel.add(txtSenha);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
		lblSenha.setBounds(10, 84, 86, 51);
		mainPanel.add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEntrar.setFont(new Font("Mongolian Baiti", Font.PLAIN, 13));
		btnEntrar.setBounds(10, 178, 89, 23);
		mainPanel.add(btnEntrar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Mongolian Baiti", Font.PLAIN, 13));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setBounds(227, 178, 89, 23);
		mainPanel.add(btnCadastrar);
	}
}
