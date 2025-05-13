import javax.swing.*;
import java.awt.*;

public class Button extends JPanel {

    public Button() {
        super();
        // Menyiapkan properti layout dan styling
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(50, 50, 50)); 
        setPreferredSize(new Dimension(170, 0)); // Lebar sidebar
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(40, 40, 40))); 
    }

    // Metode factory untuk membuat JButton dengan styling default
    public static JButton createButton(String text) {
        // Warna latar belakang default untuk sebagian besar tombol
        return createButton(text, new Color(75, 75, 75));
    }

    // Metode factory untuk membuat JButton dengan warna latar belakang kustom
    public static JButton createButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        return button;
    }
}