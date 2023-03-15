package stocker.storage;
import stocker.storage.model.objects.StorageObject;
import stocker.storage.model.objects.StorageShelf;
import stocker.storage.view.Windows;
import java.util.ArrayList;

public class Main {
    public static Windows windows;

    public static void main(String[] args) {
        // Grafica

        windows = new Windows();
        windows.welcomePage();


        // Prova dati

        String nome = "penne";
        StorageObject ogg = new StorageObject(1, nome, 2, 3);
        StorageShelf shelf = new StorageShelf(1, 5, 5);

        if(shelf.addObject(ogg)) {
            ArrayList<StorageObject> oggetti = shelf.getObjects(nome);
            System.out.println("Shelf id: " + shelf.getId() + "; size: " + shelf.getSizeX() + "x" + shelf.getSizeY());

            int iter = 1;
            for(StorageObject obj : oggetti) {
                System.out.println(iter + ") " + obj.content());
                iter++;
            }

            boolean[][] shelfMatrix = shelf.getShelf();
            for(boolean[] i: shelfMatrix) {
                for(boolean j: i) {
                    if(j) System.out.print("o");
                    else System.out.print("x");
                    System.out.print(" ");
                } System.out.println();
            }
        }else System.out.println("Non c'è più spazio");
    }
}