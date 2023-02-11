package stocker.storage.component;
import stocker.storage.Windows;
import javax.swing.*;

public class SSTextArea extends JTextArea {
    public SSTextArea() {
        super();
        setBackground(Windows.grigioChiaro);
        setForeground(Windows.bianco);
        setFont(Windows.fontTitoli);
        setEditable(false);
        setFocusable(false);
    }

    public SSTextArea(String text) {
        this();
        setText(text);
    }
}
