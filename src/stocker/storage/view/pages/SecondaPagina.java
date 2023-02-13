package stocker.storage.view.pages;
import stocker.storage.view.Windows;
import stocker.storage.view.component.SSPanel;
import stocker.storage.view.component.SSTextArea;
import java.awt.*;

public class SecondaPagina extends SSPanel {
    public SecondaPagina() {
        setBorder(null);
        setBackground(Windows.GRIGIO_CHIARO);

        GridBagConstraints gbc = new GridBagConstraints();

        SSTextArea secondaPagina = new SSTextArea("Seconda pagina");
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets.set(150, 50, 0, 0);
        gbc.fill = 1;
        add(secondaPagina, gbc);
    }
}