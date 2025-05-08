import javax.swing.*;
import java.awt.*;

public class SkinCard extends JPanel {

    public SkinCard(String imageNameWithExtension, String imagePathPrefix) {
        super(new BorderLayout());
        // Set the name of the card, can be useful for the listener
        setName(imageNameWithExtension.replace(".png", ""));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2)); // Initial border, will be managed by listener
        setBackground(new Color(70, 70, 70)); // Card background

        String skinName = imageNameWithExtension.replace("AWP_", "").replace(".png", "");
        JLabel cardLabel = new JLabel(skinName, SwingConstants.CENTER);
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

    }
}
