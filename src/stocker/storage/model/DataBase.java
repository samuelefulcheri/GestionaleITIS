package stocker.storage.model;
import org.jetbrains.annotations.NotNull;
import stocker.storage.model.objects.DBTables;
import stocker.storage.model.objects.StorageAccount;
import stocker.storage.model.objects.StorageObject;
import stocker.storage.model.objects.StorageShelf;
import java.sql.*;

public class DataBase {
    private final Connection conn;

    public DataBase() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:saves\\GestionaleITIS.db");
    }

    public void create(@NotNull StorageObject object) throws SQLException {
        var sql = "INSERT INTO PRODUCT (productContent, contentDescription, productHeight, productWidth, productType) VALUES (?, ?, ?, ?, ?)";
        var stmt = conn.prepareStatement(sql);
        stmt.setInt(1, object.content().id());
        stmt.setString(2, object.contentDescription());
        stmt.setInt(3, object.sizeX());
        stmt.setInt(3, object.sizeY());
        stmt.setString(5, object.type().toString());
        stmt.executeUpdate();
    }

    public void create(@NotNull StorageShelf shelf) throws SQLException {
        var sql1 = "INSERT INTO SHELF (shelfHeight, shelfWidth) VALUES (?, ?)";
        var stmt1 = conn.prepareStatement(sql1);
        stmt1.setInt(1, shelf.getSizeX());
        stmt1.setInt(2, shelf.getSizeY());
        stmt1.executeUpdate();

        var content = shelf.getContent();
        for(var object: content) {
            create(object);

            var sql2 = "INSERT INTO SHELF_CONTENT (shelfId, productId) VALUES (?, ?)";
            var stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1, shelf.getId());
            stmt2.setInt(2, object.id());
            stmt2.executeUpdate();
        }
    }

    public void create(@NotNull StorageAccount account) throws SQLException {
        var sql = "INSERT INTO ACCOUNT (accountName, accountEmail, accountPassword, rank) VALUES (?, ?, ?, ?)";
        var stmt = conn.prepareStatement(sql);
        stmt.setString(1, account.name());
        stmt.setString(2, account.email());
        stmt.setString(3, account.password());
        stmt.setString(4, account.rank().toString());
        stmt.executeUpdate();
    }

    public ResultSet read(DBTables tableName) throws SQLException {
        var sql = "SELECT * FROM " + tableName;
        var stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public ResultSet read(String email, String password) throws SQLException {
        var sql = "SELECT * FROM ACCOUNT WHERE accountEmail = '" + email + "' AND accountPassword = '" + password + "'";
        var stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public void update(@NotNull StorageObject object) throws SQLException {
        var sql = "UPDATE PRODUCT SET productContent = ?, contentDescription = ?, productHeight = ?, productWidth = ?, productType = ? WHERE productId = ?";
        var stmt = conn.prepareStatement(sql);
        stmt.setInt(1, object.content().id());
        stmt.setString(2, object.contentDescription());
        stmt.setInt(3, object.sizeX());
        stmt.setInt(3, object.sizeY());
        stmt.setString(5, object.type().toString());
        stmt.executeUpdate();
    }

    public void update(@NotNull StorageShelf shelf) throws SQLException {
        var sql1 = "UPDATE SHELF SET shelfHeight = ?, shelfWidth = ? WHERE shelfId = ?";
        var stmt1 = conn.prepareStatement(sql1);
        stmt1.setInt(1, shelf.getSizeX());
        stmt1.setInt(2, shelf.getSizeY());
        stmt1.setInt(3, shelf.getId());
        stmt1.executeUpdate();

        var content = shelf.getContent();
        for(var object: content) {
            update(object);

            var sql2 = "UPDATE SHELF_CONTENT SET productId = ? WHERE shelfId = ?";
            var stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1, object.id());
            stmt2.setInt(2, shelf.getId());
            stmt2.executeUpdate();
        }
    }

    public void delete(@NotNull DBTables table, int id) throws SQLException {
        if(table == DBTables.SHELF_CONTENT) return;

        @SuppressWarnings("SqlResolve")
        var sql = "DELETE FROM " + table + " WHERE " + table.toString().toLowerCase() + "Id = ?";

        var stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}