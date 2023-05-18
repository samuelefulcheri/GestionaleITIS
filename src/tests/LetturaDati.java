package tests;

import stocker.storage.model.DataBase;
import stocker.storage.model.objects.DBTables;

import java.sql.SQLException;

public class LetturaDati {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        var db = new DataBase();
        var res = db.read(DBTables.SHELF);
        while(res.next()){
            System.out.println(res.getInt("shelfId"));
        }


        db.closeConnection();
    }
}
