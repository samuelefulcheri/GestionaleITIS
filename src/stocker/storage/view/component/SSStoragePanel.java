package stocker.storage.view.component;
import org.jetbrains.annotations.NotNull;
import stocker.storage.view.SSWindow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SSStoragePanel extends JPanel implements MouseWheelListener {
    private float zoomFactor;

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

        var size = getParent().getSize();

        if((size.width+size.height) > 5000 && zoomFactor == 1.1F) return;

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
        revalidate();
        setVisible(true);
    }

    private @NotNull JPanel buildShelf(int x, int y) {
        var screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        var screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        var objectWidth = (int) (screenWidth*0.005);
        var objectHeight = (int) (screenHeight*0.005);

        var shelfPanel = new JPanel(new GridLayout(y, x));
        shelfPanel.setBorder(BorderFactory.createLineBorder(SSWindow.GRAY, 2, true));
        shelfPanel.setBackground(SSWindow.GRAY);

        for(int i = 0; i < x*y; i++) {
            JPanel objectPanel = new JPanel();
            objectPanel.setPreferredSize(new Dimension(objectWidth, objectHeight));
            objectPanel.setBackground(Color.WHITE);
            objectPanel.setBorder(BorderFactory.createLineBorder(SSWindow.GRAY, 1, true));
            objectPanel.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    var x = e.getX();
                    var y = e.getY();

                    var xPanel = objectPanel.getX();
                    var yPanel = objectPanel.getY();

                    if((x >= xPanel && x <= xPanel+objectHeight) && (y >= yPanel && x <= yPanel+objectWidth))
                        objectPanel.setBackground(SSWindow.LIGHTER_GRAY);
                    else objectPanel.setBackground(Color.white);
                }
            }); shelfPanel.add(objectPanel);
            if((i+1)%x == 0 && i != x*y-1) {
                JPanel dividerPanel = new JPanel();
                dividerPanel.setPreferredSize(new Dimension(screenWidth, 5));
                dividerPanel.setBackground(SSWindow.GRAY);
                shelfPanel.add(dividerPanel);
            }
        } return shelfPanel;
    }
}