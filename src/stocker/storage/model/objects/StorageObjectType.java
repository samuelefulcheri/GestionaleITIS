package stocker.storage.model.objects;
import org.jetbrains.annotations.NotNull;

public enum StorageObjectType {
    IMPORT,
    EXPORT;

    @Override
    public @NotNull String toString() {
        return super.toString().toLowerCase();
    }
}