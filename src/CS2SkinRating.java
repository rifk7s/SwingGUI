import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
// import javax.swing.WindowConstants; // Ditambahkan untuk akses statis
// import javax.swing.ScrollPaneConstants; // Ditambahkan untuk akses statis

public class CS2SkinRating extends JFrame {

    public CS2SkinRating() {
        setTitle("CS2 Skin Rating");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        setPreferredSize(new Dimension(1024, 768));
        getContentPane().setBackground(new Color(45, 45, 45)); // Latar belakang abu-abu gelap

        // Panel utama dengan BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10)); // Jarak
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(new Color(50, 50, 50)); 
        getContentPane().add(mainPanel);

        // Panel Bar Atas
        TopBarPanel topBarPanel = new TopBarPanel();
        mainPanel.add(topBarPanel, BorderLayout.NORTH);

        // Panel Konten dengan Kartu
        CardDisplayPanel cardDisplayPanel = new CardDisplayPanel();

        // Panel Sidebar
        SidebarPanel sidebarPanel = new SidebarPanel(cardDisplayPanel); // Meneruskan cardDisplayPanel

        // Scrollbar untuk Panel Konten
        JScrollPane scrollPane = new JScrollPane(cardDisplayPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED); 
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Menghapus border default
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Meningkatkan kecepatan scroll

        // Split Pane untuk Sidebar dan Konten
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebarPanel, scrollPane);
        splitPane.setDividerLocation(170); // Lebar awal untuk sidebar + beberapa padding
        splitPane.setDividerSize(2); // Menyesuaikan ukuran pembagi ke piksel berapa pun
        splitPane.setBorder(BorderFactory.createEmptyBorder()); // Menghapus border split pane jika diinginkan
        splitPane.setContinuousLayout(true); // Opsional: memperbarui layout secara kontinu saat menyeret
        splitPane.setResizeWeight(0); // Opsional: lebar sidebar tetap, area konten dapat diubah ukurannya

        mainPanel.add(splitPane, BorderLayout.CENTER); // Menambahkan JSplitPane sebagai gantinya sidebar dan scrollpane secara langsung

        // Panel Tombol Bawah (Selatan)
        BottomBarPanel bottomBarPanel = new BottomBarPanel();
        mainPanel.add(bottomBarPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Menempatkan jendela di tengah
    }

    public static void main(String[] args) {
        // Menjalankan konstruksi GUI pada Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new CS2SkinRating().setVisible(true)); // Diubah ke lambda
    }
}