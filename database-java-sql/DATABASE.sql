CREATE DATABASE EsercizioDB;

USE EsercizioDB;

CREATE TABLE Utenti (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(50),
    Cognome VARCHAR(50),
    Email VARCHAR(100)
);

SELECT * FROM Utenti;
