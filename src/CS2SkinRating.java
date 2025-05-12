import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
// import javax.swing.WindowConstants; // Added for static access
// import javax.swing.ScrollPaneConstants; // Added for static access

public class CS2SkinRating extends JFrame {

    public CS2SkinRating() {
        setTitle("CS2 Skin Rating");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
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

        // Content Panel with Cards
        CardDisplayPanel cardDisplayPanel = new CardDisplayPanel();

        // Sidebar Panel
        SidebarPanel sidebarPanel = new SidebarPanel(cardDisplayPanel); // Pass cardDisplayPanel

        // Scrollbar for Content Panel
        JScrollPane scrollPane = new JScrollPane(cardDisplayPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED); 
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Improve scroll speed

        // Split Pane for Sidebar and Content
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebarPanel, scrollPane);
        splitPane.setDividerLocation(170); // Initial width for the sidebar + some padding
        splitPane.setDividerSize(2); // Adjust Divider Size into any pixel () value
        splitPane.setBorder(BorderFactory.createEmptyBorder()); // Remove split pane border if desired
        splitPane.setContinuousLayout(true); // Optional: updates layout continuously while dragging
        splitPane.setResizeWeight(0); // Optional: sidebar width is fixed, content area resizes

        mainPanel.add(splitPane, BorderLayout.CENTER); // Add JSplitPane instead of sidebar and scrollpane directly

        // Bottom Button Panel (South)
        BottomBarPanel bottomBarPanel = new BottomBarPanel();
        mainPanel.add(bottomBarPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Center window
    }

    public static void main(String[] args) {
        // Run the GUI construction on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new CS2SkinRating().setVisible(true)); // Changed to lambda
    }
}