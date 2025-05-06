import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
//TODO: button.setFocusPainted(false); // Remove focus border on buttons 

public class CS2_SkinRating extends JFrame {

    public CS2_SkinRating() {
        setTitle("CS2 Skin Rating");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1024, 768));
        getContentPane().setBackground(new Color(45, 45, 45)); // Dark gray background

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10)); //Gaps
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(new Color(50, 50, 50)); 
        getContentPane().add(mainPanel);

        // Top Bar Panel
        TopBarPanel topBarPanel = new TopBarPanel();
        mainPanel.add(topBarPanel, BorderLayout.NORTH);

        // Sidebar Panel (West)
        SidebarPanel sidebarPanel = new SidebarPanel();
        mainPanel.add(sidebarPanel, BorderLayout.WEST);

        // Content Panel with Cards (Center)
        CardDisplayPanel cardDisplayPanel = new CardDisplayPanel();
        
        // Scrollbar for Content Panel
        JScrollPane scrollPane = new JScrollPane(cardDisplayPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Improve scroll speed
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom Button Panel (South)
        BottomBarPanel bottomBarPanel = new BottomBarPanel();
        mainPanel.add(bottomBarPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Center window
    }

    public static void main(String[] args) {
        // Run the GUI construction on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CS2_SkinRating().setVisible(true);
            }
        });
    }

}