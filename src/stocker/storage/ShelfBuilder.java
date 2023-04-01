package stocker.storage;
import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import java.awt.*;

public class ShelfBuilder {
    public static @NotNull JPanel buildShelf(int x, int y) {
        int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int objectWidth = (int) (screenWidth * 0.005);
        int objectHeight = (int) (screenHeight * 0.005);

        JPanel shelfPanel = new JPanel(new GridLayout(y, x));
        shelfPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 10, true));
        shelfPanel.setBackground(Color.GRAY);

        for (int i = 0; i < x * y; i++) {
            JPanel objectPanel = new JPanel();
            objectPanel.setPreferredSize(new Dimension(objectWidth, objectHeight));
            objectPanel.setBackground(Color.WHITE);
            objectPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5, true));
            shelfPanel.add(objectPanel);
            if ((i + 1) % x == 0 && i != x * y - 1) {
                JPanel dividerPanel = new JPanel();
                dividerPanel.setPreferredSize(new Dimension(screenWidth, 5));
                dividerPanel.setBackground(Color.GRAY);
                shelfPanel.add(dividerPanel);
            }
        }
        return shelfPanel;
    }

    public static void main(String[] args) {
        var x = 3;
        var y = 4;

        var shelfPanel = ShelfBuilder.buildShelf(x, y);

        var frame = new JFrame("Shelf");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(shelfPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}