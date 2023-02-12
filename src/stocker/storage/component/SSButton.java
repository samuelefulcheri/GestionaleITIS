package stocker.storage.component;
import stocker.storage.Windows;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SSButton extends JButton {
    public SSButton() {
        super();
        setBackground(Windows.GRIGIO_CHIARO);
        setBackground(Windows.GRIGIO_CHIARO);
        setBorder(Windows.BORDO);
        setForeground(Windows.BIANCO);
        setFont(Windows.FONT_SCRITTE);
        setUI(new BasicButtonUI() {
            @Override
            protected void paintButtonPressed(Graphics g, AbstractButton button) {
                button.setBackground(Windows.GRIGIO_SCURO);
            }

            @Override
            protected void installListeners(AbstractButton button) {
                super.installListeners(button);
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        button.setBackground(Windows.GRIGIO_CHIARO);
                    }
                });
            }
        });
    }

    public SSButton(String text) {
        this();
        setText(text);
    }
}