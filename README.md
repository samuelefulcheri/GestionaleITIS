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

## Storico delle variazioni
| Versione       | Data emissione   | Parte modificata    |
|----------------|------------------|---------------------|
| First   commit | 19 gennaio 2023  | Creazione documento |
| Second  commit | 02 febbraio 2023 | Intero Progetto     |
| Third   commit | 09 febbraio 2023 | Intero Progetto     |
| Fourth  commit | 16 febbraio 2023 | Intero Progetto     |
| Fifth   commit | 23 febbraio 2023 | Intero Progetto     |
| Sixth   commit | 02 marzo 2023    | Intero Progetto     |
| Seventh commit | 09 marzo 2023    | Intero Progetto     |
| Eight   commit | 23 marzo 2023    | Intero Progetto     |
| Ninth   commit | 30 marzo 2023    | Intero Progetto     |


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
adattata anche in altri.


# SEZIONE 2 - Riferimenti

## CAPITOLO 2.1 - Definizione

### Java:
Java è un linguaggio di programmazione ad alto livello orientato a oggetti.
È stato creato da Sun Microsystems (ora parte di Oracle) e rilasciato per la prima
volta nel 1995. Java è noto per la sua portabilità, sicurezza e affidabilità, il
che significa che il codice (bytecode) può essere eseguito su diverse piattaforme
senza la necessità di modifiche sostanziali. Viene ampiamente utilizzato per lo
sviluppo di applicazioni web, desktop e mobile, così come per la creazione di
applet e servizi web. Una caratteristica fondamentale è la sua capacità di gestire
la memoria automaticamente attraverso il meccanismo del garbage collection.
Java ha una vasta scelta di librerie standard che offrono un'ampia gamma di
funzionalità, come la gestione di file, la connessione a database, la
crittografia, l'elaborazione delle stringhe, la gestione delle date e
l'interazione con le reti.

### JDBC:
JDBC è una API di Java che consente alle applicazioni di interagire con i
database relazionali. Essa fornisce un insieme di classi e metodi per eseguire
operazioni di interrogazione, aggiornamento e gestione dei dati memorizzati,
utilizzando il linguaggio SQL. JDBC fornisce anche la possibilità di connettersi a
diversi tipi di database utilizzando driver specifici.

### SQL:
SQL è un linguaggio di programmazione utilizzato per gestire e manipolare i dati
in un database relazionale. Consente di creare, modificare ed eliminare tabelle
e dati all'interno di esso, oltre a effettuare ricerche, filtrare e ordinare
i dati. SQL è ampiamente utilizzato per l'interazione con i database in diversi
campi, tra cui il business, la finanza, la scienza dei dati e molti altri.

### SQLite:
SQLite è un DBMS relazionale leggero, open source e incorporabile. È progettato
per essere veloce, efficiente, affidabile e facile da usare. È uno dei database
più utilizzati al mondo, poiché è ampiamente utilizzato in dispositivi mobili,
applicazioni desktop, browser web e molto altro. Inoltre, non richiede un server
separato e funziona su una vasta gamma di piattaforme e sistemi operativi.

### JetBrains:
JetBrains è un'azienda di software che produce una vasta gamma di strumenti per il
developing, tra cui l'IDE multi-linguaggio IntelliJ IDEA. La compagnia è stata
fondata nel 2000 e ha sede a Praga, in Repubblica Ceca. Oltre a IntelliJ,
JetBrains ha prodotto altri strumenti di sviluppo popolari come PyCharm,
WebStorm, RubyMine e PHPStorm.

### IntelliJ IDEA:
IntelliJ IDEA è un IDE multi-linguaggio sviluppato da JetBrains. È stato
progettato per migliorare la produttività, fornendo strumenti avanzati per il
debugging, la gestione dei progetti, il refactoring del codice, il testing e molto
altro ancora. IntelliJ supporta diversi linguaggi di programmazione, tra cui Java,
Kotlin, Android, Scala, Groovy, e può essere esteso con plugin per supportarne
altri. IntelliJ è disponibile in una versione gratuita (Community Edition) e una a
pagamento (Ultimate Edition) con funzionalità aggiuntive per lo sviluppo di
progetti enterprise.

