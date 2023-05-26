package stocker.storage.model.objects;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public record StorageObject(int id, ArrayList<StorageObject> content, String contentDescription, int sizeX, int sizeY,
                            StorageObjectType type) {
    public static boolean isContentParsable(Object obj) {
        return ((obj instanceof ArrayList) && !((ArrayList<?>) obj).isEmpty() &&
                (((ArrayList<?>) obj).get(0) instanceof StorageObject));
    }

    public static @NotNull ArrayList<StorageObject> parseContent(@NotNull ArrayList<?> objs) {
        ArrayList<StorageObject> res = new ArrayList<>();
        for(var item: objs)
            if(item instanceof StorageObject)
                res.add((StorageObject) item);

        return res;
    }

    @Contract("_ -> new")
    public static @NotNull StorageObject createFromId(int id) {
        return new StorageObject(id, null, null, 0, 0, null);
    }
}