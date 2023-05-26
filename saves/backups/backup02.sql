BEGIN TRANSACTION;

INSERT INTO SHELF VALUES(1, 6, 8);

INSERT INTO ACCOUNT VALUES(1, 'Samuele Fulcheri', 'samuele.fulcheri@gmail.com', '12345678', 'administrator');
INSERT INTO ACCOUNT VALUES(2, 'Theodor Giannini', 'theodor.giannini@gmail.com', 'Theodor420', 'employee');
INSERT INTO ACCOUNT VALUES(4, 'prova', 'prova@gmail.com', 'provaprova', 'employee');

INSERT INTO PRODUCT VALUES(0, NULL, 'penne', 1, 1, 'import');
INSERT INTO PRODUCT VALUES(1, NULL, 'gessetti', 1, 1, 'import');
INSERT INTO PRODUCT VALUES(2, NULL, 'lavagne', 3, 2, 'import');
INSERT INTO PRODUCT VALUES(3, NULL, 'sedie', 2, 2, 'import');
INSERT INTO PRODUCT VALUES(4, NULL, 'computer', 2, 1, 'import');
INSERT INTO PRODUCT VALUES(5, NULL, 'banchi', 2, 2, 'import');
INSERT INTO PRODUCT VALUES(6, NULL, 'lim', 3, 3, 'import');
INSERT INTO PRODUCT VALUES(7, NULL, 'tastiere', 2, 1, 'import');
INSERT INTO PRODUCT VALUES(8, NULL, 'mouse', 1, 1, 'import');
INSERT INTO PRODUCT VALUES(9, NULL, 'pennarelli', 1, 1, 'import');
INSERT INTO PRODUCT VALUES(10, NULL, 'microfoni', 1, 2, 'import');
INSERT INTO PRODUCT VALUES(11, NULL, 'telecamere', 1, 1, 'import');

COMMIT;