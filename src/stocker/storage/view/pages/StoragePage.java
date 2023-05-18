package stocker.storage.view.pages;
import stocker.storage.model.DataBase;
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

        var shelves = DataBase.readShelf();

        if(shelves != null)
            for(var shelf: shelves)
                storage.paintStorage(shelf);

        setVisible(true);
    }
}