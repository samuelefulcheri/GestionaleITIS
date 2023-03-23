package stocker.storage.view.component;
import stocker.storage.view.SSWindow;
import javax.swing.*;
import java.awt.*;

public class SSPanel extends JPanel {
    public SSPanel() {
        super();
        setBackground(SSWindow.GRAY);
        setBorder(SSWindow.SS_BORDER);
        setLayout(new GridBagLayout());
    }
}