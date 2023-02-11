package stocker.storage;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class WelcomePage extends JPanel {
    public WelcomePage() {
        Border bordo = BorderFactory.createLineBorder(new Color(32, 34, 37));
        setLayout(new GridBagLayout());
        JTextField textField = new JTextField(" ");
        textField.setFont(new Font("ArialBold", Font.PLAIN, 18));
        JButton pulsante = new JButton("Invia");
        pulsante.addActionListener(e -> azionePulsante());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.weightx = 0.95;
        gbc.weighty = 1;
        gbc.insets = new Insets(0, 0, 0, 5);
        gbc.fill = 1;
        textField.setBackground(new Color(64, 68, 75));
        textField.setForeground(new Color(255, 255, 255));
        pulsante.setBackground(new Color(64, 68, 75));
        pulsante.setForeground(new Color(255, 255, 255));
        pulsante.setBorder(bordo);
        textField.setBorder(bordo);
        add(textField, gbc);
        gbc.gridx = 1;
        gbc.weightx = 0.05;
        gbc.insets = new Insets(0, 5, 0, 0);
        gbc.anchor = GridBagConstraints.LINE_END;
        add(pulsante, gbc);
    }

    private void azionePulsante() {

    }
}