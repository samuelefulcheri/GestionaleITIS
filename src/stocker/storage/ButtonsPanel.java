package stocker.storage;
import stocker.storage.component.SSButton;
import stocker.storage.component.SSPanel;
import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends SSPanel {
    public ButtonsPanel() {
        setBorder(null);

        GridBagConstraints gbc = new GridBagConstraints();

        SSButton storageButton = new SSButton("Magazzino");
        storageButton.addActionListener(e -> {
            if(Windows.currentStatus != 1) {
                Windows.currentStatus = 1;
                Windows.cambiaPagina();
            }
        });

        gbc.weightx = 1;
        gbc.weighty = 0.05;
        gbc.insets.set(15, 15, 15, 15);
        gbc.fill = 1;
        add(storageButton, gbc);

        SSButton bottone2 = new SSButton("Secondo bottone");
        bottone2.addActionListener(e -> {
            if(Windows.currentStatus != 2) {
                Windows.currentStatus = 2;
                Windows.cambiaPagina();
            }
        });

        gbc.gridy = 1;
        gbc.insets.set(0, 15, 15, 15);
        add(bottone2, gbc);

        SSButton bottone3 = new SSButton("Terzo bottone");
        bottone3.addActionListener(e -> {
            if(Windows.currentStatus != 3) {
                Windows.currentStatus = 3;
                Windows.cambiaPagina();
            }
        });

        gbc.gridy = 2;
        add(bottone3, gbc);

        JPanel vuoto = new JPanel();
        vuoto.setBackground(Windows.GRIGIO);

        gbc.gridy = 3;
        gbc.weighty = 0.75;
        gbc.insets.set(0, 0, 0, 0);
        add(vuoto, gbc);

        SSButton errorsButton = new SSButton("Errors");
        errorsButton.setForeground(Color.red);
        errorsButton.addActionListener(e -> {
            if(Windows.currentStatus != 4) {
                Windows.currentStatus = 4;
                Windows.cambiaPagina();
            }
        });

        gbc.gridy = 4;
        gbc.weighty = 0.05;
        gbc.insets.set(0, 15, 15, 15);
        add(errorsButton, gbc);

        SSButton notificationsButton = new SSButton("Notifiche");
        notificationsButton.addActionListener(e -> {
            if(Windows.currentStatus != 5) {
                Windows.currentStatus = 5;
                Windows.cambiaPagina();
            }
        });

        gbc.gridy = 5;
        add(notificationsButton, gbc);
    }
}