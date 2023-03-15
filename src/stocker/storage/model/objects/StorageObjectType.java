package stocker.storage.model.objects;

public enum StorageObjectType {
    IMPORT("import"),
    EXPORT("export");

    final String value;

    StorageObjectType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}