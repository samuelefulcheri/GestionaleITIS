package stocker.storage.model;
import org.jetbrains.annotations.NotNull;
import stocker.storage.model.objects.DBTables;
import stocker.storage.model.objects.StorageAccount;
import stocker.storage.model.objects.StorageObject;
import stocker.storage.model.objects.StorageShelf;
import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    private final Connection conn;

    public DataBase() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:gestionaleITIS.db");
    }

    public void create(@NotNull StorageObject object) throws SQLException {
        String sql = "INSERT INTO PRODUCT (productId, productContent, productHeight, productWidth, productType) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, object.id());
        stmt.setString(2, object.content());
        stmt.setInt(3, object.sizeX());
        stmt.setInt(4, object.sizeY());
        stmt.setString(5, object.type().toString());
        stmt.executeUpdate();
    }

    public void create(@NotNull StorageShelf shelf) throws SQLException {
        String sql1 = "INSERT INTO SHELF (shelfId, shelfHeight, shelfWidth) VALUES (?, ?, ?)";
        PreparedStatement stmt1 = conn.prepareStatement(sql1);
        stmt1.setInt(1, shelf.getId());
        stmt1.setInt(2, shelf.getSizeX());
        stmt1.setInt(3, shelf.getSizeY());
        stmt1.executeUpdate();

        ArrayList<StorageObject> content = shelf.getContent();
        for(StorageObject object: content) {
            create(object);

            String sql2 = "INSERT INTO SHELF_CONTENT (shelfId, productId) VALUES (?, ?)";
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1, shelf.getId());
            stmt2.setInt(2, object.id());
            stmt2.executeUpdate();
        }
    }

    public void create(@NotNull StorageAccount account) throws SQLException {
        String sql = "INSERT INTO ACCOUNT (accountId, accountName, accountEmail, accountPassword, rank) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, account.id());
        stmt.setString(2, account.name());
        stmt.setString(3, account.email());
        stmt.setString(4, account.password());
        stmt.setString(4, account.rank().toString());
        stmt.executeUpdate();
    }

    public ResultSet read(DBTables tableName) throws SQLException {
        String sql = "SELECT * FROM " + tableName;
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public void update(@NotNull StorageObject object) throws SQLException {
        String sql = "UPDATE PRODUCT SET productContent = ?, productHeight = ?, productWidth = ?, productType = ? WHERE productId = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, object.content());
        stmt.setInt(2, object.sizeY());
        stmt.setInt(3, object.sizeX());
        stmt.setString(4, object.type().toString());
        stmt.setInt(5, object.id());
        stmt.executeUpdate();
    }

    public void update(@NotNull StorageShelf shelf) throws SQLException {
        String sql1 = "UPDATE SHELF SET shelfHeight = ?, shelfWidth = ? WHERE shelfId = ?";
        PreparedStatement stmt1 = conn.prepareStatement(sql1);
        stmt1.setInt(1, shelf.getSizeX());
        stmt1.setInt(2, shelf.getSizeY());
        stmt1.setInt(3, shelf.getId());
        stmt1.executeUpdate();

        ArrayList<StorageObject> content = shelf.getContent();
        for(StorageObject object: content) {
            update(object);

            String sql2 = "UPDATE SHELF_CONTENT SET productId = ? WHERE shelfId = ?";
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1, object.id());
            stmt2.setInt(2, shelf.getId());
            stmt2.executeUpdate();
        }
    }

    public void delete(@NotNull DBTables table, int id) throws SQLException {
        if(table == DBTables.SHELF_CONTENT) return;

        @SuppressWarnings("SqlResolve")
        String sql = "DELETE FROM " + table + " WHERE " + table.toString().toLowerCase() + "Id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}