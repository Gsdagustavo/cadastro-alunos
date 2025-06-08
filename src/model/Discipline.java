package model;

import core.DisciplineException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Discipline {
	private String name;
	private List<Student> students = new ArrayList<Student>();

	public Discipline(String name) {
		this.name = name;

		students.add(new Student("Ana Clara", 8.5, 7.2, 9.0));
		students.add(new Student("Bruno Silva", 6.3, 5.8, 7.1));
		students.add(new Student("Carlos Eduardo", 9.0, 8.7, 9.2));
		students.add(new Student("Daniela Souza", 7.5, 8.0, 6.9));
		students.add(new Student("Eduardo Lima", 4.2, 5.5, 6.0));
		students.add(new Student("Fernanda Rocha", 10.0, 9.8, 9.5));
		students.add(new Student("Gabriel Martins", 6.4, 7.3, 6.8));
		students.add(new Student("Helena Castro", 8.1, 8.5, 7.9));
		students.add(new Student("Igor Mendes", 5.5, 6.0, 5.8));
		students.add(new Student("Juliana Freitas", 9.4, 9.1, 8.7));
		students.add(new Student("Kaio Oliveira", 3.7, 4.2, 5.1));
		students.add(new Student("Laura Ribeiro", 7.7, 8.2, 8.0));
		students.add(new Student("Marcos Vinícius", 6.9, 6.7, 7.3));
		students.add(new Student("Natália Gomes", 9.9, 9.3, 10.0));
		students.add(new Student("Otávio Pereira", 5.8, 6.6, 7.0));
		students.add(new Student("Paula Fernandes", 8.8, 9.0, 9.1));
		students.add(new Student("Rafael Duarte", 7.0, 6.5, 6.9));
		students.add(new Student("Sabrina Alves", 9.5, 9.7, 9.2));
		students.add(new Student("Thiago Costa", 4.8, 5.2, 4.9));
		students.add(new Student("Vanessa Dias", 8.0, 7.9, 8.3));
	}

	public void addStudent(Student student) throws DisciplineException {
		if (!students.contains(student)) {
			students.add(student);
		} else {
			throw new DisciplineException("Student already exists on the discipline");
		}
	}

	public void removeStudent(String name) throws DisciplineException {
		if (!students.removeIf(s -> s.getName().equals(name))) {
			throw new DisciplineException("Student does not exist on the discipline");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		Discipline that = (Discipline) o;
		return Objects.equals(name, that.name) && Objects.equals(students, that.students);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, students);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
