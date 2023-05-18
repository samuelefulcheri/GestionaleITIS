package stocker.storage.view.pages;

import org.jetbrains.annotations.NotNull;
import stocker.storage.view.SSWindow;
import stocker.storage.view.component.SSLabel;
import stocker.storage.view.component.SSPanel;

import javax.swing.*;
import java.awt.*;

public class ErrorsPage extends SSPanel {
    private static final int ERRORS_WIDTH = 200;
    private static final int ERRORS_HEIGHT = 300;

    public void addErrors(String @NotNull ...texts) {
        setSize(ERRORS_WIDTH, ERRORS_HEIGHT);

        var errors = new SSPanel();
        errors.setBorder(null);
        errors.setLayout(new BoxLayout(errors, BoxLayout.Y_AXIS));

        for(var text: texts) {
            var testo = new SSLabel(text);
            testo.setFont(SSWindow.PLAIN_FONT);
            testo.setForeground(Color.RED);
            errors.add(testo);

            var gbc = new GridBagConstraints();

            gbc.weightx = 1;
            gbc.gridx = 1;
            gbc.weighty = 1;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            gbc.insets.set(40, 20, 20, 20);

            add(errors, gbc);
        }

        setVisible(true);
    }
}
