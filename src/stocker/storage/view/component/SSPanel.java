package stocker.storage.view.component;
import stocker.storage.view.Windows;
import javax.swing.*;
import java.awt.*;

public class SSPanel extends JPanel {
    public SSPanel() {
        super();
        setBackground(Windows.GRAY);
        setBorder(Windows.SS_BORDER);
        setLayout(new GridBagLayout());
    }
}