package stocker.storage.graphics.pages;
import stocker.storage.graphics.Windows;
import stocker.storage.graphics.component.SSPanel;
import stocker.storage.graphics.component.SSTextArea;
import java.awt.*;

public class StoragePage extends SSPanel {
    public StoragePage() {
        setBorder(null);
        setBackground(Windows.GRIGIO_CHIARO);

        GridBagConstraints gbc = new GridBagConstraints();

        SSTextArea storage = new SSTextArea("Magazzino");
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets.set(150, 50, 0, 0);
        gbc.fill = 1;
        add(storage, gbc);
    }
}