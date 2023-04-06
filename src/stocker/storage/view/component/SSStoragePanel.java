package stocker.storage.view.component;
import org.jetbrains.annotations.NotNull;
import stocker.storage.view.SSWindow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SSStoragePanel extends JPanel {
    public SSStoragePanel() {
        super();
        setBackground(SSWindow.LIGHT_GRAY);

        addMouseWheelListener(e -> resizeEvent((e.getWheelRotation() < 0) ? 1.1F : .9F));

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                var components = getComponents();
                for(var component: components)
                    component.revalidate();

                revalidate();
            }
        });
    }

    public void resizeEvent(float zoom) {
        var size = getParent().getSize();
        if((size.width+size.height) > 5000 && zoom == 1.1F) return;

        setPreferredSize(size.width*zoom, size.height*zoom);
        revalidate();

        var components = getComponents();
        for(var component: components) {
            var cmpSize = getSize();
            setPreferredSize(component, cmpSize.width*zoom, cmpSize.height*zoom);
            component.revalidate();
        }
    }

    private void setPreferredSize(float size1, float size2) {
        setPreferredSize(new Dimension((int) size1, (int) size2));
    }

    private void setPreferredSize(@NotNull Component cmp, float size1, float size2) {
        cmp.setPreferredSize(new Dimension((int) size1, (int) size2));
    }

    public void paintStorage(boolean[][] storage) {
        removeAll();

        var shelf = buildShelf(storage.length, storage[0].length);
        setPreferredSize(shelf, getHeight(), getWidth());
        add(shelf);
    }

    public static @NotNull JPanel buildShelf(int x, int y) {
        var spacing = 5;
        var shelfPanel = new SSRoundPanel(10, new RoundBorder(25, SSWindow.DARK_GRAY));

        shelfPanel.setLayout(new GridLayout(x, y, spacing, spacing));
        shelfPanel.setBorder(new RoundBorder(10, SSWindow.DARK_GRAY));
        shelfPanel.setBackground(SSWindow.LIGHTER_GRAY);

        for(var i = 0; i < x*y; i++) {
            var objectPanel = new SSRoundPanel(25, new RoundBorder(25, SSWindow.DARK_GRAY));
            objectPanel.setBackground(SSWindow.LIGHTER_GRAY);

            objectPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    ((JPanel) e.getSource()).setBackground(SSWindow.LIGHT_GRAY);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    ((JPanel) e.getSource()).setBackground(SSWindow.LIGHTER_GRAY);
                }
            });

            shelfPanel.add(objectPanel);
        }

        return shelfPanel;
    }
}