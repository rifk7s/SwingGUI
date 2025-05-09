import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidebarPanel extends Button { // Changed to extend Button

    public CardDisplayPanel cardDisplayPanel; // Add reference to CardDisplayPanel

    public SidebarPanel(CardDisplayPanel cardDisplayPanel) { // Modified constructor
        super(); // Call to superclass (Button) constructor
        this.cardDisplayPanel = cardDisplayPanel; // Store reference

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
            JButton button = Button.createButton(btnText); // Use factory method

            // Add ActionListener to buttons
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (btnText) {
                        case "Home":
                        case "Gloves":
                        case "Pistols":
                        case "Heavy":
                            cardDisplayPanel.updateDisplay("AWP");
                            break;
                        case "Knives":
                        case "Rifles":
                        case "SMGs":
                        case "All Skins":
                            cardDisplayPanel.updateDisplay("Knife");
                            break;
                        default:
                            // Fallback for any unexpected button text
                            cardDisplayPanel.updateDisplay(""); // Display nothing or a default category
                            break;
                    }
                }
            });
            
            // Set preferred and maximum size for the button to control its width
            Dimension buttonSize = new Dimension(buttonWidth, button.getPreferredSize().height + buttonHeightPadding);
            button.setPreferredSize(buttonSize);
            button.setMaximumSize(buttonSize); // Constrain button width
            
            button.setAlignmentX(Component.CENTER_ALIGNMENT); // Align button itself in the center of its allocated space

            add(button);
            add(Box.createRigidArea(new Dimension(0, 10))); // Spacing between buttons
        }
    }
}
