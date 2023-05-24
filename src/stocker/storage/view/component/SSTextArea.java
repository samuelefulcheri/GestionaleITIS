package stocker.storage.view.component;
import stocker.storage.view.SSWindow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SSTextArea extends JTextArea {
    private final ComponentAdapter componentAdapter;

    public SSTextArea() {
        super();
        setBackground(SSWindow.LIGHT_GRAY);
        setForeground(Color.white);
        setEditable(false);
        setFocusable(false);
        setFont(SSWindow.TITLE_FONT);

        componentAdapter = new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setLineWrap(true);
            }
        };
    }

    public SSTextArea(String text) {
        this();
        setText(text);
    }

    public void setAutoLineWrap(boolean status) {
        setLineWrap(status);
        if(status) addComponentListener(componentAdapter);
        else removeComponentListener(componentAdapter);
    }
}