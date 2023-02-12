package stocker.storage.graphics.component;
import stocker.storage.graphics.Windows;
import javax.swing.*;

public class SSTextArea extends JTextArea {
    public SSTextArea() {
        super();
        setBackground(Windows.GRIGIO_CHIARO);
        setForeground(Windows.BIANCO);
        setFont(Windows.FONT_TITOLI);
        setEditable(false);
        setFocusable(false);
    }

    public SSTextArea(String text) {
        this();
        setText(text);
    }
}
