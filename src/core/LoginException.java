package core;

import java.io.Serial;

public class LoginException extends RuntimeException {
	/**
	 *
	 */
	@Serial
	private static final long serialVersionUID = 1L;

	public LoginException(String message) {
		super("Login exception: " + message);
	}
}
