package stocker.storage.view.component;
import stocker.storage.Main;
import stocker.storage.view.Windows;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SSTextArea extends SingleLineText {
    public SSTextArea() {
        super("");
        setFont(Windows.TITLE_FONT);
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