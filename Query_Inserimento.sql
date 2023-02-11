CREATE DATABASE IF NOT EXISTS Stoccaggio;

USE Stoccaggio;

CREATE TABLE IF NOT EXISTS ProdottiEntrata(
	codiceProdotto VARCHAR(20),
	nomeProdotto VARCHAR(20),
	pesoProdotto FLOAT,
	altezzaProdotto FLOAT,
	lunghezzaProdotto FLOAT,
    larghezzaProdotto FLOAT,
	casaProduttrice VARCHAR(20),
	indirizzoCasaProduttrice VARCHAR(20),
	identificativoCorriere VARCHAR(20),
	compagniaTrasporti VARCHAR(20),
	PRIMARY KEY(codiceProdotto)
);

CREATE TABLE IF NOT EXISTS Scaffali(
	codiceScaffale VARCHAR(20),
	altezzaScaffale FLOAT,
	larghezzaScaffale FLOAT,
	lunghezzaScaffale FLOAT,
    codiceProdotto VARCHAR(20),
    PRIMARY KEY (codiceScaffale),
    FOREIGN KEY (codiceProdotto) REFERENCES ProdottiEntrata (codiceProdotto)
);

CREATE TABLE IF NOT EXISTS ProdottiUscita(
	codiceProdotto VARCHAR(20),
	nomeProdotto VARCHAR(20),
	pesoProdotto FLOAT,
	altezzaProdotto FLOAT,
	lunghezzaProdotto FLOAT,
    larghezzaProdotto FLOAT,
    codiceScaffale VARCHAR(20),
	PRIMARY KEY(codiceProdotto),
    FOREIGN KEY(codiceScaffale) REFERENCES Scaffali (codiceScaffale)
);