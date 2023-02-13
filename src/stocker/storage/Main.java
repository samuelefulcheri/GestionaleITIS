package stocker.storage;
import stocker.storage.view.Windows;

public class Main {
    public static Windows windows;

    public static void main(String[] args) {
        windows = new Windows(); // Grafica
        windows.welcomePage();
    }
}