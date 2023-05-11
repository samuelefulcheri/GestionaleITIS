package stocker.storage.view;
import stocker.storage.Main;
import stocker.storage.view.component.SSPanel;
import stocker.storage.view.component.SSScrollPane;
import stocker.storage.view.pages.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.PrintWriter;

public class SSWindow extends JFrame {
    public static final Color DARK_GRAY = new Color(32, 34, 37);
    public static final Color GRAY = new Color(54, 57, 63);
    public static final Color LIGHT_GRAY = new Color(64, 68, 75);
    public static final Color LIGHTER_GRAY = new Color(88, 91, 97);

    public static final Font PLAIN_FONT = new Font("ArialBold", Font.PLAIN, 18);
    public static final Font TITLE_FONT = new Font("ArialBold", Font.BOLD, 100);

    public static final Border SS_BORDER = BorderFactory.createLineBorder(SSWindow.DARK_GRAY);

    private static SSPanel componentPanel;

    public static Pages currentStatus;
    private static Pages previousStatus;

    private static WelcomePage welcomePage;
    private static StoragePage storagePage;
    private static RegistrationPage registrationPage;
    private static LoginPage loginPage;
    public static ErrorsPage errorsPage = new ErrorsPage();
    public static NotificationsPage notificationsPage = new NotificationsPage();

    public SSWindow() {
        super("Stocker Storage");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        getContentPane().setBackground(GRAY);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try(var newFile = new PrintWriter("saves\\user" + Main.extension)) {
                    newFile.print(Main.currentUser);
                }catch(Exception ignored) { }

                System.exit(0);
            }
        });

        var screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();

        var buttonsPanel = new ButtonsPanel();
        buttonsPanel.setPreferredSize(new Dimension((int) (screenWidth*.2), 0));
        add(buttonsPanel, BorderLayout.WEST);

        componentPanel = new SSPanel();
        componentPanel.setBorder(null);

        var scroll = new SSScrollPane(componentPanel);
        scroll.setPreferredSize(new Dimension((int) (screenWidth*.8), 0));

        add(scroll);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                var width = getWidth();
                buttonsPanel.setPreferredSize(new Dimension((int) (width*.2), 0));
                scroll.setPreferredSize(new Dimension((int) (width*.8), 0));
            }
        });

        addWindowStateListener(e -> {
            var width = getSize().width;
            buttonsPanel.setPreferredSize(new Dimension((int) (width*.2), 0));
            scroll.setPreferredSize(new Dimension((int) (width*.8), 0));
        });

        try{
            var image = ImageIO.read(new File("saves\\icon.png"));
            setIconImage(image);
        }catch(Exception ignored) { }

        setVisible(true);
    }

    public void welcomePage() {
        previousStatus = Pages.WELCOME_PAGE;
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
                component = errorsPage;
                previousStatus = Pages.ERRORS_PAGE;
            } case NOTIFICATIONS_PAGE -> {
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
        Main.window.setVisible(true);
    }
}