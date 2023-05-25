package tests;

import stocker.storage.model.DataBase;
import stocker.storage.model.objects.DBTables;

import java.sql.SQLException;

public class LetturaDati {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        var db = new DataBase();
        var res = db.read(DBTables.PRODUCT);
        while(res.next()){
            System.out.print(res.getInt("productId") + " ");
            System.out.println(res.getString("contentDescription"));
        }


        db.closeConnection();
    }
}
