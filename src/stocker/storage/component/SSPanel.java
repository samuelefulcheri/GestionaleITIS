package stocker.storage.component;
import stocker.storage.Windows;

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
