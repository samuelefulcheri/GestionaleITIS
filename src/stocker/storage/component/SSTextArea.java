package stocker.storage.component;
import stocker.storage.Windows;
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
