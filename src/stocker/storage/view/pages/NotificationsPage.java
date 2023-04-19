package stocker.storage.view.pages;
import stocker.storage.view.SSWindow;
import stocker.storage.view.component.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotificationsPage extends SSPanel {

    private static final int NOTIFICATION_WIDTH = 200;
    private static final int NOTIFICATION_HEIGHT = 300;

    public NotificationsPage() {
        setBorder(null);
        setBackground(SSWindow.LIGHT_GRAY);


        var gbc = new GridBagConstraints();


        var notification = new SSPanel();
        notification.setBackground(SSWindow.LIGHT_GRAY);
        var text = new SSLabel("Notifications");
        text.setPreferredSize(new Dimension(400,100));
        notification.add(text);
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.insets.set(100, 50, 0, 0);
        gbc.fill = 1;
        add(notification, gbc);

        var notifyButton = new SSButton("Show Notifications");
        notifyButton.setSize(50, 20);
        notifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNotification("ciao");
            }
            public static void showNotification(String text){
                var textField = new SSTextField();
                text = textField.getText();
                var visualizza = new SSLabel(text);
            }
        });
        gbc = new GridBagConstraints();
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.gridy = 1;
        gbc.insets.set(900, 0, 0, 0);
        gbc.fill = 1;
        add(notifyButton, gbc);
    }

    private static void showNotification(String text) {
        var textField = new SSTextField();
        text = textField.getText();
        var visualizza = new SSLabel(text);

    }
}package stocker.storage.view.pages;
        import stocker.storage.view.SSWindow;
        import stocker.storage.view.component.*;

        import java.awt.*;
        import javax.swing.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class NotificationsPage extends SSPanel {

    private static final int NOTIFICATION_WIDTH = 200;
    private static final int NOTIFICATION_HEIGHT = 300;

    public NotificationsPage() {
        setBorder(null);
        setBackground(SSWindow.LIGHT_GRAY);


        var gbc = new GridBagConstraints();


        var notification = new SSPanel();
        notification.setBackground(SSWindow.LIGHT_GRAY);
        var text = new SSLabel("Notifications");
        text.setPreferredSize(new Dimension(400,100));
        notification.add(text);
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.insets.set(100, 50, 0, 0);
        gbc.fill = 1;
        add(notification, gbc);

        var notifyButton = new SSButton("Show Notifications");
        notifyButton.setSize(50, 20);
        notifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNotification("ciao");
            }
            public static void showNotification(String text){
                var textField = new SSTextField();
                text = textField.getText();
                var visualizza = new SSLabel(text);
            }
        });
        gbc = new GridBagConstraints();
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.gridy = 1;
        gbc.insets.set(900, 0, 0, 0);
        gbc.fill = 1;
        add(notifyButton, gbc);
    }

    private static void showNotification(String text) {
        var textField = new SSTextField();
        text = textField.getText();
        var visualizza = new SSLabel(text);

    }
}