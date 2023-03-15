package stocker.storage.model;
import stocker.storage.model.objects.StorageObject;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;

public class DataBase {
    public StorageObject getDato() {
        return new StorageObject(1, "penne", 1, 1);
    }


}