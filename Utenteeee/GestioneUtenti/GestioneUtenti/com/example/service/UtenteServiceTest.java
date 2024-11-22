package com.example.service;

import com.example.dao.UtenteDAO;
import com.example.model.Utente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UtenteServiceTest {
    private UtenteDAO utenteDAO;
    private UtenteService utenteService;

    @BeforeEach
    void setUp() {
        utenteDAO = mock(UtenteDAO.class);
        utenteService = new UtenteService(utenteDAO);
    }

    @Test
    void testAggiungiUtente() {
        Utente utente = new Utente(1, "Mario Rossi", "mario.rossi@example.com");
        when(utenteDAO.save(utente)).thenReturn(true);

        assertTrue(utenteService.aggiungiUtente(utente));
        verify(utenteDAO).save(utente);
    }



    @Test
    void testTrovaUtente() {
        Utente utente = new Utente(1, "Mario Rossi", "mario.rossi@example.com");
        when(utenteDAO.findById(1)).thenReturn(Optional.of(utente));

        assertEquals(utente, utenteService.trovaUtente(1));
        verify(utenteDAO).findById(1);
    }

    @Test
    void testTrovaUtenteNonEsistente() {
        when(utenteDAO.findById(1)).thenReturn(Optional.empty());

        assertNull(utenteService.trovaUtente(1));
        verify(utenteDAO).findById(1);
    }

    @Test
    void testTuttiGliUtenti() {
        when(utenteDAO.findAll()).thenReturn(new ArrayList<>());

        assertNotNull(utenteService.tuttiGliUtenti());
        verify(utenteDAO).findAll();
    }


    @Test
    void testEliminaUtente() {
        when(utenteDAO.delete(1)).thenReturn(true);

        assertTrue(utenteService.eliminaUtente(1));
        verify(utenteDAO).delete(1);
    }
}
