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
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            System.out.println("Student added successfully");
        } else {
            throw new DisciplineException("Student already exists on the discipline");
        }
    }

    public void removeStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            System.out.println("Student removed successfully");
        } else {
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

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
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
