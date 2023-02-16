package stocker.storage.view.pages;
import stocker.storage.view.Windows;
import stocker.storage.view.component.SSPanel;
import stocker.storage.view.component.SSTextArea;
import java.awt.*;

public class WelcomePage extends SSPanel {
    public WelcomePage() {
        setBorder(null);
        setBackground(Windows.LIGHT_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();

        SSTextArea welcome = new SSTextArea("Welcome!");
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets.set(150, 50, 0, 0);
        gbc.fill = 1;
        add(welcome, gbc);
    }
}