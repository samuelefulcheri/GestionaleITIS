-- Crea il DataBase

PRAGMA foreign_keys = ON;

CREATE TABLE PRODUCT (
    productId INTEGER PRIMARY KEY AUTOINCREMENT,
    productContentId INTEGER,
    contentDescription TEXT,
    productHeight INTEGER,
    productWidth INTEGER,
    productType TEXT,
    FOREIGN KEY (productContentId) REFERENCES PRODUCT(productId)
);

CREATE TABLE SHELF (
    shelfId INTEGER PRIMARY KEY AUTOINCREMENT,
    shelfHeight INTEGER,
    shelfWidth INTEGER
);

CREATE TABLE SHELF_CONTENT (
    shelfId INTEGER,
    productId INTEGER,
    PRIMARY KEY (shelfId, productId),
    FOREIGN KEY (shelfId) REFERENCES SHELF(shelfId),
    FOREIGN KEY (productId) REFERENCES PRODUCT(productId)
);

CREATE TABLE ACCOUNT (
    accountId INTEGER PRIMARY KEY AUTOINCREMENT,
    accountName TEXT,
    accountEmail TEXT,
    accountPassword TEXT,
    rank TEXT
);

-- Distrugge il DataBase

DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS SHELF;
DROP TABLE IF EXISTS SHELF_CONTENT;
DROP TABLE IF EXISTS ACCOUNT;