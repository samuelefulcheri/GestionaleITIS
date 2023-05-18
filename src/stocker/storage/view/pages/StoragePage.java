package stocker.storage.view.pages;
import stocker.storage.model.objects.StorageObject;
import stocker.storage.model.objects.StorageObjectType;
import stocker.storage.model.objects.StorageShelf;
import stocker.storage.view.SSWindow;
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

        var object = new StorageObject(1, null, "penne", 2, 3, StorageObjectType.IMPORT);
        var shelf = new StorageShelf(1, 5, 5);

        if(!shelf.addObject(object)){
            SSWindow.errorsPage.addErrors("Errore nell'aggiunta dell'oggetto nel magazzino");
            return;
        }

        storage.paintStorage(shelf);

        setVisible(true);
    }
}