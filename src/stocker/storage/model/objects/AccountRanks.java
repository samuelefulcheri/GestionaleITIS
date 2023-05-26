package stocker.storage.model.objects;
import org.jetbrains.annotations.NotNull;

public enum AccountRanks {
    ADMINISTRATOR,
    EMPLOYEE;

    @Override
    public @NotNull String toString() {
        return super.toString().toLowerCase();
    }
}