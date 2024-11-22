package com.example.dao;

import com.example.model.Utente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUtenteDAO implements com.example.dao.UtenteDAO {
    private final List<Utente> utenti = new ArrayList<>();

    @Override
    public boolean save(Utente utente) {
        return utenti.add(utente);
    }

    @Override
    public Optional<Utente> findById(int id) {
        return utenti.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public List<Utente> findAll() {
        return new ArrayList<>(utenti);
    }

    @Override
    public boolean delete(int id) {
        return utenti.removeIf(u -> u.getId() == id);
    }
}
