package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Metodo per aggiungere un utente
    public String addUser(User user) {
        userRepository.saveUser(user);
        return "Utente aggiunto correttamente!";
    }

    public List<User> getAllUsers() {
    return userRepository.findAllUsers();
    }

}