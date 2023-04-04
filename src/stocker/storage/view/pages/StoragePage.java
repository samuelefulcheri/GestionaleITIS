package stocker.storage.view.pages;
import stocker.storage.model.objects.StorageObject;
import stocker.storage.model.objects.StorageObjectType;
import stocker.storage.model.objects.StorageShelf;
import stocker.storage.view.component.SSPanel;
import stocker.storage.view.component.SSStoragePanel;
import java.awt.*;

public class StoragePage extends SSPanel {
    public StoragePage() {
        setBorder(null);

        var gbc = new GridBagConstraints();

        var storage = new SSStoragePanel();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = 1;
        add(storage, gbc);

        var object = new StorageObject(1, "penne", 2, 3, StorageObjectType.IMPORT);
        var shelf = new StorageShelf(1, 5, 5);

        shelf.addObject(object);

        storage.paintStorage(shelf.getShelf());

        setVisible(true);
    }
}