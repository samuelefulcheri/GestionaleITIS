package stocker.storage.view.pages;
import stocker.storage.controller.Login;
import stocker.storage.view.SSWindow;
import stocker.storage.view.component.*;

import javax.swing.*;
import java.awt.*;

public class NotificationsPage extends SSPanel {

    private static final int NOTIFICATION_WIDTH = 200;
    private static final int NOTIFICATION_HEIGHT = 300;
    public NotificationsPage() {
        if (Login.login()){
            addNotifications("Accesso eseguito");
        }
    }

    void addNotifications(String... texts){
        setSize(NOTIFICATION_WIDTH, NOTIFICATION_HEIGHT);

        var notifics = new SSPanel();
        notifics.setBorder(null);
        notifics.setLayout(new BoxLayout(notifics, BoxLayout.Y_AXIS));

        for (String text: texts) {
            var testo = new SSLabel(text);
            testo.setFont(new Font("Arial", Font.BOLD, 24));

            var gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            gbc.insets = new Insets(40, 20, 20, 20);
            notifics.add(testo);
            add(notifics, gbc);
        }

        setVisible(true);
    }


}