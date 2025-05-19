package controller;

import java.util.ArrayList;
import java.util.List;

import core.LoginException;
import core.SignInException;
import model.User;

public class UserController {
    private final List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

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
    
    public User signIn(String email, String password) throws Exception {
        User user = new User(email, password);
        return addUser(user);
    }

    public User addUser(User user) throws Exception {
        if (!users.contains(user)) {
        	if (user.getEmail().isBlank() || !user.getEmail().contains("@")) {	
        	    throw new SignInException("Email inválido");
        	}

        	
        	if (user.getPassword().isBlank() || user.getPassword().length() < 3) {
        		throw new SignInException("Senha invalida");
        	}
        	
            users.add(user);
            System.out.println("Usuário adicionado com sucesso");
            return user;
        } else {
            throw new SignInException("O usuário " + user.toString() + " já existe na lista");
        }
    }

    public void removeUser(User user) throws Exception {
        if (users.contains(user)) {
            users.remove(user);
            System.out.println("Usuário removido com sucesso");
        } else {
            throw new Exception("O usuário " + user.toString() + " não está na lista");
        }
    }

    private User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }
}
