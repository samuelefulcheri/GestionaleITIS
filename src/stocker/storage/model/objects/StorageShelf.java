package stocker.storage.model.objects;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Arrays;

public class StorageShelf {
    private final int id;
    private final int sizeX;
    private final int sizeY;
    private final boolean[][] shelf;
    private final ArrayList<StorageObject> content;

    public StorageShelf(int id, int sizeX, int sizeY) {
        this.id = id;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        shelf = new boolean[sizeY][sizeX];
        for(var y = 0; y < sizeY; y++)
            Arrays.fill(shelf[y], true);
        content = new ArrayList<>();
    }

    public boolean addObject(@NotNull StorageObject obj) {
        var sizeX = obj.sizeX();
        var sizeY = obj.sizeY();

        if(getFree() < sizeX*sizeY) return false;

        var result = findAndFillSubMatrix(sizeX, sizeY);
        content.add(obj);

        return result;
    }

    public ArrayList<StorageObject> getObjects(String search) {
        ArrayList<StorageObject> results = new ArrayList<>();
        for(var obj: content)
            if(obj.content().equals(search)) results.add(obj);

        return results;
    }

    public int getId() {
        return id;
    }
    public int getSizeX() {
        return sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }
    public boolean[][] getShelf() {
        return shelf;
    }
    public ArrayList<StorageObject> getContent() {
        return content;
    }


    // Miscellaneous

    private int getUsage() {
        var i = 0;
        for(var y = 0; y < sizeY; y++)
            for(var x = 0; x < sizeX; x++)
                if(isUsed(x, y)) i++;

        return i;
    }

    private boolean findAndFillSubMatrix(int sizeX, int sizeY) {
        for(var y = 0; y <= this.sizeY-sizeY; y++)
            for(var x = 0; x <= this.sizeX-sizeX; x++)
                if(isSubMatrixEmpty(x, y, sizeX, sizeY)) {
                    fillSubMatrix(x, y, sizeX, sizeY);
                    return true;
                }

        return false;
    }

    private boolean isSubMatrixEmpty(int row, int col, int sizeX, int sizeY) {
        for(var y = row; y < row+sizeY; y++)
            for(var x = col; x < col+sizeX; x++)
                if(isUsed(x, y)) return false;

        return true;
    }

    private void fillSubMatrix(int row, int col, int sizeX, int sizeY) {
        for(var y = row; y < row+sizeY; y++)
            for(var x = col; x < col+sizeX; x++)
                shelf[y][x] = false;
    }

    private boolean isUsed(int x, int y) {
        return !shelf[y][x];
    }
    private int getFree() {
        return sizeX*sizeY-getUsage();
    }
}