### Git:
Git è un sistema di controllo versione distribuito, utilizzato per il versioning
del codice sorgente. È stato sviluppato da Linus Torvalds nel 2005 per la gestione
del kernel Linux. Con Git, gli utenti possono tenere traccia delle modifiche
apportate al proprio codice sorgente, creare branch per lo sviluppo di nuove
funzionalità, combinare le modifiche da diversi branch e repository tramite il
processo di merge e molto altro. Git consente una gestione del codice sorgente
decentralizzata, in cui ogni utente ha una copia completa del repository, evitando
così la necessità di una connessione costante al server centrale. È uno
strumento molto popolare tra gli sviluppatori software per il controllo di
versione del codice sorgente, ed è integrato in molte piattaforme come GitHub,
GitLab e Bitbucket.

### GitHub:
GitHub è una piattaforma web che permette la condivisione e la collaborazione di
progetti software utilizzando il sistema di controllo versione Git. Gli utenti
possono creare repository per il loro codice sorgente, tenere traccia delle
modifiche apportate nel tempo, collaborare con altri utenti tramite il processo di
pull request e utilizzare una vasta gamma di strumenti per la gestione del
progetto come il problem tracking e la documentazione. GitHub è uno strumento molto
utilizzato dagli sviluppatori software e dalle comunità di programmatori open
source.


## CAPITOLO 2.2 - Acronimi

**SQL:** Structured Query Language  
**JDBC:** Java DataBase Connectivity  
**API:** Application Programming Interface  
**DBMS:** DataBase Management System  
**IDE:** Integrated Development Environment


# SEZIONE 3 - Analisi dei requisiti
Questa applicazione nasce con lo scopo di risolvere il problema della gestione in modo
efficiente di un magazzino scolastico. Ci sono molte attività che devono essere
svolte come la gestione delle forniture, l'inventario e la distribuzione degli
articoli. Tutto questo richiede molta attenzione e tempo, quindi un sistema
automatizzato sarebbe utile per semplificare questi processi.

## Stakeholder:
Gli stakeholder per questo progetto includono:

- **La scuola stessa:** è l'entità principale che avrà bisogno del sistema gestionale
  per lo svolgimento delle attività del magazzino.
- **Gli insegnanti:** avranno bisogno di accesso ai materiali del magazzino per le
  loro lezioni.
- **Gli studenti:** avranno bisogno di accesso ai materiali del magazzino per le loro
  attività scolastiche.
- **Personale ATA:** saranno responsabili della gestione fisica del
  magazzino e dell'inventario.
- **I fornitori:** potrebbero dover interagire con il sistema gestionale per la
  fornitura di materiali.

## Problemi:
Ci sono diversi problemi che potrebbero essere riscontrati nella gestione del
magazzino della scuola. Alcuni di questi includono:

- **Disorganizzazione:** se il magazzino non è ben organizzato, può essere difficile
  tenere traccia di ciò che è disponibile e quando.
- **Scarsità di materiali:** se gli articoli richiesti dagli insegnanti o dagli
  studenti non sono disponibili nel magazzino, ciò può causare problemi durante le
  lezioni o le attività.
- **Inefficienza:** se i processi manuali sono utilizzati per la gestione del
  magazzino, questo può essere inefficiente e richiedere molto tempo.
- **Errori:** se la gestione del magazzino non viene effettuata con attenzione, possono
  verificarsi errori nell'inventario e nella distribuzione dei materiali.

## Vincoli:
Ci sono alcuni vincoli che potrebbero influire sulla realizzazione del sistema
gestionale per il magazzino della scuola. Alcuni di questi includono:

- **Budget:** il sistema gestionale deve essere realizzato entro un determinato budget per
  garantire che sia sostenibile e conveniente per la scuola.
