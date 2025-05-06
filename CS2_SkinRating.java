import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File; // Import File class

//TODO: button.setFocusPainted(false); // Remove focus border on buttons

public class CS2_SkinRating extends JFrame {

    public CS2_SkinRating() {
        setTitle("CS2 Skin Rating");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1024, 768));
        getContentPane().setBackground(new Color(45, 45, 45)); // Dark gray background

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10)); //Gaps
        // Padding for the main panel
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        // Slightly lighter dark gray
        mainPanel.setBackground(new Color(50, 50, 50)); 
        getContentPane().add(mainPanel);

        // Title Label (North, rapat kiri) and Top-Right Buttons
        JLabel titleLabel = new JLabel("CS2 Skin Rating");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        
        // Panel to hold title label and top-right buttons
        JPanel topBarPanel = new JPanel(new BorderLayout()); // topBarPanel for clarity
        topBarPanel.setBackground(mainPanel.getBackground()); // Match main panel background
        topBarPanel.add(titleLabel, BorderLayout.WEST);
        // Adding 1px dark border to the bottom of the topBarPanel
        topBarPanel.setBorder
        (BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(40, 40, 40)));

        // Panel for top-right buttons
        JPanel topRightButtonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topRightButtonsPanel.setOpaque(false); // Make it transparent to show topBarPanel's background

        JButton discordButton = new JButton("Join Discord");
        discordButton.setBackground(new Color(88, 101, 242)); // Discord blue
        discordButton.setForeground(Color.WHITE);
        discordButton.setFocusPainted(false);

        JButton kofiButton = new JButton("Buy us a Ko-Fi");
        kofiButton.setBackground(new Color(255, 84, 82)); // Ko-Fi red
        kofiButton.setForeground(Color.WHITE);
        kofiButton.setFocusPainted(false);

        topRightButtonsPanel.add(discordButton);
        topRightButtonsPanel.add(kofiButton);
        
        topBarPanel.add(topRightButtonsPanel, BorderLayout.EAST);
        mainPanel.add(topBarPanel, BorderLayout.NORTH);

        // Sidebar Panel (West)
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setBackground(mainPanel.getBackground()); // Match main panel background
        sidebarPanel.setPreferredSize(new Dimension(150, 0)); // Set preferred width
        // Add a 1px dark border to the right of the sidebarPanel
        sidebarPanel.setBorder
        (BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(40, 40, 40)));

        String[] sidebarButtons = {
            "Knives", 
            "Gloves", 
            "Rifles", 
            "Pistols", 
            "SMGs", 
            "Heavy", 
            "All Skins"};
            
        for (String btnText : sidebarButtons) {
            JButton button = new JButton(btnText);
            button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 
            button.getPreferredSize().height)); // Make buttons fill width
            button.setAlignmentX(Component.CENTER_ALIGNMENT); // Center button text/content
            // Basic styling for buttons
            button.setBackground(new Color(75, 75, 75));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            sidebarPanel.add(button);
            sidebarPanel.add(Box.createRigidArea
            (new Dimension(0, 10))); // Spacing between buttons
        }
        mainPanel.add(sidebarPanel, BorderLayout.WEST);

        // Content Panel with Cards (Center) - 15 cards, 4x4 (actually 4 columns)
        // 0 rows = dynamic, 4 columns, 10px gaps [JPanel cardPanel]
        JPanel cardPanel = new JPanel(new GridLayout(0, 4, 10, 10)); 
        cardPanel.setBackground(new Color(55, 55, 55)); // Medium dark gray card area background
        cardPanel.setBorder(new EmptyBorder(10,10,10,10));

        // Image File
        String[] imageFileNames = {
            "AWP_Asiimov.png",
            "AWP_Containment Breach.png",
            "AWP_Desert Hydra.png",
            "AWP_Dragon Lore.png",
            "AWP_Fade.png",
            "AWP_Gungnir.png",
            "AWP_Hyber Beast.png",
            "AWP_Lightning Strike.png",
            "AWP_Long Dog.png",
            "AWP_Man-o'-war.png",
            "AWP_Medusa.png",
            "AWP_Neo Noir.png",
            "AWP_Printstream.png",
            "AWP_The Prince.png",
            "AWP_Wildfire.png"
        };

        String imagePathPrefix = "img" + File.separator; // Filename prefix for images

        for (String imageNameWithExtension : imageFileNames) {
            JPanel card = new JPanel(new BorderLayout());
            card.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            card.setBackground(new Color(70, 70, 70)); // Card background

            // Extract skin name from filename (remove "AWP_" prefix and ".png" suffix)
            String skinName = imageNameWithExtension.replace("AWP_", "").replace(".png", ""); // Adjusted for underscore
            JLabel cardLabel = new JLabel(skinName, SwingConstants.CENTER);
            cardLabel.setForeground(Color.LIGHT_GRAY);
            card.add(cardLabel, BorderLayout.SOUTH); // Move label to the bottom

            // Image display
            JLabel imageLabel = new JLabel(); //  this label to display the image
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            try {
                ImageIcon imageIcon = new ImageIcon(imagePathPrefix + imageNameWithExtension);
                // Resize image to fit, e.g., 150x100, while maintaining aspect ratio
                Image image = imageIcon.getImage();
                // Let's aim for a consistent height and scale width accordingly, or a fixed size
                // For simplicity, let's try to fit it into a certain dimension, e.g. 180 width
                int desiredWidth = 180; // Adjust as needed
                int originalWidth = imageIcon.getIconWidth();
                int originalHeight = imageIcon.getIconHeight();

                if (originalWidth > 0 && originalHeight > 0) { // Check if image loaded
                    int newHeight = (desiredWidth * originalHeight) / originalWidth;
                    if (newHeight > 120) { // Cap height if it becomes too large
                         newHeight = 120;
                         desiredWidth = (newHeight * originalWidth) / originalHeight;
                    }
                    Image scaledImage = image.getScaledInstance(desiredWidth, newHeight, Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(scaledImage));
                } else {
                    imageLabel.setText("No Image"); // Fallback text
                }

            } catch (Exception e) {
                imageLabel.setText("Error loading: " + imageNameWithExtension);
                e.printStackTrace(); // For debugging
            }
            // Set preferred size for layout
            imageLabel.setPreferredSize(new Dimension(180, 120)); 
            imageLabel.setOpaque(true);
            imageLabel.setBackground(new Color(85,85,85));
            imageLabel.setForeground(Color.WHITE); // For error text
            imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            card.add(imageLabel, BorderLayout.CENTER); // Add image to the center
            cardPanel.add(card);
        }

        // Scrollbar for Content Panel
        JScrollPane scrollPane = new JScrollPane(cardPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove default border of scrollpane
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Improve scroll speed
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom Button Panel (South, tombol rapat kanan)
        JPanel bottomButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomButtonPanel.setBackground(mainPanel.getBackground()); // Match main panel background

        JButton rateButton = new JButton("Rate Selected");
        JButton saveButton = new JButton("Save Ratings");
        rateButton.setBackground(new Color(75, 75, 75));
        rateButton.setForeground(Color.WHITE);
        rateButton.setFocusPainted(false);
        saveButton.setBackground(new Color(75, 75, 75));
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);

        bottomButtonPanel.add(rateButton);
        bottomButtonPanel.add(saveButton);
        mainPanel.add(bottomButtonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Center window
    }

    public static void main(String[] args) {
        // Run the GUI construction on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CS2_SkinRating().setVisible(true);
            }
        });
    }

}
// This code is a simple Swing GUI application for rating CS2 skins. It includes a title bar, sidebar with buttons, a main content area with cards representing skins, and a bottom button panel. The layout is designed to be user-friendly and visually appealing with a dark theme.