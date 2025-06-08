package core;

import java.io.Serial;

public class StudentGradeException extends RuntimeException {
	/**
	 *
	 */
	@Serial
	private static final long serialVersionUID = 1L;

	public StudentGradeException(String message) {
		super("Student Grade Exception: " + message);
	}
}
