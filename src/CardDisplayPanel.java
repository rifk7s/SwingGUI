import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

public class CardDisplayPanel extends JPanel {

    public CardDisplayPanel() {
        super(new GridLayout(0, 4, 10, 10));
        setBackground(new Color(65, 65, 65)); 
        setBorder(new EmptyBorder(10,10,10,10));
        updateDisplay("AWP"); // Load AWP skins by default
    }

    public void updateDisplay(String category) {
        removeAll(); // Clear existing cards

        String[] imageFileNames;
        String imagePathPrefix;

        if ("AWP".equalsIgnoreCase(category)) {
            imageFileNames = new String[]{
                "AWP_Asiimov.png", "AWP_Containment Breach.png", "AWP_Desert Hydra.png",
                "AWP_Dragon Lore.png", "AWP_Fade.png", "AWP_Gungnir.png",
                "AWP_Hyber Beast.png", "AWP_Lightning Strike.png", "AWP_Long Dog.png",
                "AWP_Man-o'-war.png", "AWP_Medusa.png", "AWP_Neo Noir.png",
                "AWP_Printstream.png", "AWP_The Prince.png", "AWP_Wildfire.png"
            };
            imagePathPrefix = "img" + File.separator + "AWP" + File.separator;
        } else if ("Knife".equalsIgnoreCase(category)) {
            imageFileNames = new String[]{
                "Bayonet_Knife_Autotronic.png", "Bowie_Knife_Black_Laminate.png",
                "Butterfly_Knife_Freehand.png", "Classic_Knife_Night_Stripe.png",
                "Falchion_Knife_Gamma_Doppler.png", "Flip_Knife_Fade.png",
                "Huntsman_Knife_Bright Water.png", "Karambit_Knife_Slaughter.png",
                "Kukri_Knife_Crimson_Web.png", "M9_Bayonet_Knife_Damascus_Steel.png",
                "Nomad_Knife_Rust_Coat.png", "Paracord_Knife_Doppler.png",
                "Shadow_Daggers_Lore.png", "Skeleton_Knife_Tiger_Tooth.png",
                "Survival_Knife_Marble_Fade.png"
            };
            imagePathPrefix = "img" + File.separator + "Knife" + File.separator;
        } else {
            // Default or empty state
            imageFileNames = new String[0];
            imagePathPrefix = "";
        }

        for (String imageNameWithExtension : imageFileNames) {
            SkinCard card = new SkinCard(imageNameWithExtension, imagePathPrefix);
            add(card);
        }

        revalidate();
        repaint();
    }
}
