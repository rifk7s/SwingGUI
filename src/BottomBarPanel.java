import javax.swing.*;
import java.awt.*;

public class BottomBarPanel extends JPanel {

    public BottomBarPanel() {
        super(new FlowLayout(FlowLayout.RIGHT));
        setBackground(new Color(50, 50, 50)); 
        setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(40, 40, 40))); 

        JButton rateButton = Button.createButton("Rate Selected"); 
        JButton saveButton = Button.createButton("Save Ratings"); 

        add(rateButton);
        add(saveButton);
    }
}
