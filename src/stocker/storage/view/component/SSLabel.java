package stocker.storage.view.component;
import stocker.storage.view.SSWindow;
import javax.swing.*;
import java.awt.*;

public class SSLabel extends JLabel {
    public SSLabel(String text) {
        super(text);
        setFont(SSWindow.PLAIN_FONT);
        setForeground(Color.white);
    }
}