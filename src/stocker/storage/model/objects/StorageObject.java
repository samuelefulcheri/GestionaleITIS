package stocker.storage.model.objects;

public class StorageObject {
    int sizeX;
    int sizeY;
    String content;

    public StorageObject(int sizeX, int sizeY, String content) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.content = content;
    }

    public int getSizeX() {
        return sizeX;
    }
    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }
    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}