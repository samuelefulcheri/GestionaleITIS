package stocker.storage.model.objects;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class StorageShelf {
    private final int sizeX;
    private final int sizeY;
    private final boolean[][] shelf;
    private final ArrayList<StorageObject> content;

    public StorageShelf(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        shelf = new boolean[sizeY][sizeX];
        for(int y = 0; y < sizeY; y++)
            for(int x = 0; x < sizeX; x++) shelf[y][x] = true;
        content = new ArrayList<>();
    }

    public boolean addObject(@NotNull StorageObject obj) {
        int sizeX = obj.sizeX;
        int sizeY = obj.sizeY;

        if(getFree() < sizeX*sizeY) return false;

        for(int y = 0; y < sizeY; y++) {
            for(int x = 0; x < sizeX; x++) {
                System.out.println(x);
            }
        }

        content.add(obj);
        return true;
    }

    public ArrayList<StorageObject> getObjects(String search) {
        ArrayList<StorageObject> results = new ArrayList<>();
        for(StorageObject obj: content)
            if(obj.content.equals(search)) results.add(obj);
        return results;
    }

    private boolean isFree(int x, int y) {
        return shelf[y][x];
    }

    private int getUsage() {
        int i = 0;
        for(int y = 0; y < sizeY; y++)
            for(int x = 0; x < sizeY; x++)
                if(!isFree(x, y)) i++;
        return i;
    }

    private int getFree() {
        return sizeX*sizeY-getUsage();
    }

    public int getSizeX() {
        return sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }
}