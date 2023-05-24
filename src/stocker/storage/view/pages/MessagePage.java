package stocker.storage.view.pages;
import org.jetbrains.annotations.NotNull;
import stocker.storage.view.SSWindow;
import stocker.storage.view.component.*;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

abstract class MessagePage extends SSPanel {
    protected int messageCount;
    protected HashMap<Integer, SSPanel> messages;

    protected MessagePage() {
        messageCount = 0;
        messages = new HashMap<>();

        setBorder(null);
        setBackground(SSWindow.LIGHT_GRAY);
    }

    protected int addMessage(String @NotNull ...texts) {
        if(messageCount == 0) removeAll();

        var message = new SSPanel();
        message.setBorder(null);
        message.setLayout(new BoxLayout(message, BoxLayout.Y_AXIS));
        message.setBackground(SSWindow.LIGHT_GRAY);

        for(var text: texts) {
            var textLabel = new SSLabel(text);
            textLabel.setFont(SSWindow.PLAIN_FONT);
            message.add(textLabel);

            var gbc = new GridBagConstraints();

            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            gbc.insets.set(40, 20, 20, 20);

            add(message, gbc);
            messages.put(messageCount, message);
            messageCount++;
        }

        setVisible(true);
        return messageCount-1;
    }

    protected void removeMessage(int id) {
        var res = messages.get(id);
        if(res == null) return;
        remove(res);
        messages.remove(id);
        messageCount--;
    }

    protected boolean containsMessages() {
        return messageCount != 0;
    }
}