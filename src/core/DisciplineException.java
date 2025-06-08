package core;

import java.io.Serial;

public class DisciplineException extends RuntimeException {
	/**
	 *
	 */
	@Serial
	private static final long serialVersionUID = 1L;

	public DisciplineException(String message) {
		super("Discipline exception: " + message);
	}
}
