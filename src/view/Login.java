package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.UserController;

import java.awt.BorderLayout;
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
		
		UserController userController = new UserController();
		
		// define que a janela 
		setResizable(false);
		
		// define o titulo da tela
		setTitle("Login");
		
		// possibilita o usuario fechar a janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// define o tamanho da janela
		setBounds(100, 100, 450, 300);
		setLayout(new BorderLayout());
		
		// cria o panel principal
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(53, 18, 326, 224);
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		// label do email
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
		lblEmail.setBounds(10, 11, 86, 51);
		mainPanel.add(lblEmail);
		
		// texto do email
		txtEmail = new JTextField();
		txtEmail.setBounds(10, 53, 254, 20);
		mainPanel.add(txtEmail);
		txtEmail.setColumns(10);
		
		// label da senha
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
		lblSenha.setBounds(10, 84, 86, 51);
		mainPanel.add(lblSenha);
		
		// texto da senha
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(10, 131, 254, 20);
		mainPanel.add(txtSenha);
		
		// botao de login
		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnLogin.setFont(new Font("Mongolian Baiti", Font.PLAIN, 13));
		btnLogin.setBounds(10, 178, 89, 23);
		mainPanel.add(btnLogin);
		
		// botao de cadastro
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
