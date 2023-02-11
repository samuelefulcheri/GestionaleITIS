package stocker.storage;
import stocker.storage.component.SSButton;
import stocker.storage.component.SSPanel;
import stocker.storage.component.SSTextArea;
import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JPanel {
    public WelcomePage() {
        setLayout(new GridBagLayout());
        setBackground(Windows.grigio);

        GridBagConstraints gbc = new GridBagConstraints();

        SSPanel buttonsPanel = new SSPanel();
        buttonsPanel.setBorder(null);

        gbc.weightx = 0.15;
        gbc.weighty = 1;
        gbc.insets.right = 1;
        gbc.fill = 1;
        add(buttonsPanel, gbc);

        SSPanel componentPanel = new SSPanel();
        componentPanel.setBackground(Windows.grigioChiaro);

        gbc.gridx = 1;
        gbc.weightx = 0.85;
        gbc.insets.right = 0;
        add(componentPanel, gbc);

        SSButton storageButton = new SSButton("Magazzino");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 0.05;
        gbc.insets.set(15, 15, 15, 15);
        gbc.fill = 1;
        buttonsPanel.add(storageButton, gbc);

        SSButton bottone2 = new SSButton("Secondo bottone");
        gbc.gridy = 1;
        gbc.insets.set(0, 15, 15, 15);
        buttonsPanel.add(bottone2, gbc);

        SSButton bottone3 = new SSButton("Terzo bottone");
        gbc.gridy = 2;
        buttonsPanel.add(bottone3, gbc);

        JPanel vuoto = new JPanel();
        vuoto.setBackground(Windows.grigio);

        gbc.gridy = 3;
        gbc.weighty = 0.75;
        gbc.insets.set(0, 0, 0, 0);
        buttonsPanel.add(vuoto, gbc);

        SSButton errorsButton = new SSButton("Errors");
        errorsButton.setForeground(Color.red);
        gbc.gridy = 4;
        gbc.weighty = 0.05;
        gbc.insets.set(0, 15, 15, 15);
        buttonsPanel.add(errorsButton, gbc);

        SSButton notificationsButton = new SSButton("Notifiche");
        gbc.gridy = 5;
        buttonsPanel.add(notificationsButton, gbc);

        SSTextArea welcome = new SSTextArea("Welcome!");
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets.set(150, 50, 0, 0);
        gbc.fill = 1;
        componentPanel.add(welcome, gbc);
    }
}