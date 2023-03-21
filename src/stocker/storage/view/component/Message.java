package stocker.storage.view.component;
import javax.swing.*;

public class Message {
    public Message(String title, String msg, boolean mode) {
        if(mode) JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
        else JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    public Message(String msg) {
        new Message("Accesso non effettuato", msg, false);
    }
}