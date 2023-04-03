package stocker.storage.view.component;
import org.jetbrains.annotations.NotNull;
import stocker.storage.view.SSWindow;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.*;

public class SSStoragePanel extends JPanel implements MouseWheelListener {
    private float zoomFactor;
    private float zoom = 1;

    public SSStoragePanel() {
        super();
        zoomFactor = 1.0F;
        setBackground(SSWindow.LIGHTER_GRAY);
        addMouseWheelListener(this);

        add(new SSLabel("Testo di prova"));

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

    @Override
    public void mouseWheelMoved(@NotNull MouseWheelEvent e) {
        zoomFactor = (e.getWheelRotation() < 0) ? 1.1F : 0.9F;
        zoom *= zoomFactor;

        System.out.println(zoom);

        var size = getParent().getSize();
        setPreferredSize(size.width*zoomFactor, size.height*zoomFactor);
        revalidate();

        var components = getComponents();
        for(var component: components) {
            var sizeComponent = getSize();
            setPreferredSize(component, sizeComponent.width*zoomFactor, sizeComponent.height*zoomFactor);
            component.revalidate();
        }
    }

    private void setPreferredSize(float size1, float size2) {
        setPreferredSize(new Dimension((int) size1, (int) size2));
    }

    private void setPreferredSize(@NotNull Component c, float size1, float size2) {
        c.setPreferredSize(new Dimension((int) size1, (int) size2));
    }

    public void paintStorage(boolean[][] storage) {
        removeAll();
        var shelf = buildShelf(storage.length, storage[0].length);
        setPreferredSize(shelf, getHeight(), getWidth());
        add(shelf);
        shelf.revalidate();
        setVisible(true);
    }

    private @NotNull JPanel buildShelf(int x, int y) {
        var screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        var screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        var objectWidth = (int) (screenWidth*0.005);
        var objectHeight = (int) (screenHeight*0.005);

        var shelfPanel = new JPanel(new GridLayout(y, x));
        shelfPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 10, true));
        shelfPanel.setBackground(Color.GRAY);

        for(int i = 0; i < x*y; i++) {
            JPanel objectPanel = new JPanel();
            objectPanel.setPreferredSize(new Dimension(objectWidth, objectHeight));
            objectPanel.setBackground(Color.WHITE);
            objectPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5, true));
            shelfPanel.add(objectPanel);
            if((i+1)%x == 0 && i != x*y-1) {
                JPanel dividerPanel = new JPanel();
                dividerPanel.setPreferredSize(new Dimension(screenWidth, 5));
                dividerPanel.setBackground(Color.GRAY);
                shelfPanel.add(dividerPanel);
            }
        } return shelfPanel;
    }
}