- **Risorse disponibili:** la scuola potrebbe non avere tutte le risorse necessarie per
  sviluppare e implementare il sistema gestionale in modo autonomo.
- **Esigenze degli utenti:** il sistema gestionale deve essere progettato tenendo conto
  delle esigenze degli utenti, come gli insegnanti, gli studenti e il personale ATA.

## Altri fattori:
Ci sono anche altri fattori che potrebbero influire sulla realizzazione del sistema
gestionale per il magazzino della scuola. Alcuni di questi includono:

- **Sicurezza:** il sistema gestionale deve essere protetto da eventuali minacce alla
  sicurezza per proteggere i dati degli utenti e le informazioni sul magazzino. 
- **Facilità d'uso:** il sistema gestionale deve essere facile da usare per gli utenti e
  non richiedere alcuna formazione avanzata per l'utilizzo.
- **Scalabilità:** il sistema gestionale deve essere in grado di gestire un grande volume
  di dati e di utenti in modo affidabile e senza problemi.
- **Integrazione:** il sistema gestionale dovrebbe essere in grado di integrarsi con altri
  sistemi scolastici o software, come i sistemi di gestione delle classi o dei corsi.

## Requisiti funzionali:
Sulla base di quanto sopra, i seguenti requisiti funzionali dovrebbero essere inclusi
nel sistema gestionale per il magazzino della scuola:

- **Gestione dell'inventario:** il sistema dovrebbe consentire la gestione accurata
  dell'inventario del magazzino, incluso il monitoraggio dei livelli di scorte e
  l'aggiornamento dell'inventario quando gli articoli vengono aggiunti o rimossi dal
  magazzino.
- **Gestione degli ordini:** il sistema dovrebbe consentire agli insegnanti e al personale
  di magazzino di effettuare ordini per gli articoli necessari per le lezioni o le
  attività scolastiche.
- **Distribuzione degli articoli:** il sistema dovrebbe automatizzare la distribuzione
  degli articoli agli insegnanti o agli studenti che ne hanno bisogno, con un
  meccanismo di prenotazione e/o di assegnazione.
- **Generazione di report:** il sistema dovrebbe generare report sull'inventario e sugli
  ordini in modo che il personale ATA possa monitorare l'utilizzo degli
  articoli e pianificare le forniture future.
- **Sicurezza:** il sistema dovrebbe essere protetto da accessi non autorizzati tramite
  l'utilizzo di credenziali di accesso sicure e di un sistema di autorizzazioni
  appropriato.

## Requisiti non funzionali:
I seguenti requisiti non funzionali dovrebbero essere inclusi nel sistema gestionale
per il magazzino della scuola:

- **Usabilità:** il sistema dovrebbe essere facile da usare e intuitivo per gli utenti senza
  alcuna formazione avanzata.
- **Affidabilità:** il sistema dovrebbe funzionare in modo affidabile senza alcun arresto o
  malfunzionamento.
- **Scalabilità:** il sistema dovrebbe essere in grado di gestire grandi quantità di dati e
  di utenti senza compromettere le prestazioni.
- **Integrazione:** il sistema dovrebbe essere in grado di integrarsi con altri sistemi
  scolastici o software.
- **Sicurezza:** il sistema dovrebbe essere protetto da eventuali minacce alla sicurezza e
  garantire la protezione dei dati degli utenti.

## Conclusioni:
In conclusione, per la realizzazione di un gestionale per il magazzino di una scuola, è
importante considerare i bisogni degli stakeholder, i problemi, i vincoli e i requisiti
funzionali e non funzionali. È essenziale sviluppare un sistema gestionale efficace ed
efficiente che possa semplificare e automatizzare le attività del magazzino, migliorando
la gestione degli articoli e garantendo la massima efficienza possibile.


