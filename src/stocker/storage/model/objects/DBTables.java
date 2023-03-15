package stocker.storage.model.objects;

public enum DBTables {
    PRODUCT("PRODUCT"),
    SHELF("SHELF"),
    SHELF_CONTENT("SHELF_CONTENT"),
    ACCOUNT("ACCOUNT");

    final String value;

    DBTables(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}