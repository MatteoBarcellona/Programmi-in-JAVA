package com.example.service;

import com.example.dao.UtenteDAO;
import com.example.model.Utente;
import java.util.List;

public class UtenteService {
    private final UtenteDAO utenteDAO;

    public  UtenteService(UtenteDAO utenteDAO) {
        this.utenteDAO = utenteDAO;
    }

    public boolean aggiungiUtente(Utente utente) {
        return utenteDAO.save(utente);
    }

    public Utente trovaUtente(int id) {
        return utenteDAO.findById(id).orElse(null);
    }

    public List<Utente> tuttiGliUtenti() {
        return utenteDAO.findAll();
    }

    public boolean eliminaUtente(int id) {
        return utenteDAO.delete(id);
    }
}
