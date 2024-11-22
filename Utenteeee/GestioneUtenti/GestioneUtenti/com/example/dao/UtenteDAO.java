package com.example.dao;

import com.example.model.Utente;
import java.util.List;
import java.util.Optional;

public interface UtenteDAO {
    boolean save(Utente utente);
    Optional<Utente> findById(int id);
    List<Utente> findAll();
    boolean delete(int id);
}
