package stocker.storage.controller;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import stocker.storage.Main;
import stocker.storage.model.DataBase;
import stocker.storage.model.objects.AccountRanks;
import stocker.storage.model.objects.StorageAccount;

public class Login {
    public static boolean login(String email, String password) {
        try{
            var db = new DataBase();
            email = decode(email);
            password = decode(password);

            var res = db.read(email, password);

            var id = res.getInt("accountId");
            var name = res.getString("accountName");
            var resRank = res.getString("rank");
            var rank = AccountRanks.getRankFromString(resRank);
            if(rank == null) throw new Exception("Error");

            Main.currentUser = new StorageAccount(id, name, email, password, rank);

            // TODO: Accesso eseguito

            res.close();
            db.closeConnection();
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    public static boolean register(String name, String email, String password) {
        try{
            var db = new DataBase();
            var account = new StorageAccount(0, name, email, password, AccountRanks.EMPLOYEE);
            db.create(account);
            db.closeConnection();
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    @Contract(pure = true)
    public static @NotNull String nameValidation(@NotNull String name) {
        if(name.length() < 4)
            return "Il nome è troppo corto, deve avere almeno 4 caratteri. \n";

        return "";
    }

    @Contract(pure = true)
    public static @NotNull String emailValidation(@NotNull String email) {
        if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
            return "L'E-Mail inserita è errata. \n";

        return "";
    }

    @Contract(pure = true)
    public static @NotNull String passwordValidation(@NotNull String password) {
        if(password.length() < 8)
            return "Password troppo corta, deve almeno avere 8 caratteri. \n";

        return "";
    }

    public static @NotNull String encode(@NotNull String value) {
        return value.replaceAll("%", "%0")
                    .replaceAll("'", "%1")
                    .replaceAll(Main.separator, "%2");
    }

    public static @NotNull String decode(@NotNull String value) {
        return value.replaceAll("%0", "%")
                    .replaceAll("%1", "'")
                    .replaceAll("%2", Main.separator);
    }
}