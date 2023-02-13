package stocker.storage.view.component;
import stocker.storage.Main;
import stocker.storage.view.Windows;
import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SSTextArea extends JTextArea {
    public SSTextArea() {
        super();
        setBackground(Windows.GRIGIO_CHIARO);
        setForeground(Windows.BIANCO);
        setFont(Windows.FONT_TITOLI);
        setEditable(false);
        setFocusable(false);
        setLineWrap(true);
        setWrapStyleWord(true);
        setAutoLineWrap();
    }

    public void setAutoLineWrap() {
        Main.windows.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setLineWrap(true);
                setWrapStyleWord(true);
            }
        });
    }

    public SSTextArea(String text) {
        this();
        setText(text);
    }
}