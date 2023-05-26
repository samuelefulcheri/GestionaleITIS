package stocker.storage.model;
import org.jetbrains.annotations.NotNull;
import stocker.storage.model.objects.*;
import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    private final Connection conn;

    public DataBase() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:saves\\GestionaleITIS.db");
    }

    public void create(StorageObject product) {
        try{
            var stmt = conn.prepareStatement("INSERT INTO PRODUCT (productId, productContent, contentDescription," +
                    "productHeight, productWidth, productType) " + "VALUES (?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, product.id());
            stmt.setObject(2, product.content());
            stmt.setString(3, product.contentDescription());
            stmt.setInt(4, product.sizeX());
            stmt.setInt(5, product.sizeY());
            stmt.setString(6, product.type().toString());

            stmt.executeUpdate();
            stmt.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void create(@NotNull StorageShelf shelf) {
        try{
            var stmt = conn.prepareStatement("INSERT INTO SHELF (shelfId, shelfHeight, shelfWidth, shelfField," +
                    "shelfContent) " + "VALUES (?, ?, ?, ?, ?)");

            stmt.setInt(1, shelf.getId());
            stmt.setInt(2, shelf.getSizeX());
            stmt.setInt(3, shelf.getSizeY());
            stmt.setObject(4, shelf.getShelf());
            stmt.setObject(5, shelf.getContent());

            stmt.executeUpdate();
            stmt.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void create(@NotNull StorageAccount account) {
        try{
            var stmt = conn.prepareStatement("INSERT INTO ACCOUNT (accountName, accountEmail, accountPassword," +
                    "rank)" + "VALUES (?, ?, ?, ?)");

            stmt.setString(1, account.name());
            stmt.setString(2, account.email());
            stmt.setString(3, account.password());
            stmt.setString(4, account.rank().toString());

            stmt.executeUpdate();
            stmt.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<StorageObject> readAllProducts() {
        try{
            var stmt = conn.prepareStatement("SELECT * FROM PRODUCT");
            var res = stmt.executeQuery();

            ArrayList<StorageObject> objects = new ArrayList<>();

            while(res.next()) {
                var productContentUnparsed = res.getObject("productContent");
                if(!StorageObject.isContentParsable(productContentUnparsed)) productContentUnparsed = null;
                var productContent = (productContentUnparsed != null) ?
                        StorageObject.parseContent((ArrayList<?>) productContentUnparsed) : null;

                objects.add(new StorageObject(res.getInt("productId"),
                        productContent,
                        res.getString("contentDescription"),
                        res.getInt("productHeight"),
                        res.getInt("productWidth"),
                        StorageObjectType.valueOf(res.getString("productType").toUpperCase())));
            }

            res.close();
            stmt.close();

            return objects;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<StorageShelf> readAllShelves() {
        try{
            var stmt = conn.prepareStatement("SELECT * FROM SHELF");
            var res = stmt.executeQuery();

            ArrayList<StorageShelf> shelves = new ArrayList<>();

            while(res.next()) {
                var shelfContentUnparsed = res.getObject("shelfContent");
                if(!StorageObject.isContentParsable(shelfContentUnparsed)) shelfContentUnparsed = null;
                var shelfContent = (shelfContentUnparsed != null) ?
                        StorageObject.parseContent((ArrayList<?>) shelfContentUnparsed) : null;

                shelves.add(new StorageShelf(res.getInt("shelfId"),
                        res.getInt("shelfHeight"),
                        res.getInt("shelfWidth"),
                        (boolean[][]) res.getObject("shelfField"),
                        shelfContent));
            }

            res.close();
            stmt.close();

            return shelves;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<StorageAccount> readAllAccounts() {
        try{
            var stmt = conn.prepareStatement("SELECT * FROM ACCOUNT");
            var res = stmt.executeQuery();

            ArrayList<StorageAccount> accounts = new ArrayList<>();

            while(res.next())
                accounts.add(new StorageAccount(res.getInt("accountId"),
                        res.getString("accountName"),
                        res.getString("accountEmail"),
                        res.getString("accountPassword"),
                        AccountRanks.valueOf(res.getString("rank").toUpperCase())));

            stmt.close();
            res.close();

            return accounts;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public StorageObject read(StorageObject product) {
        try{
            var stmt = conn.prepareStatement("SELECT * FROM PRODUCT WHERE productId = ?");
            stmt.setInt(1, product.id());
            var res = stmt.executeQuery();

            if(!res.next()) return null;

            var productContentUnparsed = res.getObject("productContent");
            if(!StorageObject.isContentParsable(productContentUnparsed)) productContentUnparsed = null;
            var productContent = (productContentUnparsed != null) ?
                    StorageObject.parseContent((ArrayList<?>) productContentUnparsed) : null;

            var storageObject = new StorageObject(res.getInt("productId"),
                          productContent,
                          res.getString("contentDescription"),
                          res.getInt("productHeight"),
                          res.getInt("productWidth"),
                          StorageObjectType.valueOf(res.getString("productType").toUpperCase()));

            res.close();
            stmt.close();

            return storageObject;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public StorageShelf read(@NotNull StorageShelf shelf) {
        try{
            var stmt = conn.prepareStatement("SELECT * FROM SHELF WHERE shelfId = ?");
            stmt.setInt(1, shelf.getId());
            var res = stmt.executeQuery();

            if(!res.next()) return null;

            var shelfContentUnparsed = res.getObject("shelfContent");
            if(!StorageObject.isContentParsable(shelfContentUnparsed)) shelfContentUnparsed = null;
            var shelfContent = (shelfContentUnparsed != null) ?
                    StorageObject.parseContent((ArrayList<?>) shelfContentUnparsed) : null;

            var storageShelf = new StorageShelf(res.getInt("shelfId"),
                    res.getInt("shelfHeight"),
                    res.getInt("shelfWidth"),
                    (boolean[][]) res.getObject("shelfField"),
                    shelfContent);

            res.close();
            stmt.close();

            return storageShelf;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public StorageAccount read(StorageAccount account) {
        try{
            var stmt = conn.prepareStatement("SELECT * FROM ACCOUNT WHERE accountId = ?");
            stmt.setInt(1, account.id());
            var res = stmt.executeQuery();

            if(!res.next()) return null;

            var storageAccount = new StorageAccount(res.getInt("accountId"),
                    res.getString("accountName"),
                    res.getString("accountEmail"),
                    res.getString("accountPassword"),
                    AccountRanks.valueOf(res.getString("rank").toUpperCase()));

            stmt.close();
            res.close();

            return storageAccount;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public StorageAccount read(String email, String password) {
        try{
            var stmt = conn.prepareStatement("SELECT * FROM ACCOUNT WHERE accountEmail = ?" +
                    "AND accountPassword = ?");

            stmt.setString(1, email);
            stmt.setString(2, password);

            var res = stmt.executeQuery();

            if(!res.next()) return null;

            var storageAccount = new StorageAccount(res.getInt("accountId"),
                    res.getString("accountName"),
                    res.getString("accountEmail"),
                    res.getString("accountPassword"),
                    AccountRanks.valueOf(res.getString("rank").toUpperCase()));

            stmt.close();
            res.close();

            return storageAccount;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(@NotNull StorageObject product) {
        try{
            var stmt = conn.prepareStatement("UPDATE PRODUCT SET productContent = ?, contentDescription = ?," +
                    "productHeight = ?, productWidth = ?, productType = ? " + "WHERE productId = ?");

            stmt.setObject(1, product.content());
            stmt.setString(2, product.contentDescription());
            stmt.setInt(3, product.sizeX());
            stmt.setInt(4, product.sizeY());
            stmt.setString(5, product.type().toString());
            stmt.setInt(6, product.id());

            stmt.executeUpdate();
            stmt.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void update(@NotNull StorageShelf shelf) {
        try{
            var stmt = conn.prepareStatement("UPDATE SHELF SET shelfHeight = ?, shelfWidth = ?, shelfField = ?," +
                    "shelfContent = ? " + "WHERE shelfId = ?");

            stmt.setInt(1, shelf.getSizeX());
            stmt.setInt(2, shelf.getSizeY());
            stmt.setObject(3, shelf.getShelf());
            stmt.setObject(4, shelf.getContent());
            stmt.setInt(5, shelf.getId());

            stmt.executeUpdate();
            stmt.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void update(@NotNull StorageAccount account) {
        try{
            var stmt = conn.prepareStatement("UPDATE ACCOUNT SET accountName = ?, accountEmail = ?," +
                    "accountPassword = ?," + "rank = ? " + "WHERE accountId = ?");

            stmt.setString(1, account.name());
            stmt.setString(2, account.email());
            stmt.setString(3, account.password());
            stmt.setString(4, account.rank().toString());
            stmt.setInt(5, account.id());

            stmt.executeUpdate();
            stmt.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(StorageObject product) {
        try{
            var stmt = conn.prepareStatement("DELETE FROM PRODUCT WHERE productId = ?");

            stmt.setInt(1, product.id());

            stmt.executeUpdate();
            stmt.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(@NotNull StorageShelf shelf) {
        try{
            var stmt = conn.prepareStatement(
                    "DELETE FROM SHELF WHERE shelfId = ?");

            stmt.setInt(1, shelf.getId());

            stmt.executeUpdate();
            stmt.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(@NotNull StorageAccount account) {
        try{
            var stmt = conn.prepareStatement(
                    "DELETE FROM ACCOUNT WHERE accountId = ?");

            stmt.setInt(1, account.id());

            stmt.executeUpdate();
            stmt.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try{
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}