package stocker.storage.view.component;
import stocker.storage.Main;
import stocker.storage.view.SSWindow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SSTextArea extends JTextArea {
    public SSTextArea() {
        super();
        setBackground(SSWindow.LIGHT_GRAY);
        setForeground(Color.white);
        setEditable(false);
        setFocusable(false);
        setFont(SSWindow.TITLE_FONT);
        setAutoLineWrap();
    }

    public void setAutoLineWrap() {
        setLineWrap(true);
        setWrapStyleWord(true);
        Main.window.addComponentListener(new ComponentAdapter() {
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