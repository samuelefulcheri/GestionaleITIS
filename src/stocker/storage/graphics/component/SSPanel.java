package stocker.storage.graphics.component;
import stocker.storage.graphics.Windows;

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
