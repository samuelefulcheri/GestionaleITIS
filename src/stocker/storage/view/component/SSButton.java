package stocker.storage.view.component;
import stocker.storage.view.SSWindow;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SSButton extends JButton {
    private Color color = SSWindow.LIGHT_GRAY;

    public SSButton() {
        super();
        setBackground(color);
        setBorder(SSWindow.SS_BORDER);
        setForeground(Color.white);
        setFont(SSWindow.PLAIN_FONT);
        setFocusable(false);
        setUI(new BasicButtonUI() {
            @Override
            protected void paintButtonPressed(Graphics g, AbstractButton button) {
                button.setBackground(SSWindow.DARK_GRAY);
            }

            @Override
            protected void installListeners(AbstractButton button) {
                super.installListeners(button);
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        button.setBackground(color);
                    }
                });
            }
        });
    }

    public SSButton(String text) {
        this();
        setText(text);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}