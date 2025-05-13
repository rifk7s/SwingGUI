import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;
// import java.util.Random;

public class SkinCard extends JPanel {
    private final Random random = new Random(); // Menjadikan Random sebagai variabel instance

    public SkinCard(String imageNameWithExtension, String imagePathPrefix) {
        super(new BorderLayout());
        // Mengatur nama kartu, berguna untuk listener
        setName(imageNameWithExtension.replace(".png", ""));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2)); // Border awal, akan dikelola oleh listener
        setBackground(new Color(70, 70, 70)); // Warna latar belakang kartu

        final String originalSkinName = imageNameWithExtension.replace(".png", ""); // Final untuk digunakan dalam inner class
        String displaySkinName = originalSkinName; // Ini akan dimodifikasi untuk label

        // Menghapus awalan kategori untuk tampilan
        if (imagePathPrefix.contains("AWP")) {
            displaySkinName = displaySkinName.replace("AWP_", "");
        } else if (imagePathPrefix.contains("Knife")) {
            displaySkinName = displaySkinName.replace("Knife_", ""); // Asumsi gambar pisau mungkin juga memiliki awalan
            // Jika pisau memiliki awalan yang berbeda (mis. Bayonet_Knife_Autotronic -> Autotronic)
            // Penghapusan awalan yang lebih canggih mungkin diperlukan. Ini hanya contoh dasar.
            if (displaySkinName.contains("_")) { // misalnya Bayonet_Knife_Autotronic
                displaySkinName = displaySkinName.substring(displaySkinName.lastIndexOf("_") + 1);
            }
        }

        JLabel cardLabel = new JLabel(displaySkinName, SwingConstants.CENTER);
        cardLabel.setForeground(Color.LIGHT_GRAY);
        add(cardLabel, BorderLayout.SOUTH);

        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        try {
            ImageIcon imageIcon = new ImageIcon(imagePathPrefix + imageNameWithExtension);
            Image image = imageIcon.getImage();
            int desiredWidth = 180;
            int originalWidth = imageIcon.getIconWidth();
            int originalHeight = imageIcon.getIconHeight();

            if (originalWidth > 0 && originalHeight > 0) {
                int newHeight = (desiredWidth * originalHeight) / originalWidth;
                if (newHeight > 120) {
                    newHeight = 120;
                    desiredWidth = (newHeight * originalWidth) / originalHeight;
                }
                Image scaledImage = image.getScaledInstance(desiredWidth, newHeight, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaledImage));
            } else {
                imageLabel.setText("No Image");
            }
        } catch (Exception e) {
            imageLabel.setText("Error loading: " + imageNameWithExtension.substring(0, Math.min(imageNameWithExtension.length(), 15)) + "...");
            // e.printStackTrace(); // Simpan untuk debugging jika diperlukan
        }
        imageLabel.setPreferredSize(new Dimension(180, 120)); 
        imageLabel.setOpaque(true);
        imageLabel.setBackground(new Color(85,85,85));
        imageLabel.setForeground(Color.WHITE);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(imageLabel, BorderLayout.CENTER);

        // Menambahkan mouse listener untuk menampilkan dialog saat diklik
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Menghasilkan detail acak untuk dialog
                String[] conditions = {"Factory New", "Minimal Wear", "Field-Tested", "Well-Worn", "Battle-Scarred"};
                String condition = conditions[random.nextInt(conditions.length)];
                float floatValue = random.nextFloat();
                int stattrak = random.nextInt(500);
                double price = 5 + (5000 - 5) * random.nextDouble(); // Harga acak antara $5 dan $5000

                String details = String.format(
                    "Skin: %s%nCondition: %s%nFloat Value: %.4f%nStattrak™ Kills: %d%nEstimated Price: $%.2f",
                    originalSkinName, condition, floatValue, stattrak, price // Menggunakan originalSkinName yang final
                );

                JOptionPane.showMessageDialog(
                    SkinCard.this,
                    details,
                    "Skin Details - " + originalSkinName, // Menggunakan originalSkinName yang final
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // Menyesuaikan tampilan tombol JOptionPane
        // Pengaturan ini akan berlaku secara global untuk JButton yang tidak memiliki properti yang diatur secara individual setelah titik ini.
        UIManager.put("Button.focus", new Color(0, 0, 0, 0)); // Membuat highlight fokus (garis titik-titik) menjadi transparan
        UIManager.put("Button.border", BorderFactory.createEmptyBorder(4, 15, 4, 15)); // Menghapus border, menambahkan padding

        // Menyesuaikan warna latar belakang dan warna depan tombol dari Button.java untuk konsistensi di JOptionPane
        UIManager.put("Button.background", new Color(75, 75, 75));
        UIManager.put("Button.foreground", Color.WHITE);

        // Baris berikut mengontrol border untuk area yang berisi tombol di JOptionPane.
        // Mengaturnya ke empty border dapat membantu jika ada kotak yang tidak diinginkan di sekitar tombol.
        UIManager.put("OptionPane.buttonAreaBorder", BorderFactory.createEmptyBorder(5, 0, 0, 0)); // Sesuaikan padding sesuai kebutuhan
    }
}
