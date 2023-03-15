package stocker.storage.model.objects;

public enum AccountRanks {
    ADMINISTRATOR("administrator"),
    EMPLOYEE("employee");

    final String value;

    AccountRanks(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}