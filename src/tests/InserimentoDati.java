package tests;

import stocker.storage.model.DataBase;
import stocker.storage.model.objects.StorageShelf;

import java.sql.SQLException;

public class InserimentoDati {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        var db = new DataBase();
        var obj = new StorageShelf(0, 8, 14);
        db.create(obj);
    }
}
