package model;

import java.util.Objects;

import core.StudentGradeException;

public class Student {
	private String name;
	private double grade1;
	private double grade2;
	private double grade3;

	public Student(String name, double grade1, double grade2, double grade3) {
		this.name = name;

		if (!isValidGrade(grade1) || !isValidGrade(grade2) || !isValidGrade(grade3)) {
			throw new StudentGradeException("Notas inválidas. Insira apenas números entre 0 e 10");
		}

		this.grade1 = grade1;
		this.grade2 = grade2;
		this.grade3 = grade3;
	}

	static private boolean isValidGrade(double grade) {
		return grade >= 0 && grade <= 10;
	}

	public double getMedia() {
		return (grade1 + grade2 + grade3) / 3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGrade1() {
		return grade1;
	}

	public void setGrade1(double grade1) {
		if (!isValidGrade(grade1)) {
			throw new StudentGradeException("Nota inválida. Insira apenas números entre 0 e 10");
		}

		this.grade1 = grade1;
	}

	public double getGrade2() {
		return grade2;
	}

	public void setGrade2(double grade2) {
		if (!isValidGrade(grade1)) {
			throw new StudentGradeException("Nota inválida. Insira apenas números entre 0 e 10");
		}

		this.grade2 = grade2;
	}

	public double getGrade3() {
		return grade3;
	}

	public void setGrade3(double grade3) {
		if (!isValidGrade(grade1)) {
			throw new StudentGradeException("Nota inválida. Insira apenas números entre 0 e 10");
		}

		this.grade3 = grade3;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		Student student = (Student) o;
		return Double.compare(grade1, student.grade1) == 0 && Double.compare(grade2, student.grade2) == 0
				&& Double.compare(grade3, student.grade3) == 0 && Objects.equals(name, student.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, grade1, grade2, grade3);
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", grade1=" + grade1 + ", grade2=" + grade2 + ", grade3=" + grade3
				+ '}';
	}
}
