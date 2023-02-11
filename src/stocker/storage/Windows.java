package stocker.storage;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Windows extends JFrame {
    public static final Color grigioScuro = new Color(32, 34, 37);
    public static final Color grigio = new Color(54, 57, 63);
    public static final Color grigioChiaro = new Color(64, 68, 75);
    public static final Color bianco = new Color(255, 255, 255);

    public static final Font fontScritte = new Font("ArialBold", Font.PLAIN, 18);
    public static final Font fontTitoli = new Font("ArialBold", Font.BOLD, 100);

    public static final Border bordo = BorderFactory.createLineBorder(Windows.grigioScuro);

    public Windows() {
        super("Stocker Storage");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(grigio);


        WelcomePage welcomePage = new WelcomePage();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets.set(5, 5, 5, 5);
        gbc.fill = 1;

        add(welcomePage, gbc);


        try{
            BufferedImage image = ImageIO.read(new File("Icon.png"));
            setIconImage(image);
        }catch(Exception ignored) { }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

/*
  import javax.swing.border.Border;
  Border bordo = BorderFactory.createLineBorder(new Color(32, 34, 37));
  JScrollPane scroll = new JScrollPane(<Oggetto a cui mettere la barra di scorrimento>);
  scroll.getVerticalScrollBar().setUnitIncrement(16);
  add(scroll, gbc);
*/