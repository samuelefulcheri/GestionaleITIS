package stocker.storage;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Windows extends JFrame {
    public static TextAreaPanel textAreaPanel = new TextAreaPanel();

    public Windows() {
        super("Stocker Storage");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new GridBagLayout());
        WelcomePage welcomePage = new WelcomePage();
        Border bordo = BorderFactory.createLineBorder(new Color(32, 34, 37));
        textAreaPanel.setBorder(bordo);
        welcomePage.setBackground(new Color(54, 57, 63));
        GridBagConstraints gbc = new GridBagConstraints();
        getContentPane().setBackground(new Color(54, 57, 63));
        gbc.weightx = 0.98;
        gbc.weighty = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = 1;
        JScrollPane scroll = new JScrollPane(textAreaPanel);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll, gbc);
        gbc.gridx = 1;
        gbc.weightx = 0.02;
        add(welcomePage, gbc);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}