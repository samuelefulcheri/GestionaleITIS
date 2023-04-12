package stocker.storage.view.component;
import org.jetbrains.annotations.NotNull;
import stocker.storage.model.objects.StorageShelf;
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

    public void paintStorage(@NotNull StorageShelf storage) {
        removeAll();

        var shelf = storage.getShelf();

        var shelfPanel = buildShelf(shelf.length, shelf[0].length, storage);
        setPreferredSize(shelfPanel, getHeight(), getWidth());
        add(shelfPanel);
    }

    public static @NotNull JPanel buildShelf(int x, int y, StorageShelf shelf) {
        var spacing = 5;
        var shelfPanel = new SSRoundPanel(10, new RoundBorder(25, SSWindow.DARK_GRAY));

        shelfPanel.setLayout(new GridLayout(x, y, spacing, spacing));
        shelfPanel.setBorder(new RoundBorder(10, SSWindow.DARK_GRAY));
        shelfPanel.setBackground(SSWindow.LIGHTER_GRAY);

        var jx = 0;
        var jy = 0;
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

            try{
                if(shelf.isUsed(jy, jx)) {
                    var label = new SSLabel("Used");
                    objectPanel.add(label);
                }
            }catch (Exception ignored) { }

            shelfPanel.add(objectPanel);

            /*if(jx+1 != x)*/ jx = (i%x == 0) ? 0 : jx+1;
            if(i%x == 0 /*&& jx+1 != y*/) jy++;
        }

        var shelfMatrix = shelf.getShelf();
        for(var i: shelfMatrix) {
            for(var j: i) {
                if(j) System.out.print("o");
                else System.out.print("x");
                System.out.print(" ");
            } System.out.println();
        }

        return shelfPanel;
    }
}