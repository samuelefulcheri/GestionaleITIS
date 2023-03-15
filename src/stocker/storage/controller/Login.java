package stocker.storage.controller;
import stocker.storage.model.DataBase;
import stocker.storage.model.objects.StorageAccount;

public class Login {
    public static void login(String name, String email, String password) {
        System.out.println(new DataBase().getDato());
        System.out.println(new StorageAccount(1, name, email, password, "admin"));
    }
}