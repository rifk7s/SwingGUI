import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

public class CardDisplayPanel extends JPanel {

    public CardDisplayPanel() {
        super(new GridLayout(0, 4, 10, 10));
        setBackground(new Color(65, 65, 65)); // Brighter Color Update
        setBorder(new EmptyBorder(10,10,10,10));

        String[] imageFileNames = {
            "AWP_Asiimov.png", "AWP_Containment Breach.png", "AWP_Desert Hydra.png",
            "AWP_Dragon Lore.png", "AWP_Fade.png", "AWP_Gungnir.png",
            "AWP_Hyber Beast.png", "AWP_Lightning Strike.png", "AWP_Long Dog.png",
            "AWP_Man-o'-war.png", "AWP_Medusa.png", "AWP_Neo Noir.png",
            "AWP_Printstream.png", "AWP_The Prince.png", "AWP_Wildfire.png"
        };
        String imagePathPrefix = "img" + File.separator + "AWP" + File.separator; // Updated path

        for (String imageNameWithExtension : imageFileNames) {
            SkinCard card = new SkinCard(imageNameWithExtension, imagePathPrefix);
            add(card);
        }
    }
}
