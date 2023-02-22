package stocker.storage.view.pages;
import stocker.storage.controller.Login;
import stocker.storage.view.Windows;
import stocker.storage.view.component.*;
import javax.swing.*;
import java.awt.*;

// TODO: Fixare scritta

public class LoginPage extends SSPanel {
    private final SSTextField nameField = new SSTextField(20);
    private final SSTextField emailField = new SSTextField(20);
    private final SSPasswordField passwordField = new SSPasswordField(20);

    public LoginPage() {
        setBorder(null);
        setBackground(Windows.LIGHT_GRAY);
        setLayout(new GridBagLayout());


        GridBagConstraints gbc = new GridBagConstraints();

        SSTextArea registrati = new SSTextArea("Login");

        gbc.insets.set(10, 10, 10, 10);
        gbc.fill = 1;
        gbc.gridwidth = 2;

        add(registrati, gbc);

        SSLabel emailLabel = new SSLabel("Email:");

        gbc.gridy = 1;
        gbc.gridwidth = 1;

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
        registerButton.setColor(Windows.LIGHTER_GRAY);
        registerButton.setBackground(Windows.LIGHTER_GRAY);
        registerButton.setPreferredSize(new Dimension(0, 50));

        registerButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            Login.login(name, email, password);

            JOptionPane.showMessageDialog(null, "Accesso effettuato.");
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        add(registerButton, gbc);
    }
}