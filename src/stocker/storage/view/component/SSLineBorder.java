package stocker.storage.view.component;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class SSLineBorder extends AbstractBorder {
    private final int thickness;
    private final Color color;
    private final float arc;

    public SSLineBorder(Color color, int thickness, float arc) {
        this.color = color;
        this.thickness = thickness;
        this.arc = arc;
    }

    @Override
    public void paintBorder(Component c, @NotNull Graphics g, int x, int y, int width, int height) {
        var g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        var shape = new RoundRectangle2D.Float(x+thickness/2f, y+thickness/2f, width-thickness, height-thickness, arc, arc);
        g2d.draw(shape);
        g2d.dispose();
    }

    @Contract(value = "_ -> new", pure = true)
    @Override
    public @NotNull Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness);
    }
}