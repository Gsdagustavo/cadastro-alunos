package view;

import view.Login;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Discipline;
import javax.swing.JComboBox;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisciplineSelectionScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public DisciplineSelectionScreen() {
        setResizable(false);
        setTitle("Selecionar Disciplina");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        List<Discipline> disciplines = List.of(
          new Discipline("Portugues"),
          new Discipline("Matematica"),
          new Discipline("Ingles")
        );

        JComboBox<Discipline> cbDisciplinas = new JComboBox<>(disciplines.toArray(new Discipline[0]));
        cbDisciplinas.setToolTipText("Selecionar Disciplina");
        cbDisciplinas.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cbDisciplinas.setBounds(98, 75, 225, 26);
        contentPane.add(cbDisciplinas);
        
        JButton btnAbrirTabelaAlunos = new JButton("Abrir Tabela de Alunos");
        btnAbrirTabelaAlunos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Discipline selected = (Discipline) cbDisciplinas.getSelectedItem();
                if (selected != null) {
                    StudentTableFrame studentFrame = new StudentTableFrame(selected);
                    studentFrame.setVisible(true);
                    dispose();
                }
        	}
        });
        btnAbrirTabelaAlunos.setBounds(136, 200, 153, 23);
        contentPane.add(btnAbrirTabelaAlunos);
        
        JButton btnVoltar = new JButton("Voltar para a tela de login");
        btnVoltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Login login = new Login();
        		login.setVisible(true);
        		dispose();
        	}
        });
        btnVoltar.setBounds(10, 11, 218, 23);
        contentPane.add(btnVoltar);
    }
}
