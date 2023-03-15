package stocker.storage.model.objects;

public record StorageObject(int id, String content, int sizeX, int sizeY, StorageObjectType type) { }