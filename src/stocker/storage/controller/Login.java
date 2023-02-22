package stocker.storage.controller;

import stocker.storage.model.DataBase;

public class Login {
    public static void login(String name, String email, String password) {
        System.out.println(name + email + password + new DataBase().getDato());
    }
}