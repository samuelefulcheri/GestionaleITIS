package stocker.storage.view.pages;
import org.jetbrains.annotations.NotNull;
import stocker.storage.view.SSWindow;
import stocker.storage.view.component.*;
import javax.swing.*;
import java.awt.*;

public class NotificationsPage extends SSPanel {
    private static final int NOTIFICATION_WIDTH = 200;
    private static final int NOTIFICATION_HEIGHT = 300;


    public void addNotifications(String @NotNull ...texts) {
        setSize(NOTIFICATION_WIDTH, NOTIFICATION_HEIGHT);

        var notification = new SSPanel();
        notification.setBorder(null);
        notification.setLayout(new BoxLayout(notification, BoxLayout.Y_AXIS));

        for(var text: texts) {
            var testo = new SSLabel(text);
            testo.setFont(SSWindow.PLAIN_FONT);
            notification.add(testo);

            var gbc = new GridBagConstraints();

            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            gbc.insets.set(40, 20, 20, 20);

            add(notification, gbc);
        }

        setVisible(true);
    }
}