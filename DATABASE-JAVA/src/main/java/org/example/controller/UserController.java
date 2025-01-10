package org.example.controller;

import org.example.command.UserCommand;
import org.example.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/all")
public class UserController {

    private final UserCommand userCommand;

    public UserController(UserCommand userCommand) {
        this.userCommand = userCommand;
    }

    // Metodo POST per aggiungere un utente
    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        return userCommand.execute(user);
    }


    @GetMapping("/all")public List<User> getAllUsers() {
        return userCommand.getAllUsers();
    }
}