PRAGMA foreign_keys = ON;

BEGIN TRANSACTION;

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
INSERT INTO ACCOUNT VALUES(1,'Samuele Fulcheri','samuele.fulcheri@gmail.com','12345678','administrator');
INSERT INTO ACCOUNT VALUES(2,'Theodor Giannini','theodor.giannini@gmail.com','Theodor420','employee');
INSERT INTO ACCOUNT VALUES(4,'prova','prova@gmail.com','provaprova','employee');
CREATE TABLE PRODUCT (

                         productId INTEGER PRIMARY KEY AUTOINCREMENT,

                         productContentId INTEGER,

                         contentDescription TEXT,

                         productHeight INTEGER,

                         productWidth INTEGER,

                         productType TEXT,

                         FOREIGN KEY (productContentId) REFERENCES PRODUCT(productId)

);
INSERT INTO PRODUCT VALUES(0,NULL,'penne',1,1,'import');
INSERT INTO PRODUCT VALUES(1,NULL,'gessetti',1,1,'import');
INSERT INTO PRODUCT VALUES(2,NULL,'lavagne',3,2,'import');
INSERT INTO PRODUCT VALUES(3,NULL,'sedie',2,2,'import');
INSERT INTO PRODUCT VALUES(4,NULL,'computer',2,1,'import');
INSERT INTO PRODUCT VALUES(5,NULL,'banchi',2,2,'import');
INSERT INTO PRODUCT VALUES(6,NULL,'lim',3,3,'import');
INSERT INTO PRODUCT VALUES(7,NULL,'tastiere',2,1,'import');
INSERT INTO PRODUCT VALUES(8,NULL,'mouse',1,1,'import');
INSERT INTO PRODUCT VALUES(9,NULL,'pennarelli',1,1,'import');
INSERT INTO PRODUCT VALUES(10,NULL,'microfoni',1,2,'import');
INSERT INTO PRODUCT VALUES(11,NULL,'telecamere',1,1,'import');

COMMIT;