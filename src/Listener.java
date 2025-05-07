import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Listener extends MouseAdapter {

    private final JPanel card; // Reference to the card to modify its appearance
    private final Border defaultBorder;
    private final Border hoverBorder;
    private final Border clickedBorder;

    public Listener(JPanel card) {
        this.card = card;
        this.defaultBorder = BorderFactory.createLineBorder(Color.DARK_GRAY, 2);
        this.hoverBorder = BorderFactory.createLineBorder(new Color(0, 150, 255), 2); // A blue hover border
        this.clickedBorder = BorderFactory.createLineBorder(new Color(0, 255, 150), 3); // A greenish clicked border
        
        // Ensure the card has the default border initially
        this.card.setBorder(this.defaultBorder);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("SkinCard clicked: " + card.getName()); // Assuming card name might be set
        card.setBorder(clickedBorder); 
        // You can add logic here to "select" the card or perform other actions
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Only change to hover border if not already clicked
        if (card.getBorder() != clickedBorder) {
            card.setBorder(hoverBorder);
        }
        System.out.println("Mouse entered SkinCard: " + card.getName());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Only change back to default if not clicked
        if (card.getBorder() != clickedBorder) {
            card.setBorder(defaultBorder);
        }
        System.out.println("Mouse exited SkinCard: " + card.getName());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Could also change border on press for immediate feedback
        // card.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // If you changed border on press, revert or set to clicked state here
        // if (card.getBorder() != clickedBorder) { // Avoid changing if it was a click that set it
        //    card.setBorder(hoverBorder); // Revert to hover if mouse is still over
        // }
    }
}