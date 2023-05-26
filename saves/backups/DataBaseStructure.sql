PRAGMA foreign_keys = ON;

CREATE TABLE PRODUCT(
    productId INTEGER PRIMARY KEY AUTOINCREMENT,
    productContent BLOB,
    contentDescription TEXT,
    productHeight INTEGER,
    productWidth INTEGER,
    productType TEXT
);

CREATE TABLE SHELF(
    shelfId INTEGER PRIMARY KEY AUTOINCREMENT,
    shelfContent BLOB,
    shelfField BLOB,
    shelfHeight INTEGER,
    shelfWidth INTEGER
);

CREATE TABLE ACCOUNT(
    accountId INTEGER PRIMARY KEY AUTOINCREMENT,
    accountName TEXT,
    accountEmail TEXT,
    accountPassword TEXT,
    rank TEXT
);