package stocker.storage.model.objects;
import org.jetbrains.annotations.Nullable;

public enum AccountRanks {
    ADMINISTRATOR("administrator"),
    EMPLOYEE("employee");

    final String value;

    AccountRanks(String value) {
        this.value = value;
    }

    public static @Nullable AccountRanks getRankFromString(String value) {
        for(var rank: AccountRanks.values())
            if(rank.value.equals(value)) return rank;

        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}