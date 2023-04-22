package stocker.storage.view.pages;
import stocker.storage.view.SSWindow;
import stocker.storage.view.component.SSLabel;
import stocker.storage.view.component.SSPanel;
import stocker.storage.view.component.SSTextArea;
import javax.swing.*;
import java.awt.*;

public class ErrorsPage extends SSPanel {
    public ErrorsPage() {
        setBorder(null);
        setBackground(SSWindow.LIGHT_GRAY);


        var errorsPanel = new SSPanel();
        errorsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        var gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = 1;

        add(errorsPanel, gbc);

        var errorPanel = new SSPanel();
        errorPanel.setBorder(BorderFactory.createLineBorder(SSWindow.DARK_GRAY, 1));

        gbc.weightx = 1;
        gbc.weighty = .2;

        var errorTextTitle = new SSLabel("ERRORE:");
        errorTextTitle.setFont(new Font("Arial", Font.PLAIN, 40));
        errorTextTitle.setForeground(Color.red);
        errorPanel.add(errorTextTitle, gbc);

        gbc.weighty = .8;
        gbc.gridy = 1;

        var errorText = new SSTextArea("C'è stato un errore nel programma.");
        errorText.setFont(SSWindow.PLAIN_FONT);
        errorText.setLineWrap(false);
        errorText.setWrapStyleWord(false);
        errorPanel.add(errorText, gbc);

        errorsPanel.add(errorPanel);
    }
}