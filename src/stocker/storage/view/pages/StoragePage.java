package stocker.storage.view.pages;
import stocker.storage.model.objects.StorageObject;
import stocker.storage.model.objects.StorageObjectType;
import stocker.storage.model.objects.StorageShelf;
import stocker.storage.view.SSWindow;
import stocker.storage.view.component.SSPanel;
import stocker.storage.view.component.SSScrollPane;
import stocker.storage.view.component.SSStoragePanel;
import java.awt.*;

public class StoragePage extends SSPanel {
    public StoragePage() {
        setBorder(null);
        setBackground(SSWindow.LIGHT_GRAY);

        var storage = new SSStoragePanel();

        storage.setPreferredSize(new Dimension(getPreferredSize().width, getPreferredSize().height));

        var scroll = new SSScrollPane(storage);
        scroll.setPreferredSize(storage.getPreferredSize());
        scroll.removeMouseWheelListener(scroll.getMouseWheelListeners()[0]);

        var gbc = new GridBagConstraints();

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = 1;

        add(scroll, gbc);

        var object = new StorageObject(1, null, "penne", 5, 5, StorageObjectType.IMPORT);
        var shelf = new StorageShelf(1, 5, 5);
        var shelf2 = new StorageShelf(1, 7, 5);

        // TODO: Errore
        if(!shelf.addObject(object)) {
            SSWindow.errorsPage.addErrors("Errore nell'aggiunta dell'oggetto nel magazzino");
            return;
        }

        storage.paintStorage(shelf);
        storage.paintStorage(shelf2);

        setVisible(true);
    }
}