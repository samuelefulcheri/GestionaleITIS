package stocker.storage.view.component;
import stocker.storage.view.Windows;
import javax.swing.*;
import java.awt.*;

public class SSTextField extends JTextField {
    public SSTextField() {
        super();
        setBackground(Windows.LIGHTER_GRAY);
        setForeground(Color.white);
        setFont(Windows.PLAIN_FONT);
        setBorder(Windows.SS_BORDER);
    }

    public SSTextField(int columns) {
        this();
        setColumns(columns);
    }
}