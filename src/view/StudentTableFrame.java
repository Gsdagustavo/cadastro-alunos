package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.DisciplinesController;
import core.StudentGradeException;
import model.Discipline;
import model.Student;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentTableFrame extends JFrame {
	private JTable table;
	private DefaultTableModel tableModel;
	private Discipline discipline;
	private DisciplinesController disciplinesController;
	
	public StudentTableFrame(Discipline discipline, DisciplinesController disciplinesController) {
		this.discipline = discipline;
		this.disciplinesController = disciplinesController;
		setTitle("Alunos de " + discipline.getName());
		setSize(700, 400);
		setLocationRelativeTo(null);

		String[] columnNames = { "Nome", "Nota 1", "Nota 2", "Nota 3", "Média" };
		tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);
		getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);

		loadStudents();

		JButton btnAdicionar = new JButton("Adicionar Aluno");
		btnAdicionar.addActionListener(e -> adicionarAluno());

		JButton btnRemover = new JButton("Remover Selecionado");
		btnRemover.addActionListener(e -> removerAluno());

		JButton btnEditar = new JButton("Editar Selecionado");
		btnEditar.addActionListener(e -> editarAluno());

		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnPanel.add(btnAdicionar);
		btnPanel.add(btnEditar);
		btnPanel.add(btnRemover);
		getContentPane().add(btnPanel, BorderLayout.SOUTH);
		
				JButton btnVoltar = new JButton("Voltar");
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DisciplineSelectionScreen disciplineSelectionScreen = new DisciplineSelectionScreen(disciplinesController);
						disciplineSelectionScreen.setVisible(true);
						dispose();
					}
				});
				btnPanel.add(btnVoltar);
	}

	private void loadStudents() {
		tableModel.setRowCount(0);
		for (Student s : discipline.getStudents()) {
			double media = (s.getGrade1() + s.getGrade2() + s.getGrade3()) / 3.0;
			tableModel.addRow(new Object[] { s.getName(), s.getGrade1(), s.getGrade2(), s.getGrade3(),
					String.format("%.2f", media) });
		}
	}

	private void adicionarAluno() {
		JTextField nomeField = new JTextField();
		JTextField nota1Field = new JTextField();
		JTextField nota2Field = new JTextField();
		JTextField nota3Field = new JTextField();

		Object[] message = { "Nome:", nomeField, "Nota 1:", nota1Field, "Nota 2:", nota2Field, "Nota 3:", nota3Field };

		int option = JOptionPane.showConfirmDialog(this, message, "Adicionar Aluno", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			String nome = nomeField.getText().trim();
			try {
				double n1 = Double.parseDouble(nota1Field.getText().trim());
				double n2 = Double.parseDouble(nota2Field.getText().trim());
				double n3 = Double.parseDouble(nota3Field.getText().trim());

				if (nome.isEmpty()) {
					throw new IllegalArgumentException("Nome não pode ser vazio.");
				}

				Student novoAluno = new Student(nome, n1, n2, n3);
				discipline.getStudents().add(novoAluno);

				double media = (n1 + n2 + n3) / 3.0;
				tableModel.addRow(new Object[] { nome, n1, n2, n3, String.format("%.2f", media) });
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Por favor, insira notas válidas (números).");
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			} catch (StudentGradeException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
	}

	private void removerAluno() {
		int row = table.getSelectedRow();
		if (row != -1) {
			String nome = (String) tableModel.getValueAt(row, 0);
			discipline.getStudents().removeIf(s -> s.getName().equals(nome));
			tableModel.removeRow(row);
		} else {
			JOptionPane.showMessageDialog(this, "Selecione um aluno para remover");
		}
	}

	private void editarAluno() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Selecione um aluno para editar");
			return;
		}

		String nomeAtual = (String) tableModel.getValueAt(row, 0);
		Student aluno = discipline.getStudents().stream().filter(s -> s.getName().equals(nomeAtual)).findFirst()
				.orElse(null);

		if (aluno == null) {
			JOptionPane.showMessageDialog(this, "Aluno não encontrado");
			return;
		}

		JTextField nomeField = new JTextField(aluno.getName());
		JTextField nota1Field = new JTextField(String.valueOf(aluno.getGrade1()));
		JTextField nota2Field = new JTextField(String.valueOf(aluno.getGrade2()));
		JTextField nota3Field = new JTextField(String.valueOf(aluno.getGrade3()));

		Object[] message = { "Nome:", nomeField, "Nota 1:", nota1Field, "Nota 2:", nota2Field, "Nota 3:", nota3Field };

		int option = JOptionPane.showConfirmDialog(this, message, "Editar Aluno", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			try {
				String novoNome = nomeField.getText().trim();
				double n1 = Double.parseDouble(nota1Field.getText().trim());
				double n2 = Double.parseDouble(nota2Field.getText().trim());
				double n3 = Double.parseDouble(nota3Field.getText().trim());

				if (novoNome.isEmpty()) {
					throw new IllegalArgumentException("Nome não pode ser vazio");
				}

				aluno = new Student(novoNome, n1, n2, n3);
				discipline.getStudents().set(row, aluno);

				double media = (n1 + n2 + n3) / 3.0;
				tableModel.setValueAt(novoNome, row, 0);
				tableModel.setValueAt(n1, row, 1);
				tableModel.setValueAt(n2, row, 2);
				tableModel.setValueAt(n3, row, 3);
				tableModel.setValueAt(String.format("%.2f", media), row, 4);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Notas inválidas. Use apenas números");
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			} catch (StudentGradeException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
	}
}
