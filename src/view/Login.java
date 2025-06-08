package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DisciplinesController;
import controller.UserController;
import core.LoginException;
import model.User;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField pfSenha;
	private UserController userController;

	private DisciplinesController disciplinesController;

	public Login() {

		userController = new UserController();
		disciplinesController = new DisciplinesController();

		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());

		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(53, 18, 326, 224);
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(130, 11, 86, 51);
		mainPanel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(29, 53, 254, 20);
		mainPanel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(130, 84, 86, 51);
		mainPanel.add(lblSenha);

		pfSenha = new JPasswordField();
		pfSenha.setBounds(29, 134, 254, 20);
		mainPanel.add(pfSenha);

		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = txtEmail.getText();
				String password = new String(pfSenha.getPassword());

				try {
					User loggedUser = userController.login(email, password);
					JOptionPane.showMessageDialog(Login.this, "Bem-vindo, " + loggedUser.getEmail());

					DisciplineSelectionScreen disciplineSelectionScreen = new DisciplineSelectionScreen(
							disciplinesController);
					disciplineSelectionScreen.setVisible(true);

					dispose();
				} catch (LoginException ex) {
					JOptionPane.showMessageDialog(Login.this, ex.getMessage(), "Erro no Login",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBounds(10, 178, 130, 23);
		mainPanel.add(btnLogin);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = txtEmail.getText();
				String password = new String(pfSenha.getPassword());

				try {
					userController.signIn(email, password);
					JOptionPane.showMessageDialog(Login.this, "Usuário cadastrado com sucesso!");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(Login.this, ex.getMessage(), "Erro ao cadastrar",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCadastrar.setBounds(186, 178, 130, 23);
		mainPanel.add(btnCadastrar);
	}
}
