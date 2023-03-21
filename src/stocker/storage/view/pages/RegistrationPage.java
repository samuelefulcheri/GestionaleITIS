package stocker.storage.view.pages;
import stocker.storage.controller.Login;
import stocker.storage.view.Windows;
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
        setBackground(Windows.LIGHT_GRAY);
        setLayout(new GridBagLayout());

        nameField = new SSTextField(20);
        emailField = new SSTextField(50);
        passwordField = new SSPasswordField(20);

        var gbc = new GridBagConstraints();

        var registrati = new SSTextArea("Registrati");
        registrati.setLineWrap(false);

        gbc.gridy = 0;
        gbc.gridx = 0;
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
        registerButton.setColor(Windows.LIGHTER_GRAY);
        registerButton.setBackground(Windows.LIGHTER_GRAY);
        registerButton.setPreferredSize(new Dimension(0, 50));

        registerButton.addActionListener(e -> azionePulsante());

        //TODO: Farlo funzionante
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) azionePulsante();
            }
        });

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

        System.out.println(Login.nameValidation(name));

        if(errorMessages.isEmpty()) {
            var safeName = Login.encode(name);
            email = Login.encode(email);
            password = Login.encode(password);

            if(Login.register(safeName, email, password)) {
                new Message("Registrazione effettuata!", "Benvenuto " + name + "!", true);
                Windows.currentStatus = Pages.LOGIN_PAGE;
                Windows.cambiaPagina();
            }else new Message("E-Mail o Password errate.");
        }else new Message(errorMessages);
    }
}