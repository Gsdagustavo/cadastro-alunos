package controller;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserController {
    private final List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
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
