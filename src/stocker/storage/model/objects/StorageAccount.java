package stocker.storage.model.objects;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import stocker.storage.Main;

public record StorageAccount(int id, String name, String email, String password, AccountRanks rank) {
    @Override
    public @NotNull String toString() {
        var s = Main.separator;
        return id + s + name + s + email + s + password + s + rank;
    }

    @Contract("_ -> new")
    public static @NotNull StorageAccount createFromId(int id) {
        return new StorageAccount(id, null, null, null, null);
    }
}