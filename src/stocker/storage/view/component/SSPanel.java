package stocker.storage.view.component;
import stocker.storage.view.Windows;
import javax.swing.*;
import java.awt.*;

public class SSPanel extends JPanel {
    public SSPanel() {
        super();
        setBackground(Windows.GRIGIO);
        setBorder(Windows.BORDO);
        setLayout(new GridBagLayout());
    }
}