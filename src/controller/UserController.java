package controller;

import java.util.ArrayList;
import java.util.List;

import core.LoginException;
import model.User;

public class UserController {
    private final List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    User login(String email, String password) throws LoginException {
        User user = getUserByEmail(email);
        
        if (user == null) {
            throw new LoginException("Email invalido");
        }
        
        if (!user.getPassword().equals(password)) {
            throw new LoginException("Senha invalida");
        }
        
        return user;
    }

    private User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }

        return null;
    }

    public void addUser(User user) throws Exception {
        if (!users.contains(user)) {
            users.add(user);
            System.out.println("Usuario adicionado com sucesso");
        } else {
            throw new Exception("O usuário " + user.toString() + " já existe na lista");
        }
    }

    public void removeUser(User user) throws Exception {
        if (users.contains(user)) {
            users.remove(user);
            System.out.println("Usuario removido com sucesso");
        } else {
            throw new Exception("O usuário " + user.toString() + " não na lista");
        }
    }
}
