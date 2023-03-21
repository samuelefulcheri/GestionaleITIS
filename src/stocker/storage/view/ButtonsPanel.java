package stocker.storage.view;
import stocker.storage.view.component.SSButton;
import stocker.storage.view.component.SSPanel;
import stocker.storage.view.pages.Pages;

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends SSPanel {
    public ButtonsPanel() {
        GridBagConstraints gbc = new GridBagConstraints();

        SSButton storageButton = new SSButton("Magazzino");
        storageButton.addActionListener(e -> {
            if(Windows.currentStatus != Pages.STORAGE_PAGE) {
                Windows.currentStatus = Pages.STORAGE_PAGE;
                Windows.cambiaPagina();
            }
        });

        gbc.weightx = 1;
        gbc.weighty = 0.05;
        gbc.insets.set(15, 15, 15, 15);
        gbc.fill = 1;
        add(storageButton, gbc);

        SSButton bottone2 = new SSButton("Registrati");
        bottone2.addActionListener(e -> {
            if(Windows.currentStatus != Pages.REGISTRATION_PAGE) {
                Windows.currentStatus = Pages.REGISTRATION_PAGE;
                Windows.cambiaPagina();
            }
        });

        gbc.gridy = 1;
        gbc.insets.set(0, 15, 15, 15);
        add(bottone2, gbc);

        SSButton bottone3 = new SSButton("Accedi");
        bottone3.addActionListener(e -> {
            if(Windows.currentStatus != Pages.LOGIN_PAGE) {
                Windows.currentStatus = Pages.LOGIN_PAGE;
                Windows.cambiaPagina();
            }
        });

        gbc.gridy = 2;
        add(bottone3, gbc);

        JPanel vuoto = new JPanel();
        vuoto.setBackground(Windows.GRAY);

        gbc.gridy = 3;
        gbc.weighty = 0.75;
        gbc.insets.set(0, 0, 0, 0);
        add(vuoto, gbc);

        SSButton errorsButton = new SSButton("Errors");
        errorsButton.setForeground(Color.red);
        errorsButton.addActionListener(e -> {
            if(Windows.currentStatus != Pages.ERRORS_PAGE) {
                Windows.currentStatus = Pages.ERRORS_PAGE;
                Windows.cambiaPagina();
            }
        });

        gbc.gridy = 4;
        gbc.weighty = 0.05;
        gbc.insets.set(0, 15, 15, 15);
        add(errorsButton, gbc);

        SSButton notificationsButton = new SSButton("Notifiche");
        notificationsButton.addActionListener(e -> {
            if(Windows.currentStatus != Pages.NOTIFICATIONS_PAGE) {
                Windows.currentStatus = Pages.NOTIFICATIONS_PAGE;
                Windows.cambiaPagina();
            }
        });

        gbc.gridy = 5;
        add(notificationsButton, gbc);
    }
}