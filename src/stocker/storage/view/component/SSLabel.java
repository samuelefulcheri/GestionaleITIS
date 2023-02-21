package stocker.storage.view.component;
import stocker.storage.view.Windows;
import javax.swing.*;
import java.awt.*;

public class SSLabel extends JLabel {
    public SSLabel(String text) {
        super(text);
        setFont(Windows.PLAIN_FONT);
        setForeground(Color.white);
    }
}