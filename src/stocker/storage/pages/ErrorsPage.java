package stocker.storage.pages;
import stocker.storage.Windows;
import stocker.storage.component.SSPanel;
import stocker.storage.component.SSTextArea;
import java.awt.*;

public class ErrorsPage extends SSPanel {
    public ErrorsPage() {
        setBorder(null);
        setBackground(Windows.GRIGIO_CHIARO);

        GridBagConstraints gbc = new GridBagConstraints();

        SSTextArea errorsPage = new SSTextArea("Errors");
        errorsPage.setForeground(Color.red);

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets.set(150, 50, 0, 0);
        gbc.fill = 1;
        add(errorsPage, gbc);
    }
}