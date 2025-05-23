import javax.swing.*;
import java.awt.*;

public class SidebarPanel extends Button { 

    private final CardDisplayPanel cardDisplayPanel;

    public SidebarPanel(CardDisplayPanel cardDisplayPanel) {
        super(); // Memanggil konstruktor Button, yang memanggil konstruktor JPanel dan menyiapkan layout/style
        
        this.cardDisplayPanel = cardDisplayPanel;

        String[] sidebarButtonLabels = {
            "Home", "Knives", "Gloves", "Rifles", "Pistols", "SMGs", "Heavy", "All Skins"
        };
            
        int buttonWidth = 140;
        int buttonHeightPadding = 10;

        for (String btnText : sidebarButtonLabels) {
            JButton button = Button.createButton(btnText); // Menggunakan factory statis dari kelas Button

            button.addActionListener(e -> { // Lambda untuk ActionListener
                String categoryToDisplay;
                switch (btnText) {
                    case "Home":
                    case "Gloves":
                    case "Pistols":
                    case "Heavy":
                        categoryToDisplay = "AWP";
                        break;
                    case "Knives":
                    case "Rifles":
                    case "SMGs":
                    case "All Skins":
                        categoryToDisplay = "Knife";
                        break;
                    default:
                        categoryToDisplay = ""; 
                        break;
                }
                this.cardDisplayPanel.updateDisplay(categoryToDisplay);
            });
            
            Dimension buttonSize = new Dimension(buttonWidth, button.getPreferredSize().height + buttonHeightPadding);
            button.setPreferredSize(buttonSize);
            button.setMaximumSize(buttonSize); 
            button.setAlignmentX(Component.CENTER_ALIGNMENT); 

            add(button);
            add(Box.createRigidArea(new Dimension(0, 10))); 
        }
    }
}
