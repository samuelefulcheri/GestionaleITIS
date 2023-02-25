package stocker.storage.model;

public class Funzioni {
    public void display() {
        System.out.println("qualcosa");
    }

    public void mostra() {
        System.out.println("qualcosa");
    }

    public void aggiungi(Dati d) {
        System.out.println(d);
        display();
        mostra();
        modifica(1);
        elimina(1);
    }

    public void modifica(int id) {
        System.out.println(id);
    }

    public void elimina(int id) {
        System.out.println(id);
    }
}