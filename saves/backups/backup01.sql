PRAGMA foreign_keys = OFF;

BEGIN TRANSACTION;

CREATE TABLE PRODUCT(
    productId INTEGER PRIMARY KEY AUTOINCREMENT,
    productContent TEXT,
    productHeight INTEGER,
    productWidth INTEGER,
    productType TEXT
);

INSERT INTO PRODUCT VALUES(0, 'penne', 1, 1, NULL);

CREATE TABLE SHELF(
    shelfId INTEGER PRIMARY KEY AUTOINCREMENT,
    shelfHeight INTEGER,
    shelfWidth INTEGER
);

CREATE TABLE SHELF_CONTENT(
    shelfId INTEGER,
    productId INTEGER,
    PRIMARY KEY (shelfId, productId),
    FOREIGN KEY (shelfId) REFERENCES SHELF(shelfId),
    FOREIGN KEY (productId) REFERENCES PRODUCT(productId)
);

CREATE TABLE ACCOUNT(
    accountId INTEGER PRIMARY KEY AUTOINCREMENT,
    accountName TEXT,
    accountEmail TEXT,
    accountPassword TEXT,
    rank TEXT
);

INSERT INTO ACCOUNT
    VALUES(1, 'Samuele Fulcheri', 'samuele.fulcheri@gmail.com', '12345678', 'administrator');
INSERT INTO ACCOUNT
    VALUES(2, 'Theodor Giannini', 'theodor.giannini@gmail.com', 'Theodor420', 'employee');
INSERT INTO ACCOUNT
    VALUES(4, 'prova', 'prova@gmail.com', 'provaprova', 'employee');

COMMIT;