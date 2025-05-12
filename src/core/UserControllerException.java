package core;

import java.io.Serial;

public class UserControllerException extends RuntimeException {
    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 1L;

    public UserControllerException(String message) {
        super("User controller exception: " + message);
    }
}
