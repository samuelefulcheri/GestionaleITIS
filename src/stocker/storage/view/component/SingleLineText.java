package stocker.storage.view.component;
import stocker.storage.view.Windows;
import javax.swing.*;
import java.awt.*;

public class SingleLineText extends JTextArea {
    public SingleLineText(String text) {
        super(text);
        setBackground(Windows.LIGHT_GRAY);
        setForeground(Color.white);
        setFont(Windows.PLAIN_FONT);
        setEditable(false);
        setFocusable(false);
    }
}