# SEZIONE 4 - Fornitura
L'analisi di fornitura si concentra sulla definizione delle attività che devono essere
svolte per la realizzazione del sistema gestionale del magazzino della scuola, nonché
sui requisiti di fornitura che il team di sviluppo deve soddisfare per completare il
progetto.

### Modellazione del problema:
Il problema da affrontare è la gestione del magazzino della scuola, che richiede la
capacità di tenere traccia degli articoli, gestire gli ordini, gestire la distribuzione
degli articoli agli insegnanti e agli studenti e generare report sull'inventario e sugli
ordini.

### Soluzione proposta:
La soluzione proposta è un sistema gestionale del magazzino basato su un'applicazione
Java, che consente di tenere traccia dell'inventario, gestire gli ordini, gestire la
distribuzione degli articoli e generare report sull'inventario e sugli ordini. Il
sistema deve essere facile da usare e dotato di un'interfaccia utente intuitiva.
Inoltre, il sistema deve essere scalabile, sicuro e in grado di integrarsi con altri
sistemi scolastici o software.

### Cosa si vuole fare:
Il team di sviluppo deve creare un'applicazione che permetta la gestione del
magazzino della scuola. Questo include lo sviluppo del software, la progettazione
dell'interfaccia utente, l'implementazione del sistema di gestione dell'inventario,
dell'ordine e della distribuzione degli articoli e la generazione di report
sull'inventario e sugli ordini.

### Cosa non si vuole fare:
Il team di sviluppo non deve fornire hardware o server per il sistema gestionale.
Inoltre, non devono essere forniti servizi di formazione per l'utilizzo del sistema.

### Obiettivi minimi del progetto:
Gli obiettivi minimi del progetto includono la creazione di un sistema gestionale
funzionante che consente di gestire l'inventario del magazzino, gli ordini, la
distribuzione degli articoli e la generazione di report sull'inventario e sugli
ordini. Il sistema deve essere facile da usare, sicuro e scalabile, con l'obiettivo di
semplificare la gestione del magazzino della scuola.

### Livello di finitura/qualità:
Il livello di finitura/qualità deve essere alto, in quanto il sistema gestionale del
magazzino della scuola è un componente critico.
Il sistema deve essere affidabile, sicuro e facile da usare, in modo da garantire la
massima efficienza possibile e migliorare la gestione degli articoli.
Inoltre, deve essere in grado di integrarsi con altri sistemi scolastici o
software, al fine di semplificare ulteriormente la gestione.

#### Requisiti di fornitura:
Il team di sviluppo dovrà soddisfare i seguenti requisiti di fornitura per la
realizzazione del sistema gestionale del magazzino della scuola:

- Il software deve essere sviluppato utilizzando tecnologie Java e SQL.
- Il software deve essere raggiungibile attraverso un'interfaccia desktop, accessibile da
  qualsiasi dispositivo con una connessione internet.
- Il sistema deve essere sicuro e proteggere i dati dell'inventario, degli ordini e
  degli utenti.
- Il sistema deve essere testato per garantire la sua funzionalità e la conformità ai
  requisiti di fornitura.
- Il sistema deve essere documentato in modo dettagliato per consentire una facile
  manutenzione e supporto post-implementazione.

### Problemi e Vincoli:
I problemi che il team di sviluppo potrebbe incontrare includono la complessità della
gestione dell'inventario, degli ordini e della distribuzione degli articoli, la
necessità di integrare il sistema con altri software e l'implementazione di
un'interfaccia utente intuitiva.


# SEZIONE 5 - Work Break Down Structure

# Stories e Features
* Creazione GUI: -> 2 -> 43P (tot)
  - Inserimento accesso utente -> 5 -> 2P
  - Inserimento caselle campi -> 8 -> 2P
  - Pulsanti di accesso -> 13 -> 2P
  - Schermata di benvenuto -> 40 -> 5P
  - Grafica per l'engine -> 2 -> 20P
  - Gestione dei problemi -> 3 -> 5P
  - Barra delle notifiche -> 20 -> 5P
  - Logo -> 100 -> 2P
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