package stocker.storage.view.component;
import org.jetbrains.annotations.NotNull;
import stocker.storage.view.SSWindow;
import javax.swing.*;
import java.awt.*;

public class SSTextField extends JTextField {
    public SSTextField() {
        super();
        setForeground(Color.white);
        setFont(SSWindow.PLAIN_FONT);
        setOpaque(false);
        setBorder(new SSLineBorder(SSWindow.DARK_GRAY, 1, 10));
    }

    public SSTextField(int columns) {
        this();
        setColumns(columns);
    }

    @Override
    public Insets getInsets() {
        var insets = super.getInsets();
        insets.left += 5;
        insets.right += 5;
        return insets;
    }

    @Override
    protected void paintComponent(@NotNull Graphics g) {
        g.setColor(SSWindow.LIGHTER_GRAY);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        super.paintComponent(g);
    }
}