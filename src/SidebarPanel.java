import javax.swing.*;
import java.awt.*;

public class SidebarPanel extends JPanel {

    public SidebarPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(50, 50, 50)); // Match main panel background
        setPreferredSize(new Dimension(170, 0)); // Sidebar width
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(40, 40, 40))); // Keep 1px right border

        String[] sidebarButtonLabels = {
            "Home", 
            "Knives", 
            "Gloves", 
            "Rifles", 
            "Pistols", 
            "SMGs", 
            "Heavy", 
            "All Skins"
        };
            
        int buttonWidth = 140; // Desired width for the buttons, less than sidebar width
        int buttonHeightPadding = 10; // Padding for button height

        for (String btnText : sidebarButtonLabels) {
            JButton button = new JButton(btnText);
            
            // Set preferred and maximum size for the button to control its width
            Dimension buttonSize = new Dimension(buttonWidth, button.getPreferredSize().height + buttonHeightPadding);
            button.setPreferredSize(buttonSize);
            button.setMaximumSize(buttonSize); // Constrain button width
            
            button.setAlignmentX(Component.CENTER_ALIGNMENT); // Align button itself in the center of its allocated space

            button.setBackground(new Color(75, 75, 75));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setBorderPainted(false);

            add(button);
            add(Box.createRigidArea(new Dimension(0, 10))); // Spacing between buttons
        }
    }
}
