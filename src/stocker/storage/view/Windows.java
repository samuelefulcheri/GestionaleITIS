package stocker.storage.view;
import stocker.storage.Main;
import stocker.storage.view.component.SSPanel;
import stocker.storage.view.component.SSScrollPane;
import stocker.storage.view.pages.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.PrintWriter;

public class Windows extends JFrame {
    public static final Color DARK_GRAY = new Color(32, 34, 37);
    public static final Color GRAY = new Color(54, 57, 63);
    public static final Color LIGHT_GRAY = new Color(64, 68, 75);
    public static final Color LIGHTER_GRAY = new Color(88, 91, 97);

    public static final Font PLAIN_FONT = new Font("ArialBold", Font.PLAIN, 18);
    public static final Font TITLE_FONT = new Font("ArialBold", Font.BOLD, 100);

    public static final Border SS_BORDER = BorderFactory.createLineBorder(Windows.DARK_GRAY);

    private static SSPanel componentPanel;

    public static Pages currentStatus;
    private static Pages previousStatus;

    private static WelcomePage welcomePage;
    private static StoragePage storagePage;
    private static RegistrationPage registrationPage;
    private static LoginPage loginPage;
    private static ErrorsPage errorsPage;
    private static NotificationsPage notificationsPage;

    public Windows() {
        super("Stocker Storage");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(GRAY);

        addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    var nuovoFile = new PrintWriter("saves\\user" + Main.extension);
                    nuovoFile.print(Main.currentUser);
                    nuovoFile.close();
                }catch(Exception ignored) { }

                System.exit(0);
            }

            @Override
            public void windowOpened(WindowEvent e) { }
            @Override
            public void windowClosed(WindowEvent e) { }
            @Override
            public void windowIconified(WindowEvent e) { }
            @Override
            public void windowDeiconified(WindowEvent e) { }
            @Override
            public void windowActivated(WindowEvent e) { }
            @Override
            public void windowDeactivated(WindowEvent e) { }
        });

        var buttonsPanel = new ButtonsPanel();
        var gbc = new GridBagConstraints();

        gbc.weightx = 0.15;
        gbc.weighty = 1;
        gbc.fill = 1;
        add(buttonsPanel, gbc);

        componentPanel = new SSPanel();
        componentPanel.setBorder(null);

        gbc.gridx = 1;
        gbc.weightx = 0.85;
        gbc.insets.set(5, 0, 5, 5);
        add(componentPanel, gbc);

        var scroll = new SSScrollPane(componentPanel);

        gbc.weightx = 1;
        gbc.insets.set(0, 0, 0, 0);

        add(scroll, gbc);

        try{
            var image = ImageIO.read(new File("Icon.png"));
            setIconImage(image);
        }catch(Exception ignored) { }

        setVisible(true);
    }

    public void welcomePage() {
        // TODO: Migliorare sta cosa
        currentStatus = Pages.STORAGE_PAGE;
        previousStatus = Pages.WELCOME_PAGE;
        cambiaPagina();
        currentStatus = Pages.WELCOME_PAGE;
        cambiaPagina();
    }

    public static void cambiaPagina() {
        JComponent component;

        try{
            switch(previousStatus) {
                case WELCOME_PAGE -> componentPanel.remove(welcomePage);
                case STORAGE_PAGE -> componentPanel.remove(storagePage);
                case REGISTRATION_PAGE -> componentPanel.remove(registrationPage);
                case LOGIN_PAGE -> componentPanel.remove(loginPage);
                case ERRORS_PAGE -> componentPanel.remove(errorsPage);
                case NOTIFICATIONS_PAGE -> componentPanel.remove(notificationsPage);
                default -> {
                    System.out.println("Errore: previousStatus = " + previousStatus);
                    return;
                }
            }
        }catch(Exception e) {
            if(previousStatus != Pages.WELCOME_PAGE) {
                System.out.println("Errore");
                System.out.println("previousPage: " + previousStatus);
                System.out.println("currentPage: " + currentStatus);
                return;
            }
        }

        switch(currentStatus) {
            case WELCOME_PAGE -> {
                welcomePage = new WelcomePage();
                component = welcomePage;
                previousStatus = Pages.WELCOME_PAGE;
            } case STORAGE_PAGE -> {
                storagePage = new StoragePage();
                component = storagePage;
                previousStatus = Pages.STORAGE_PAGE;
            } case REGISTRATION_PAGE -> {
                registrationPage = new RegistrationPage();
                component = registrationPage;
                previousStatus = Pages.REGISTRATION_PAGE;
            } case LOGIN_PAGE -> {
                loginPage = new LoginPage();
                component = loginPage;
                previousStatus = Pages.LOGIN_PAGE;
            } case ERRORS_PAGE -> {
                errorsPage = new ErrorsPage();
                component = errorsPage;
                previousStatus = Pages.ERRORS_PAGE;
            } case NOTIFICATIONS_PAGE -> {
                notificationsPage = new NotificationsPage();
                component = notificationsPage;
                previousStatus = Pages.NOTIFICATIONS_PAGE;
            } default -> {
                System.out.println("Errore: currentStatus = " + currentStatus);
                return;
            }
        }

        var gbc = new GridBagConstraints();

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = 1;

        componentPanel.add(component, gbc);
        Main.windows.setVisible(true);
    }
}

