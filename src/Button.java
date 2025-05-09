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

    // Factory method for creating a JButton with default styling
    public static JButton createButton(String text) {
        // Default background color for most buttons
        return createButton(text, new Color(75, 75, 75));
    }

    // Factory method for creating a JButton with a custom background color
    public static JButton createButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        return button;
    }
}