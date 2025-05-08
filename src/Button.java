import javax.swing.*;
import java.awt.*;

public class Button extends JPanel {

    public Button() {
        super();
        // Setup layout and styling properties
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(50, 50, 50)); // Match main panel background
        setPreferredSize(new Dimension(170, 0)); // Sidebar width
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(40, 40, 40))); // Keep 1px right border
    }
}