package stocker.storage.view.component;
import stocker.storage.view.SSWindow;
import javax.swing.*;

public class SSToolTip extends JToolTip {
    public SSToolTip() {
        super();
        setBackground(SSWindow.LIGHTER_GRAY);
        setFont(SSWindow.PLAIN_FONT);
        setBorder(SSWindow.SS_BORDER);
    }
}