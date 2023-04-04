package stocker.storage.view.component;
import java.awt.*;
import javax.swing.*;

public class SSRoundPanel extends JPanel {
    private final int arcWidth;
    private final int arcHeight;

    public SSRoundPanel(int radius, RoundBorder border) {
        arcWidth = radius;
        arcHeight = radius;
        setOpaque(false);
        setBorder(border);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
        super.paintComponent(g);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        repaint();
    }
}