import javax.swing.*;
import java.awt.*;

public class BottomBarPanel extends JPanel {

    public BottomBarPanel() {
        super(new FlowLayout(FlowLayout.RIGHT));
        setBackground(new Color(50, 50, 50)); // Brighter Color Update
        setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(40, 40, 40))); 

        JButton rateButton = new JButton("Rate Selected");
        JButton saveButton = new JButton("Save Ratings");

        rateButton.setBackground(new Color(75, 75, 75));
        rateButton.setForeground(Color.WHITE);
        rateButton.setFocusPainted(false);

        saveButton.setBackground(new Color(75, 75, 75));
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);

        add(rateButton);
        add(saveButton);
    }
}
