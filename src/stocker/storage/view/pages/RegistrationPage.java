package stocker.storage.view.pages;
import stocker.storage.view.Windows;
import stocker.storage.view.component.*;
import java.awt.*;

public class RegistrationPage extends SSPanel {
    public RegistrationPage() {
        setBorder(null);
        setBackground(Windows.LIGHT_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();

        SSTextArea registrati = new SSTextArea("Registrati");
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.insets.set(150, 50, 0, 0);
        gbc.fill = 1;

        SSContainer nome = new SSContainer();
        SingleLineText nomeText = new SingleLineText("Nome:");
        SSTextField nomeInput = new SSTextField();
        nomeInput.setPreferredSize(new Dimension(100, 50));

        nome.add(nomeText);
        nome.add(nomeInput);


        add(registrati, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);

        add(nome, gbc);
    }
}