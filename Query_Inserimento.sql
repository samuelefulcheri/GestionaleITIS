CREATE DATABASE IF NOT EXISTS PRODOTTI;

USE PRODOTTI;

CREATE TABLE IF NOT EXISTS PRODOTTI_ENTRATA (
    CodiceProdotto INT,
    NomeProdotto VARCHAR(20),
    PesoProdotto INT,
    AltezzaProdotto INT,
    LunghezzaProdotto INT,
    CasaProduttrice VARCHAR(20),
    IndirizzoCasaProduttrice VARCHAR(20),
    IdentificativoCorriere VARCHAR(20),
    CompagniaTrasporti VARCHAR(20),
    PRIMARY KEY(CodiceProdotto)
);

CREATE TABLE IF NOT EXISTS MAGAZZINO (

);

CREATE TABLE IF NOT EXISTS PRODOTTI_USCITA (
    CodiceProdotto INT,
    NomeProdotto VARCHAR(20),
    PesoProdotto INT,
    AltezzaProdotto INT,
    LunghezzaProdotto INT,
    CasaProduttrice VARCHAR(20),
    IndirizzoCasaProduttrice VARCHAR(20),
    IdentificativoCorriere VARCHAR(20),
    CompagniaTrasporti VARCHAR(20),
    PRIMARY KEY(CodiceProdotto)
);