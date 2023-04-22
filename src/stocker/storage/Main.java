package stocker.storage;
import stocker.storage.model.objects.*;
import stocker.storage.view.SSWindow;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static SSWindow window;
    public static StorageAccount currentUser;

    public static final String extension = ".ss";
    public static final String separator = ";;;";

    public static void main(String[] args) {
        // Ricorda i dati di accesso dell'utente
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

        window = new SSWindow();
        window.welcomePage();

        SSWindow.notificationsPage.addNotifications("Notifica di prova.");
    }
}