package org.example.repository;

import org.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private static List<User> users = new ArrayList<>();

    // Metodo per aggiungere l'utente
    public void saveUser(User user) {
        users.add(user);
    }

    // Metodo per ottenere tutti gli utenti (opzionale per il controllo)
    public List<User> findAllUsers() {
        return new ArrayList<>(users);
    }
}