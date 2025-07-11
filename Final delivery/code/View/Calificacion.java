// ... (imports) ...
/*
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Calificacion extends JFrame {

    public Calificacion() {
        setTitle("Interfaz de Calificacion de Conductor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Frame size
        setLayout(new BorderLayout());

        // --- North Panel ---
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout()); 

        // Sub-panel for User's Name y Stars
        JPanel userInfoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        userInfoPanel.add(new JLabel("User's Name:"));
        StarRatingPanel starRating = new StarRatingPanel(); // Adds the starPanel
        userInfoPanel.add(starRating);

        // Sub-panel for Car's Model y License Plate 
        JPanel carInfoPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        
        // Car picture 
        ImageIcon carIcon = new ImageIcon("images/Driver_picture.png");
        if (carIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
             carIcon = new ImageIcon(carIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        } else {
             carIcon = new ImageIcon(); // Fallback in case it doesnt load
        }
        carInfoPanel.add(new JLabel(carIcon));
        carInfoPanel.add(new JLabel("<html>Car's model<br>License plate</html>")); // HTML so it jumps to the next line

        topPanel.add(userInfoPanel, BorderLayout.WEST); // Puts the star Layuout on the left side
        topPanel.add(carInfoPanel, BorderLayout.EAST);  // Puts the car information on the right side
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margin for the upper Panel
        topPanel.setBackground(Color.LIGHT_GRAY); // Different color to white so it doesnt merge in the background

        add(topPanel, BorderLayout.NORTH);

        // --- Central Panel- MAP ---
        JPanel mapPanel = new JPanel();
        mapPanel.setBackground(Color.WHITE); // Map's panel background color
        mapPanel.setLayout(new BorderLayout()); // BorderLayout to center the map's image
     
        ImageIcon mapImage = new ImageIcon("images/map.jpg");
    
        JLabel mapLabel = new JLabel(mapImage);
        mapLabel.setHorizontalAlignment(SwingConstants.CENTER); // Aligning the image
        mapPanel.add(mapLabel, BorderLayout.CENTER); 

        add(mapPanel, BorderLayout.CENTER);

      
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.DARK_GRAY);
        southPanel.setPreferredSize(new Dimension(800, 50));
        add(southPanel, BorderLayout.SOUTH);


        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calificacion();
        });
    }
}
a
 */