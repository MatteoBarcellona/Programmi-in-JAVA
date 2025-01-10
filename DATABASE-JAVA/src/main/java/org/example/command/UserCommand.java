package org.example.command;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCommand {

    private final UserService userService;

    public UserCommand(UserService userService) {
        this.userService = userService;
    }

    // Metodo per invocare l'operazione di salvataggio
    public String execute(User user) {
        return userService.addUser(user);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}