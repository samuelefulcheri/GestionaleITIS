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
        setBackground(Windows.grigioChiaro);
        setBackground(Windows.grigioChiaro);
        setBorder(Windows.bordo);
        setForeground(Windows.bianco);
        setFont(Windows.fontScritte);
        setUI(new BasicButtonUI() {
            @Override
            protected void paintButtonPressed(Graphics g, AbstractButton button) {
                button.setBackground(Windows.grigioScuro);
            }

            @Override
            protected void installListeners(AbstractButton button) {
                super.installListeners(button);
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        button.setBackground(Windows.grigioChiaro);
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