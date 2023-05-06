package stocker.storage.view.component;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import stocker.storage.view.SSWindow;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class SSScrollPane extends JScrollPane {
    public SSScrollPane(Component component) {
        super(component);

        setBackground(SSWindow.LIGHT_GRAY);
        setBorder(null);

        var verticalScrollBar = getVerticalScrollBar();
        verticalScrollBar.setUI(new SSScrollBarUI());
        verticalScrollBar.setUnitIncrement(16);
        verticalScrollBar.setBackground(null);

        var horizontalScrollBar = getHorizontalScrollBar();
        horizontalScrollBar.setUI(new SSScrollBarUI());
        horizontalScrollBar.setBackground(null);
    }

    private static class SSScrollBarUI extends BasicScrollBarUI {
        @Contract("_ -> new")
        @Override
        protected @NotNull JButton createDecreaseButton(int orientation) {
            return new JButton() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(0, 0);
                }
            };
        }

        @Contract("_ -> new")
        @Override
        protected @NotNull JButton createIncreaseButton(int orientation) {
            return new JButton() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(0, 0);
                }
            };
        }

        @Override
        protected void paintTrack(@NotNull Graphics g, JComponent c, @NotNull Rectangle r) { }

        @Override
        protected void paintThumb(@NotNull Graphics g, JComponent c, @NotNull Rectangle r) {
            g.setColor(SSWindow.DARK_GRAY);
            g.fillRoundRect(r.x, r.y, r.width, r.height, 10, 10);
        }
    }
}