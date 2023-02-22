package stocker.storage.view.pages;
import stocker.storage.controller.Login;
import stocker.storage.view.Windows;
import stocker.storage.view.component.*;
import javax.swing.*;
import java.awt.*;

// TODO: Fixare scritta

public class RegistrationPage extends SSPanel {
    private final SSTextField nameField = new SSTextField(20);
    private final SSTextField emailField = new SSTextField(20);
    private final SSPasswordField passwordField = new SSPasswordField(20);

    public RegistrationPage() {
        setBorder(null);
        setBackground(Windows.LIGHT_GRAY);
        setLayout(new GridBagLayout());


        GridBagConstraints gbc = new GridBagConstraints();

        SSTextArea registrati = new SSTextArea("Registrati");

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.fill = 1;
        gbc.insets.set(10, 10, 10, 10);
        gbc.gridwidth = 4;

        add(registrati, gbc);

        SSLabel nameLabel = new SSLabel("Nome:");

        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.fill = 1;
        gbc.gridwidth = 1;

        add(nameLabel, gbc);

        nameField.setPreferredSize(new Dimension(0, 35));
        gbc.gridx = 2;
        add(nameField, gbc);

        SSLabel emailLabel = new SSLabel("Email:");

        gbc.gridx = 1;
        gbc.gridy = 2;

        add(emailLabel, gbc);

        emailField.setPreferredSize(new Dimension(0, 35));
        gbc.gridx = 2;
        add(emailField, gbc);

        SSLabel passwordLabel = new SSLabel("Password:");

        gbc.gridx = 1;
        gbc.gridy = 3;

        add(passwordLabel, gbc);

        passwordField.setPreferredSize(new Dimension(0, 35));
        gbc.gridx = 2;
        add(passwordField, gbc);

        SSButton registerButton = new SSButton("Registrati");
        registerButton.setColor(Windows.LIGHTER_GRAY);
        registerButton.setBackground(Windows.LIGHTER_GRAY);
        registerButton.setPreferredSize(new Dimension(0, 50));

        registerButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            Login.login(name, email, password);

            JOptionPane.showMessageDialog(null, "Registrazione completata!");
        });

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;

        add(registerButton, gbc);
    }
}