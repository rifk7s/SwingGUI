import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;
// import java.util.Random;

public class SkinCard extends JPanel {
    private final Random random = new Random(); // Made Random an instance variable

    public SkinCard(String imageNameWithExtension, String imagePathPrefix) {
        super(new BorderLayout());
        // Set the name of the card, can be useful for the listener
        setName(imageNameWithExtension.replace(".png", ""));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2)); // Initial border, will be managed by listener
        setBackground(new Color(70, 70, 70)); // Card background

        final String originalSkinName = imageNameWithExtension.replace(".png", ""); // Final for use in inner class
        String displaySkinName = originalSkinName; // This will be modified for the label

        // Remove category prefix for display
        if (imagePathPrefix.contains("AWP")) {
            displaySkinName = displaySkinName.replace("AWP_", "");
        } else if (imagePathPrefix.contains("Knife")) {
            displaySkinName = displaySkinName.replace("Knife_", ""); // Assuming knife images might also have a prefix
            // If knives have different prefixes (e.g., Bayonet_Knife_Autotronic -> Autotronic)
            // More sophisticated prefix removal might be needed. This is a basic example.
            if (displaySkinName.contains("_")) { //e.g. Bayonet_Knife_Autotronic
                displaySkinName = displaySkinName.substring(displaySkinName.lastIndexOf("_") + 1);
            }
        }

        JLabel cardLabel = new JLabel(displaySkinName, SwingConstants.CENTER);
        cardLabel.setForeground(Color.LIGHT_GRAY);
        add(cardLabel, BorderLayout.SOUTH);

        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        try {
            ImageIcon imageIcon = new ImageIcon(imagePathPrefix + imageNameWithExtension);
            Image image = imageIcon.getImage();
            int desiredWidth = 180;
            int originalWidth = imageIcon.getIconWidth();
            int originalHeight = imageIcon.getIconHeight();

            if (originalWidth > 0 && originalHeight > 0) {
                int newHeight = (desiredWidth * originalHeight) / originalWidth;
                if (newHeight > 120) {
                    newHeight = 120;
                    desiredWidth = (newHeight * originalWidth) / originalHeight;
                }
                Image scaledImage = image.getScaledInstance(desiredWidth, newHeight, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaledImage));
            } else {
                imageLabel.setText("No Image");
            }
        } catch (Exception e) {
            imageLabel.setText("Error loading: " + imageNameWithExtension.substring(0, Math.min(imageNameWithExtension.length(), 15)) + "...");
            // e.printStackTrace(); // Keep for debugging if needed
        }
        imageLabel.setPreferredSize(new Dimension(180, 120)); 
        imageLabel.setOpaque(true);
        imageLabel.setBackground(new Color(85,85,85));
        imageLabel.setForeground(Color.WHITE);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(imageLabel, BorderLayout.CENTER);

        // Add mouse listener to show dialog on click
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Generate random details for the dialog
                String[] conditions = {"Factory New", "Minimal Wear", "Field-Tested", "Well-Worn", "Battle-Scarred"};
                String condition = conditions[random.nextInt(conditions.length)];
                float floatValue = random.nextFloat();
                int stattrak = random.nextInt(500);
                double price = 5 + (5000 - 5) * random.nextDouble(); // Random price between $5 and $5000

                String details = String.format(
                    "Skin: %s%nCondition: %s%nFloat Value: %.4f%nStattrak™ Kills: %d%nEstimated Price: $%.2f",
                    originalSkinName, condition, floatValue, stattrak, price // Use the final originalSkinName
                );

                JOptionPane.showMessageDialog(
                    SkinCard.this,
                    details,
                    "Skin Details - " + originalSkinName, // Use the final originalSkinName
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // Customize JOptionPane button appearance
        // These settings will apply globally to JButtons that don't have their properties set individually after this point.
        UIManager.put("Button.focus", new Color(0, 0, 0, 0)); // Make focus highlight (dotted line) transparent
        UIManager.put("Button.border", BorderFactory.createEmptyBorder(4, 15, 4, 15)); // Remove border, add some padding

        // Match the background and foreground of buttons from Button.java for consistency in JOptionPane
        UIManager.put("Button.background", new Color(75, 75, 75));
        UIManager.put("Button.foreground", Color.WHITE);

        // The following line controls the border for the area containing the buttons in JOptionPane.
        // Setting it to an empty border can help if there's an unwanted box around the button(s).
        UIManager.put("OptionPane.buttonAreaBorder", BorderFactory.createEmptyBorder(5, 0, 0, 0)); // Adjust padding as needed
    }
}
