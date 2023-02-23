package stocker.storage.model;
import java.util.Scanner;

public class MenuScelta {

    public static void main(String[] args) {
        Funzioni f = new Funzioni();
        Dati d = new Dati();

        Scanner input = new Scanner(System.in);

        int opz = 0;

        do {
            menu();

            opz = input.nextInt();

            switch (opz) {
                case 1:
                    System.out.println("Inserisci il codice del prodotto");
                    int codiceProdotto = input.nextInt();

                    System.out.println("Inserisci il nome del prodotto");
                    String nomeProdotto = input.nextLine();

                    System.out.println("Inserisci il peso del prodotto");
                    float peso = input.nextFloat();

                    System.out.println("Inserisci l'altezza del prodotto");
                    float altezzaProdotto = input.nextFloat();

                    System.out.println("Inserisci la lunghezza del prodotto");
                    float lunghezzaProdotto = input.nextFloat();

                    System.out.println("Inserisci la larghezza del prodotto");
                    float larghezzaProdotto = input.nextFloat();

                    System.out.println("Inserisci la casa produttrice del prodotto");
                    String casaProduttrice = input.nextLine();

                    System.out.println("Inserisci l'indirizzo della casa produttrice del prodotto");
                    String indirizzoCasaProduttrice = input.nextLine();

                    System.out.println("Inserisci il codice del corriere che trasporta il prodotto");
                    int identificativoCorriere = input.nextInt();

                    System.out.println("Inserisci la compagnia di trasporti che trasporta il  prodotto");
                    String compagniaTrasporti = input.nextLine();

                    d = new Dati(codiceProdotto, nomeProdotto, peso, altezzaProdotto,
                            lunghezzaProdotto, larghezzaProdotto, casaProduttrice, indirizzoCasaProduttrice,
                            identificativoCorriere, compagniaTrasporti);

                    f.aggiungi(d);

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Inserisci il codice ");
                    break;
            }
        }while(opz != 4);
    }
    public static void menu(){
        System.out.println("MENU'");
        System.out.println("1) Aggiunta prodotto");
        System.out.println("2) Lettura prodotti");
        System.out.println("3) Modifica prodotto");
        System.out.println("4) Elimina prodotto");
        System.out.println("La tua scelta: ");
    }
}
