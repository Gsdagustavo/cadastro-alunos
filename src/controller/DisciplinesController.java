package controller;

import java.util.List;

import core.DisciplineException;
import model.Discipline;

public class DisciplinesController {
	public List<Discipline> disciplines;

	public DisciplinesController() {
		this.disciplines = List.of(new Discipline("Português"), new Discipline("Matemática"), new Discipline("Inglês"));
	};

	public List<Discipline> getDisciplines() {
		return disciplines;
	}

	public void addDiscipline(Discipline discipline) throws DisciplineException {
		if (!disciplines.stream().anyMatch(d -> d.getName() == discipline.getName())) {
			disciplines.add(discipline);
		} else {
			throw new DisciplineException("A Disciplina " + discipline.getName() + " ja existe na lista");
		}
	}

	public void removeDiscipline(Discipline discipline) throws DisciplineException {
		if (!disciplines.removeIf(d -> d.getName() == discipline.getName())) {
			throw new DisciplineException("Disciplina " + discipline.getName() + " invalida");
		}
	}
}
