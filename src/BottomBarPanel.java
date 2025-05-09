import javax.swing.*;
import java.awt.*;

public class BottomBarPanel extends JPanel {

    public BottomBarPanel() {
        super(new FlowLayout(FlowLayout.RIGHT));
        setBackground(new Color(50, 50, 50)); // Brighter Color Update
        setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(40, 40, 40))); 

        JButton rateButton = Button.createButton("Rate Selected"); // Use factory method
        JButton saveButton = Button.createButton("Save Ratings"); // Use factory method

        add(rateButton);
        add(saveButton);
    }
}
