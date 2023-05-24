package stocker.storage.view.pages;
import org.jetbrains.annotations.NotNull;
import stocker.storage.view.component.SSTextArea;
import java.awt.*;

public class NotificationsPage extends MessagePage {
    public NotificationsPage() {
        defaultClass();
    }

    private void defaultClass() {
        var gbc = new GridBagConstraints();

        gbc.fill = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets.set(150, 50, 0, 0);

        var basicText = new SSTextArea("Nessuna notifica");
        basicText.setAutoLineWrap(true);

        add(basicText, gbc);
    }

    public int addNotifications(String @NotNull ...texts) {
        return addMessage(texts);
    }

    public void removeNotification(int id) {
        removeMessage(id);
        if(!containsMessages()) defaultClass();
    }
}