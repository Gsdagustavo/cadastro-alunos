package view;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Discipline;
import model.Student;
import java.awt.GridLayout;

public class StudentTableFrame extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private Discipline discipline;

    public StudentTableFrame(Discipline discipline) {
        this.discipline = discipline;
        setTitle("Alunos de " + discipline.getName());
        setSize(600, 400);
        setLocationRelativeTo(null);

        String[] columnNames = {"Nome", "Nota 1", "Nota 2", "Nota 3", "Média"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);

        loadStudents();

        JButton btnAdicionar = new JButton("Adicionar Aluno");
        btnAdicionar.addActionListener(e -> {
            // abrir tela para adicionar aluno
            JOptionPane.showMessageDialog(this, "Funcionalidade ainda não implementada.");
        });

        JButton btnRemover = new JButton("Remover Selecionado");
        btnRemover.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                String nome = (String) tableModel.getValueAt(row, 0);
                discipline.getStudents().removeIf(s -> s.getName().equals(nome));
                tableModel.removeRow(row);
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(0, 2, 0, 0));
        btnPanel.add(btnAdicionar);
        btnPanel.add(btnRemover);
        getContentPane().add(btnPanel, BorderLayout.SOUTH);
    }

    private void loadStudents() {
        for (Student s : discipline.getStudents()) {
            double media = (s.getGrade1() + s.getGrade2() + s.getGrade3()) / 3.0;
            tableModel.addRow(new Object[] {
                s.getName(), s.getGrade1(), s.getGrade2(), s.getGrade3(), media
            });
        }
    }
}
