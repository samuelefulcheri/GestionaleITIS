package stocker.storage.view.pages;
import stocker.storage.controller.Login;
import stocker.storage.view.Windows;
import stocker.storage.view.component.*;
import javax.swing.*;
import java.awt.*;

public class RegistrationPage extends SSPanel {
    private final SSTextField nameField = new SSTextField(20);
    private final SSTextField emailField = new SSTextField(20);
    private final SSPasswordField passwordField = new SSPasswordField(20);

    public RegistrationPage() {
        setBorder(null);
        setBackground(Windows.LIGHT_GRAY);


        //SSTextArea registrati = new SSTextArea("Registrati");
        //gbc.weightx = 0.5;
        //gbc.weighty = 0.5;
        //gbc.insets.set(150, 50, 0, 0);
        //gbc.fill = 1;
        //add(registrati, gbc);

        GridBagConstraints gbc = new GridBagConstraints();

        SSLabel nameLabel = new SSLabel("Nome:");

        gbc.fill = 1;
        gbc.insets.set(10, 10, 10, 10);

        add(nameLabel, gbc);

        nameField.setPreferredSize(new Dimension(0, 35));
        gbc.gridx = 1;
        add(nameField, gbc);

        SSLabel emailLabel = new SSLabel("Email:");

        gbc.gridx = 0;
        gbc.gridy = 1;

        add(emailLabel, gbc);

        emailField.setPreferredSize(new Dimension(0, 35));
        gbc.gridx = 1;
        add(emailField, gbc);

        SSLabel passwordLabel = new SSLabel("Password:");

        gbc.gridx = 0;
        gbc.gridy = 2;

        add(passwordLabel, gbc);

        passwordField.setPreferredSize(new Dimension(0, 35));
        gbc.gridx = 1;
        add(passwordField, gbc);

        SSButton registerButton = new SSButton("Registrati");
        registerButton.setBackground(Windows.LIGHTER_GRAY);
        registerButton.setPreferredSize(new Dimension(0, 50));

        registerButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            Login.login(name, email, password);

            JOptionPane.showMessageDialog(null, "Registrazione completata!");
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        add(registerButton, gbc);
    }
}