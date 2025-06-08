package controller;

import java.util.ArrayList;
import java.util.List;

import core.LoginException;
import core.SignInException;
import core.UserControllerException;
import model.User;

public class UserController {
	private final List<User> users;

	public UserController() {
		this.users = new ArrayList<>();
	}

	public List<User> getUsers() {
		return users;
	}

	// Returns the user of the given email and password. If there is no user, throws
	// a LoginException
	public User login(String email, String password) throws LoginException {
		User user = getUserByEmail(email);

		if (user == null) {
			throw new LoginException("Email inválido");
		}

		if (!user.getPassword().equals(password)) {
			throw new LoginException("Senha inválida");
		}

		return user;
	}

	/// Instantiates a user with the given email and password and adds it to the
	/// list
	public User signIn(String email, String password) throws Exception {
		User user = new User(email, password);
		return addUser(user);
	}

	// Adds a user to the list. If the given user already exists, throws a
	// UserControllerException
	public User addUser(User user) throws SignInException {
		if (!users.contains(user)) {
			if (user.getEmail().isBlank() || !user.getEmail().contains("@")) {
				throw new SignInException("Email inválido");
			}

			if (user.getPassword().isBlank() || user.getPassword().length() < 3) {
				throw new SignInException("Senha invalida");
			}

			users.add(user);
			return user;
		} else {
			throw new SignInException("O usuário " + user.toString() + " já existe na lista");
		}
	}

	// Removes the user from the list. If the given user does not exist, throws a
	// UserControllerException
	public void removeUser(User user) throws UserControllerException {
		if (users.contains(user)) {
			users.remove(user);
		} else {
			throw new UserControllerException("O usuário " + user.toString() + " não está na lista");
		}
	}

	// Returns a user with the given email
	private User getUserByEmail(String email) {
		for (User user : users) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				return user;
			}
		}

		return null;
	}
}
