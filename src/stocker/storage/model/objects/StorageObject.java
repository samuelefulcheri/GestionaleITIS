package stocker.storage.model.objects;

public record StorageObject(int id, StorageObject content, String contentDescription, int sizeX, int sizeY, StorageObjectType type) {

    boolean isContainer(){
        return contentDescription.equalsIgnoreCase("container");
    }


}
