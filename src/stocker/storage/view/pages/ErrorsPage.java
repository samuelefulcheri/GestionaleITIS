package stocker.storage.view.pages;
import stocker.storage.view.SSWindow;
import stocker.storage.view.component.SSPanel;
import stocker.storage.view.component.SSTextArea;

import javax.swing.*;
import java.awt.*;

public class ErrorsPage extends SSPanel {
    public ErrorsPage() {
        setBorder(null);
        setBackground(SSWindow.LIGHT_GRAY);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        var errorsPage = new SSTextArea("Errors");
        errorsPage.setForeground(Color.red);
        errorsPage.setEditable(false);
        add(errorsPage);

        var errorPanel = new SSPanel();
        errorPanel.setLayout(new GridLayout(2, 1));
        errorPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        var errorTextTitle = new JLabel("ERRORE!:");
        errorTextTitle.setForeground(Color.red);
        errorPanel.add(errorTextTitle);

        var errorText = new SSTextArea("C'è stato un errore nel programma.");
        errorText.setEditable(false);
        errorPanel.add(errorText);

        add(errorPanel);
    }

        /*var gbc = new GridBagConstraints();

        var errorsPage = new SSTextArea("Errors");
        errorsPage.setForeground(Color.red);

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        //gbc.insets.set(150, 50, 0, 0);
        gbc.fill = 1;
        add(errorsPage, gbc);

        var errorPanel = new SSPanel();
        var errorText = new SSTextArea("Errore!");
        errorPanel.add(errorText, gbc);
        gbc.gridy = 1;
        add(errorPanel, gbc);*/

    }

}