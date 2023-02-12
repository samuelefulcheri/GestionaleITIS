package stocker.storage;
import stocker.storage.component.SSPanel;
import stocker.storage.component.SSScrollPane;
import stocker.storage.pages.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Windows extends JFrame {
    public static final Color GRIGIO_SCURO = new Color(32, 34, 37);
    public static final Color GRIGIO = new Color(54, 57, 63);
    public static final Color GRIGIO_CHIARO = new Color(64, 68, 75);
    public static final Color BIANCO = new Color(255, 255, 255);

    public static final Font FONT_SCRITTE = new Font("ArialBold", Font.PLAIN, 18);
    public static final Font FONT_TITOLI = new Font("ArialBold", Font.BOLD, 100);

    public static final Border BORDO = BorderFactory.createLineBorder(Windows.GRIGIO_SCURO);


    private static SSPanel componentPanel;
    public static int currentStatus = 0;
    private static int previousStatus = 0;

    private static WelcomePage welcomePage;
    private static StoragePage storagePage;
    private static SecondaPagina secondaPagina;
    private static TerzaPagina terzaPagina;
    private static ErrorsPage errorsPage;
    private static NotificationsPage notificationsPage;

    public Windows() {
        super("Stocker Storage");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(GRIGIO);


        ButtonsPanel buttonsPanel = new ButtonsPanel();
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weightx = 0.15;
        gbc.weighty = 1;
        gbc.insets.set(5, 5, 5, 1);
        gbc.fill = 1;
        add(buttonsPanel, gbc);

        componentPanel = new SSPanel();
        componentPanel.setBackground(Windows.GRIGIO_CHIARO);

        gbc.gridx = 1;
        gbc.weightx = 0.85;
        gbc.insets.set(5, 0, 5, 5);
        add(componentPanel, gbc);

        SSScrollPane scroll = new SSScrollPane(componentPanel);

        gbc.weightx = 1;
        gbc.insets.set(0, 0, 0, 0);

        add(scroll, gbc);

        welcomePage = new WelcomePage();
        gbc = new GridBagConstraints();

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = 1;

        componentPanel.add(welcomePage, gbc);


        try{
            BufferedImage image = ImageIO.read(new File("Icon.png"));
            setIconImage(image);
        }catch(Exception ignored) { }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void cambiaPagina() {
        JComponent component;

        try{
            switch(previousStatus) {
                case 0 -> componentPanel.remove(welcomePage);
                case 1 -> componentPanel.remove(storagePage);
                case 2 -> componentPanel.remove(secondaPagina);
                case 3 -> componentPanel.remove(terzaPagina);
                case 4 -> componentPanel.remove(errorsPage);
                case 5 -> componentPanel.remove(notificationsPage);
                default -> {
                    System.out.println("Errore: previousStatus = " + previousStatus);
                    return;
                }
            }
        }catch(Exception e) {
            System.out.println("Errore");
            System.out.println("previousPage: " + previousStatus);
            System.out.println("currentPage: " + currentStatus);
            return;
        }

        switch(currentStatus) {
            case 1 -> {
                storagePage = new StoragePage();
                component = storagePage;
                previousStatus = 1;
            } case 2 -> {
                secondaPagina = new SecondaPagina();
                component = secondaPagina;
                previousStatus = 2;
            } case 3 -> {
                terzaPagina = new TerzaPagina();
                component = terzaPagina;
                previousStatus = 3;
            } case 4 -> {
                errorsPage = new ErrorsPage();
                component = errorsPage;
                previousStatus = 4;
            } case 5 -> {
                notificationsPage = new NotificationsPage();
                component = notificationsPage;
                previousStatus = 5;
            } default -> {
                System.out.println("Errore: currentStatus = " + currentStatus);
                return;
            }
        }

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = 1;

        componentPanel.add(component, gbc);
        Main.windows.setVisible(true);
    }
}