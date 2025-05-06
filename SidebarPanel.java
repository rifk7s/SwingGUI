import javax.swing.*;
import java.awt.*;

public class SidebarPanel extends JPanel {

    public SidebarPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(50, 50, 50)); // Match main panel background
        setPreferredSize(new Dimension(150, 0)); // Set preferred width
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(40, 40, 40)));

        String[] sidebarButtons = {
            "Knives", 
            "Gloves", 
            "Rifles", 
            "Pistols", 
            "SMGs", 
            "Heavy", 
            "All Skins"
        };
            
        for (String btnText : sidebarButtons) {
            JButton button = new JButton(btnText);
            button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getPreferredSize().height));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setBackground(new Color(75, 75, 75));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            add(button);
            add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        }
    }
}
