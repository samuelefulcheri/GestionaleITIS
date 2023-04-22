package stocker.storage.view.component;
import stocker.storage.view.SSWindow;
import javax.swing.*;
import java.awt.*;

public class SSTextArea extends JTextArea {
    public SSTextArea() {
        super();
        setBackground(SSWindow.LIGHT_GRAY);
        setForeground(Color.white);
        setEditable(false);
        setFocusable(false);
        setFont(SSWindow.TITLE_FONT);
    }

    public SSTextArea(String text) {
        this();
        setText(text);
    }
}