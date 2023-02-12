package stocker.storage.pages;
import stocker.storage.Windows;
import stocker.storage.component.SSPanel;
import stocker.storage.component.SSTextArea;
import java.awt.*;

public class TerzaPagina extends SSPanel {
    public TerzaPagina() {
        setBorder(null);
        setBackground(Windows.GRIGIO_CHIARO);

        GridBagConstraints gbc = new GridBagConstraints();

        SSTextArea terzaPagina = new SSTextArea("Terza pagina");
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets.set(150, 50, 0, 0);
        gbc.fill = 1;
        add(terzaPagina, gbc);
    }
}