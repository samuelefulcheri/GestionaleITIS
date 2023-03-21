package stocker.storage.view.pages;
import stocker.storage.Main;
import stocker.storage.controller.Login;
import stocker.storage.view.Windows;
import stocker.storage.view.component.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginPage extends SSPanel {
    private final SSTextField emailField;
    private final SSPasswordField passwordField;

    public LoginPage() {
        setBorder(null);
        setBackground(Windows.LIGHT_GRAY);
        setLayout(new GridBagLayout());

        emailField = new SSTextField(50);
        passwordField = new SSPasswordField(20);

        var gbc = new GridBagConstraints();

        var login = new SSTextArea("Login");
        login.setLineWrap(false);

        gbc.insets.set(10, 10, 10, 10);
        gbc.fill = 1;
        gbc.gridwidth = 2;

        add(login, gbc);

        var emailLabel = new SSLabel("Email:");

        gbc.gridy = 1;
        gbc.gridwidth = 1;

        add(emailLabel, gbc);

        emailField.setPreferredSize(new Dimension(0, 35));
        gbc.gridx = 1;
        add(emailField, gbc);

        var passwordLabel = new SSLabel("Password:");

        gbc.gridx = 0;
        gbc.gridy = 2;

        add(passwordLabel, gbc);

        passwordField.setPreferredSize(new Dimension(0, 35));
        gbc.gridx = 1;
        add(passwordField, gbc);

        var loginButton = new SSButton("Login");
        loginButton.setColor(Windows.LIGHTER_GRAY);
        loginButton.setBackground(Windows.LIGHTER_GRAY);
        loginButton.setPreferredSize(new Dimension(0, 50));

        loginButton.addActionListener(e -> azionePulsante());

        //TODO: Farlo funzionante
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) azionePulsante();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        add(loginButton, gbc);
    }

    public void azionePulsante() {
        var email = Login.encode(emailField.getText().replaceAll(" ", ""));
        var password = Login.encode(new String(passwordField.getPassword()));

        if(Login.login(email, password)) {
            new Message("Accesso effettuato", "Benvenuto " + Login.decode(Main.currentUser.name()) + "!", true);
            Windows.currentStatus = Pages.WELCOME_PAGE;
            Windows.cambiaPagina();
        }else new Message("E-Mail o Password errate.");
    }
}