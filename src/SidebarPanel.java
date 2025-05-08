import javax.swing.*;
import java.awt.*;

public class SidebarPanel extends Button { // Changed to extend Button

    public SidebarPanel() {
        super(); // Call to superclass (Button) constructor

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
