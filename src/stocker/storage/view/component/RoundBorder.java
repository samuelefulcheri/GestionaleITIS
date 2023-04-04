package stocker.storage.view.component;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundBorder extends AbstractBorder {
    private final int arcWidth;
    private final int arcHeight;
    private final Color color;

    public RoundBorder(int radius, Color color) {
        arcWidth = radius;
        arcHeight = radius;
        this.color = color;
    }

    @Override
    public void paintBorder(Component c, @NotNull Graphics g, int x, int y, int width, int height) {
        var g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(color);
        g2d.draw(new RoundRectangle2D.Float(x, y, width-1, height-1, arcWidth, arcHeight));
        g2d.dispose();
    }

    @Contract(value = "_ -> new", pure = true)
    @Override
    public @NotNull Insets getBorderInsets(Component c) {
        return new Insets(arcHeight/2, arcWidth/2, arcHeight/2, arcWidth/2);
    }

    @Contract("_, _ -> param2")
    @Override
    public @NotNull Insets getBorderInsets(Component c, @NotNull Insets insets) {
        insets.left = arcWidth/2;
        insets.right = arcWidth/2;
        insets.top = arcHeight/2;
        insets.bottom = arcHeight/2;
        return insets;
    }
}