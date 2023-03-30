# GESTIONALE ITIS - Stocker Storage
### Progetto GPOI

## Responsabilità
| Funzione        | Nome                   | Data             |
|-----------------|------------------------|------------------|
| Inizio progetto | Simone Giletta         | 19 gennaio 2023  |  
|                 | Theodor Giannini       | 19 gennaio 2023  |  
|                 | Konstantinos Moldovanu | 19 gennaio 2023  |  
|                 | Giacomo Gonella        | 19 gennaio 2023  |  
|                 | Samuele Fulcheri       | 19 gennaio 2023  |

# Storico delle variazioni
| Versione | Data emissione   | Parte modificata    |
|----------|------------------|---------------------|
| Bozza    | 19 gennaio 2023  | Creazione documento |
| Bozza(2) | 02 febbraio 2023 | Responsabilità      |

# Sommario
# 1 - Scopo e campo dell'applicazione
## &nbsp;&nbsp;&nbsp; 1.1 - Scopo
## &nbsp;&nbsp;&nbsp; 1.2 - Campi dell'applicazione
# 2 - Riferimenti
## &nbsp;&nbsp;&nbsp; 2.1 - Definizione
## &nbsp;&nbsp;&nbsp; 2.2 - Acronimi
# 3 - Analisi dei requisiti
# 4 - Fornitura
# 5 - Work Break Down Structure
# 6 - Stima delle risorse
# 7 - Earned Value e Burn Down Chart
## &nbsp;&nbsp;&nbsp; 7.1 - Earned Value
## &nbsp;&nbsp;&nbsp; 7.2 - Burn Down Chart


# SEZIONE 1: Scopo e campo dell'applicazione
## CAPITOLO 1.1 - Scopo
L'applicazione 'Stocker Storage' si occupa di gestire un magazzino di una scuola.
Raccoglie quindi i dati dei prodotti e li inserisce all'interno del suo DataBase.
Può quindi facilmente gestire prodotti in entrata e in uscita.  
Il tutto con una semplice grafica a portata di tutti.

## CAPITOLO 1.2 - Campi dell'applicazione
L'applicazione 'Stocker Storage' può quindi essere utilizzata in qualsiasi contesto
di magazzini, preferibilmente quello di una scuola, ma può essere semplicemente
adattato anche in altri.


# SEZIONE 2 - Riferimenti
## CAPITOLO 2.1 - Definizione

## CAPITOLO 2.2 - Acronimi

# SEZIONE 3 - Analisi dei requisiti
# SEZIONE 4 - Fornitura
# SEZIONE 5 - Work Break Down Structure
# SEZIONE 6 - Stima delle risorse
# SEZIONE 7 - Earned Value e Burn Down Chart
## CAPITOLO 7.1 - Earned Value
## CAPITOLO 7.2 - Burn Down Chart

# Librerie e API utilizzate
* Linguaggio: [Java](https://www.oracle.com/java/technologies/)
* DataBase: [SQLite](https://www.sqlite.org/index.html)
* Librerie:
  - [JDBC](https://www.oracle.com/it/database/technologies/appdev/jdbc-downloads.html);
  - [SQLite](https://github.com/xerial/sqlite-jdbc)
  - [JetBrains Annotations](https://github.com/JetBrains/java-annotations).

# Strumenti utilizzati
* [IntelliJ IDEA](https://www.jetbrains.com/idea/) di [JetBrains](https://www.jetbrains.com/)
* [GitHub](https://github.com/)
* [JavaDoc](https://docs.oracle.com/en/java/)

# Stories e Features
* Creazione GUI: -> 2 -> 41P (tot)
  - Inserimento accesso utente -> 8 -> 2P
  - Inserimento caselle campi -> 13 -> 2P
  - Pulsanti di accesso -> 20 -> 2P
  - Schermata di benvenuto -> 100 -> 5P
  - Grafica per l'engine -> 3 -> 20P
  - Gestione dei problemi -> 5 -> 5P
  - Barra delle notifiche -> 40 -> 5P
* DataBase: -> 0 -> 30P (tot)
  - Creazione di un DataBase -> 0 -> 2P
  - Creazione tabelle in entrata, in uscita e stock -> 13 -> 5P
  - Gestione CRUD dei dati -> 20 -> 3P
  - Inserimento dati -> 40 -> 20P
* Gestione spazio / Engine: -> 40 -> 61P (tot)
  - Creazione di oggetti (scaffale, prodotti) -> 0 -> 20P
  - Creazione di metodi e proprietà degli oggetti -> 3 -> 13P
  - Generazione di errori e notifiche per i vari casi -> 40 -> 8P
  - Aggiunta Socket -> 100 -> 20P