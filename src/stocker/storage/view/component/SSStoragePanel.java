package stocker.storage.view.component;
import org.jetbrains.annotations.NotNull;
import stocker.storage.view.SSWindow;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JPanel;

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
            public void componentResized(ComponentEvent evt) {
                revalidate();
            }
        });
    }

    @Override
    public void mouseWheelMoved(@NotNull MouseWheelEvent e) {
        zoomFactor = (e.getWheelRotation() < 0) ? 1.1F : 0.9F;

        var size = getParent().getSize();
        setPreferredSize(size.width*zoomFactor, size.height*zoomFactor);
        revalidate();
    }

    private void setPreferredSize(float size1, float size2) {
        setPreferredSize(new Dimension((int) size1, (int) size2));
    }

    public void paintStorage(boolean[][] storage) {
        removeAll();

        var panelWidth = getWidth()/storage.length;
        var panelHeight = getHeight()/storage[0].length;

        var panel = new SSPanel();

        for(var i = 0; i < storage.length; i++)
            for(var j = 0; j < storage[0].length; j++)
                if(storage[i][j]) {
                    panel.setBounds(i*panelWidth, j*panelHeight, panelWidth, panelHeight);
                    add(panel);
                }

        revalidate();
        repaint();
    }
}