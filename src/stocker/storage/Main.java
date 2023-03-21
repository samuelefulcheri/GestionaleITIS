package stocker.storage;
import stocker.storage.model.objects.*;
import stocker.storage.view.Windows;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static Windows windows;
    public static StorageAccount currentUser;
    public static String extension = ".ss";
    public static String separator = ";;;";

    public static void main(String[] args) {
        try{
            var input = new Scanner(new File("saves\\user" + extension));
            var line = input.nextLine();
            var splitted = line.split(separator);

            var id = Integer.parseInt(splitted[0]);
            var name = splitted[1];
            var email = splitted[2];
            var password = splitted[3];
            var rank = AccountRanks.getRankFromString(splitted[4]);

            currentUser = new StorageAccount(id, name, email, password, rank);

            input.close();
        }catch(Exception ignored) { }

        // Grafica

        windows = new Windows();
        windows.welcomePage();


        // Prova dati

        var nome = "penne";
        var ogg = new StorageObject(1, nome, 2, 3, StorageObjectType.IMPORT);
        var shelf = new StorageShelf(1, 5, 5);

        if(shelf.addObject(ogg)) {
            var oggetti = shelf.getObjects(nome);
            System.out.println("Shelf id: " + shelf.getId() + "; size: " + shelf.getSizeX() + "x" + shelf.getSizeY());

            var iter = 1;
            for(var obj : oggetti) {
                System.out.println(iter + ") " + obj.content());
                iter++;
            }

            boolean[][] shelfMatrix = shelf.getShelf();
            for(var i: shelfMatrix) {
                for(var j: i) {
                    if(j) System.out.print("o");
                    else System.out.print("x");
                    System.out.print(" ");
                } System.out.println();
            }
        }else System.out.println("Non c'è più spazio");
    }
}