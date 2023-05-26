package tests;
import stocker.storage.model.DataBase;
import stocker.storage.model.objects.*;
import java.sql.SQLException;

public class Tests {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        var db = new DataBase();

        System.out.println(db.readAllProducts());
        System.out.println();
        System.out.println(db.readAllShelves());
        System.out.println();
        System.out.println(db.readAllAccounts());

        System.out.println();
        System.out.println();

        System.out.println(db.read(StorageObject.createFromId(1)));
        System.out.println();
        System.out.println(db.read(StorageShelf.createFromId(0)));
        System.out.println();
        System.out.println(db.read(StorageAccount.createFromId(1)));

        var obj = new StorageObject(15, null, "tarli", 1, 1, StorageObjectType.IMPORT);
        var shelf = new StorageShelf(1, 5, 5);
        var account = new StorageAccount(4, "Emanuela", "emanu@gmail.com", "12345678", AccountRanks.EMPLOYEE);

        db.create(obj);
        db.create(shelf);
        db.create(account);

        db.update(obj);
        db.update(shelf);
        db.update(account);

        db.delete(obj);
        db.delete(shelf);
        db.delete(account);

        db.closeConnection();
    }
}