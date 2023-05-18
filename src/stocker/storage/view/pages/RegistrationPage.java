package stocker.storage.view.pages;
import org.jetbrains.annotations.NotNull;
import stocker.storage.Main;
import stocker.storage.controller.Login;
import stocker.storage.view.SSWindow;
import stocker.storage.view.component.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistrationPage extends SSPanel {
    private final SSTextField nameField;
    private final SSTextField emailField;
    private final SSPasswordField passwordField;

    public RegistrationPage() {
        setBorder(null);
        setBackground(SSWindow.LIGHT_GRAY);
        setLayout(new GridBagLayout());

        nameField = new SSTextField(20);
        emailField = new SSTextField(50);
        passwordField = new SSPasswordField(20);

        var gbc = new GridBagConstraints();

        var registrati = new SSTextArea("Registrati");
        registrati.setLineWrap(false);

        gbc.fill = 1;
        gbc.insets.set(10, 10, 10, 10);
        gbc.gridwidth = 4;

        add(registrati, gbc);

        var nameLabel = new SSLabel("Nome:");

        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.fill = 1;
        gbc.gridwidth = 1;

        add(nameLabel, gbc);

        nameField.setPreferredSize(new Dimension(0, 35));
        gbc.gridx = 2;
        add(nameField, gbc);

        var emailLabel = new SSLabel("Email:");

        gbc.gridx = 1;
        gbc.gridy = 2;

        add(emailLabel, gbc);

        emailField.setPreferredSize(new Dimension(0, 35));
        gbc.gridx = 2;
        add(emailField, gbc);

        var passwordLabel = new SSLabel("Password:");

        gbc.gridx = 1;
        gbc.gridy = 3;

        add(passwordLabel, gbc);

        passwordField.setPreferredSize(new Dimension(0, 35));
        gbc.gridx = 2;
        add(passwordField, gbc);

        var registerButton = new SSButton("Registrati");
        registerButton.setColor(SSWindow.LIGHTER_GRAY);
        registerButton.setBackground(SSWindow.LIGHTER_GRAY);
        registerButton.setPreferredSize(new Dimension(0, 50));

        registerButton.addActionListener(e -> azionePulsante());

        var keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(@NotNull KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) azionePulsante();
            }
        }; Main.window.addKeyListener(keyListener);
        nameField.addKeyListener(keyListener);
        emailField.addKeyListener(keyListener);
        passwordField.addKeyListener(keyListener);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;

        add(registerButton, gbc);
    }

    private void azionePulsante() {
        var name = nameField.getText().trim();
        var email = emailField.getText().replaceAll(" ", "");
        var password = new String(passwordField.getPassword());

        var errorMessages = Login.nameValidation(name) +
                Login.emailValidation(email) +
                Login.passwordValidation(password);

        if(errorMessages.isEmpty()) {
            var safeName = Login.encode(name);
            email = Login.encode(email);
            password = Login.encode(password);

            if(Login.register(safeName, email, password)) {
                SSWindow.notificationsPage.addNotifications("Registrazione effettuata!", "Benvenuto " + name + "!");
                new Message("Registrazione effettuata!", "Benvenuto " + name + "!", true);
                SSWindow.currentStatus = Pages.LOGIN_PAGE;
                SSWindow.cambiaPagina();
            }else{
                SSWindow.notificationsPage.addNotifications("E-Mail o Password errate.");
                new Message("E-Mail o Password errate.");
            }
        }else{
            SSWindow.errorsPage.addErrors(errorMessages);
            new Message(errorMessages);
        }
    }
}