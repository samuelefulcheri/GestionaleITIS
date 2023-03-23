package stocker.storage.view;
import stocker.storage.view.component.SSButton;
import stocker.storage.view.component.SSPanel;
import stocker.storage.view.pages.Pages;
import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends SSPanel {
    public ButtonsPanel() {
        var gbc = new GridBagConstraints();

        var storageButton = new SSButton("Magazzino");
        storageButton.addActionListener(e -> {
            if(SSWindow.currentStatus != Pages.STORAGE_PAGE) {
                SSWindow.currentStatus = Pages.STORAGE_PAGE;
                SSWindow.cambiaPagina();
            }
        });

        gbc.weightx = 1;
        gbc.weighty = 0.05;
        gbc.insets.set(15, 15, 15, 15);
        gbc.fill = 1;
        add(storageButton, gbc);

        var registrationButton = new SSButton("Registrati");
        registrationButton.addActionListener(e -> {
            if(SSWindow.currentStatus != Pages.REGISTRATION_PAGE) {
                SSWindow.currentStatus = Pages.REGISTRATION_PAGE;
                SSWindow.cambiaPagina();
            }
        });

        gbc.gridy = 1;
        gbc.insets.set(0, 15, 15, 15);
        add(registrationButton, gbc);

        var loginButton = new SSButton("Accedi");
        loginButton.addActionListener(e -> {
            if(SSWindow.currentStatus != Pages.LOGIN_PAGE) {
                SSWindow.currentStatus = Pages.LOGIN_PAGE;
                SSWindow.cambiaPagina();
            }
        });

        gbc.gridy = 2;
        add(loginButton, gbc);

        var emptyPanel = new JPanel();
        emptyPanel.setBackground(SSWindow.GRAY);

        gbc.gridy = 3;
        gbc.weighty = 0.75;
        gbc.insets.set(0, 0, 0, 0);
        add(emptyPanel, gbc);

        var errorsButton = new SSButton("Errors");
        errorsButton.setForeground(Color.red);
        errorsButton.addActionListener(e -> {
            if(SSWindow.currentStatus != Pages.ERRORS_PAGE) {
                SSWindow.currentStatus = Pages.ERRORS_PAGE;
                SSWindow.cambiaPagina();
            }
        });

        gbc.gridy = 4;
        gbc.weighty = 0.05;
        gbc.insets.set(0, 15, 15, 15);
        add(errorsButton, gbc);

        var notificationsButton = new SSButton("Notifiche");
        notificationsButton.addActionListener(e -> {
            if(SSWindow.currentStatus != Pages.NOTIFICATIONS_PAGE) {
                SSWindow.currentStatus = Pages.NOTIFICATIONS_PAGE;
                SSWindow.cambiaPagina();
            }
        });

        gbc.gridy = 5;
        add(notificationsButton, gbc);
    }
}