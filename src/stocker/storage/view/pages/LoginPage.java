package stocker.storage.view.pages;
import org.jetbrains.annotations.NotNull;
import stocker.storage.Main;
import stocker.storage.controller.Login;
import stocker.storage.view.SSWindow;
import stocker.storage.view.component.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginPage extends SSPanel {
    private final SSTextField emailField;
    private final SSPasswordField passwordField;

    public LoginPage() {
        setBorder(null);
        setBackground(SSWindow.LIGHT_GRAY);

        emailField = new SSTextField(50);
        passwordField = new SSPasswordField(20);

        var gbc = new GridBagConstraints();

        var login = new SSTextArea("Accedi");
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

        var loginButton = new SSButton("Accedi");
        loginButton.setColor(SSWindow.LIGHTER_GRAY);
        loginButton.setPreferredSize(new Dimension(0, 50));

        loginButton.addActionListener(e -> action());

        var keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(@NotNull KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) action();
            }
        };

        Main.window.addKeyListener(keyListener);
        emailField.addKeyListener(keyListener);
        passwordField.addKeyListener(keyListener);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        add(loginButton, gbc);
    }

    public void action() {
        var email = Login.encode(emailField.getText().replaceAll(" ", ""));
        var password = Login.encode(new String(passwordField.getPassword()));

        if(Login.login(email, password)) {
            SSWindow.notificationsPage.addNotifications("Accesso effettuato", "Benvenuto " + Login.decode(Main.currentUser.name()) + "!");
            new Message("Accesso effettuato", "Benvenuto " + Login.decode(Main.currentUser.name()) + "!", true);
            SSWindow.currentStatus = Pages.WELCOME_PAGE;
            SSWindow.cambiaPagina();
        }else{
            SSWindow.errorsPage.addErrors("Email o Password errate.");
            new Message("E-Mail o Password errate.");
        }
    }
}