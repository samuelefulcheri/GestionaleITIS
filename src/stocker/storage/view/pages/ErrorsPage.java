package stocker.storage.view.pages;
import org.jetbrains.annotations.NotNull;
import stocker.storage.view.component.SSTextArea;
import java.awt.*;

public class ErrorsPage extends MessagePage {
    public ErrorsPage() {
        defaultClass();
    }

    private void defaultClass() {
        var gbc = new GridBagConstraints();

        gbc.fill = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets.set(150, 50, 0, 0);

        var basicText = new SSTextArea("Al momento tutto sembra funzionare correttamente...");
        basicText.setAutoLineWrap(true);

        add(basicText, gbc);
    }

    public int addErrors(String @NotNull ...texts) {
        return addMessage(texts);
    }

    public void removeError(int id) {
        removeMessage(id);
        if(!containsMessages()) defaultClass();
    }
}