package core;

import java.io.Serial;

public class SignInException extends RuntimeException {
	/**
	 *
	 */
	@Serial
	private static final long serialVersionUID = 1L;

	public SignInException(String message) {
		super("Sign in exception: " + message);
	}
}
