package stocker.storage.model;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;

import stocker.storage.model.objects.StorageObject;

public class DataBase {
    public StorageObject getDato() {
        return new StorageObject(1, 1, "penna") { };
    }
}