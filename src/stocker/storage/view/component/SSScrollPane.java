package stocker.storage.view.component;
import org.jetbrains.annotations.NotNull;
import stocker.storage.view.Windows;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class SSScrollPane extends JScrollPane {
    public SSScrollPane(Component component) {
        super(component);

        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        setBorder(null);

        JScrollBar verticalScrollBar = getVerticalScrollBar();
        verticalScrollBar.setUI(new SSScrollBarUI());
        verticalScrollBar.setUnitIncrement(16);
        verticalScrollBar.setBackground(null);

        JScrollBar horizontalScrollBar = getHorizontalScrollBar();
        horizontalScrollBar.setUI(new SSScrollBarUI());
        horizontalScrollBar.setBackground(null);
    }
}

class SSScrollBarUI extends BasicScrollBarUI {
    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new JButton() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(0, 0);
            }
        };
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new JButton() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(0, 0);
            }
        };
    }

    // TODO: Fixare pixel bianco errore

    @Override
    protected void paintTrack(@NotNull Graphics g, JComponent c, @NotNull Rectangle trackBounds) {
        g.setColor(Windows.LIGHT_GRAY);
        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
    }

    @Override
    protected void paintThumb(@NotNull Graphics g, JComponent c, @NotNull Rectangle thumbBounds) {
        g.setColor(Windows.DARK_GRAY);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10);
    }
}