import javax.swing.*;
import java.awt.*;

public class TopBarPanel extends JPanel {

    public TopBarPanel() {
        super(new BorderLayout());
        setBackground(new Color(50, 50, 50)); // Match main panel background
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(40, 40, 40)));

        JLabel titleLabel = new JLabel("CS2 Skin Rating");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel, BorderLayout.WEST);

        JPanel topRightButtonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topRightButtonsPanel.setOpaque(false); // Make it transparent

        JButton discordButton = Button.createButton("Join Discord", new Color(88, 101, 242)); // Use factory method with custom color

        JButton kofiButton = Button.createButton("Buy us a Ko-Fi", new Color(255, 84, 82)); // Use factory method with custom color

        topRightButtonsPanel.add(discordButton);
        topRightButtonsPanel.add(kofiButton);

        add(topRightButtonsPanel, BorderLayout.EAST);
    }
}
