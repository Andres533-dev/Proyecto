/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class StarRatingPanel extends JPanel {

    private final int MAX_STARS = 5;
    private List<JLabel> stars;
    private ImageIcon emptyStarIcon;
    private ImageIcon filledStarIcon;
    private int currentRating = 0; 

    public StarRatingPanel() {
        // Loading all stars images
        try {
            emptyStarIcon = new ImageIcon("images/star_empty.png");
            filledStarIcon = new ImageIcon("images/star_filled.png");


            int starSize = 32; // Star's size
            Image emptyImage = emptyStarIcon.getImage().getScaledInstance(starSize, starSize, Image.SCALE_SMOOTH);
            emptyStarIcon = new ImageIcon(emptyImage);
            Image filledImage = filledStarIcon.getImage().getScaledInstance(starSize, starSize, Image.SCALE_SMOOTH);
            filledStarIcon = new ImageIcon(filledImage);

        } catch (Exception e) {
            System.err.println("Error while loading stars: " + e.getMessage());
            // Sends and error if the images don't load properly
            emptyStarIcon = new ImageIcon(); // Icono vacío
            filledStarIcon = new ImageIcon();
        }

        setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0)); // FlowLayout to align all stars
        stars = new ArrayList<>();

        for (int i = 0; i < MAX_STARS; i++) {
            JLabel star = new JLabel(emptyStarIcon); // Inits all stars empty
            star.setCursor(new Cursor(Cursor.HAND_CURSOR)); 

            final int starIndex = i + 1; // Star's value (1 to 5)
            star.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setRating(starIndex); // Sets up the Rating
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    // Highlights the possible Rating 
                    highlightStars(starIndex);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Empties all stars after the mouse isn't in contact
                    highlightStars(currentRating);
                }
            });
            stars.add(star);
            add(star);
        }
    }

    /**
     * Sets the current rating and updates the appearance of the stars.
     * @param rating The new rating (1-5).
     */
/*
    public void setRating(int rating) {
        if (rating < 0 || rating > MAX_STARS) {
            throw new IllegalArgumentException("La calificación debe estar entre 0 y " + MAX_STARS);
        }
        currentRating = rating;
        highlightStars(currentRating); // Updates the Label
    }
j
    /**
     * Updates the appearance of the stars based on a given rating
     * this is used for the final rating and for the mouseover preview.
     * @param ratingToDisplay The rating to display.
     */
/*
    private void highlightStars(int ratingToDisplay) {
        for (int i = 0; i < MAX_STARS; i++) {
            if (i < ratingToDisplay) {
                stars.get(i).setIcon(filledStarIcon);
            } else {
                stars.get(i).setIcon(emptyStarIcon);
            }
        }
    }
    y
 */

    /*
    *
     * Returns the current rating(ammount of highlighted stars).
     * @return currentRating.
     */
/*
    public int getCurrentRating() {
        return currentRating;
    }


    // --- Clase Principal para demostrar el Panel de Calificación ---
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Demo de Calificación por Estrellas");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            StarRatingPanel ratingPanel = new StarRatingPanel();
            ratingPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen alrededor
            ratingPanel.setBackground(Color.WHITE);

            // Ejemplo de cómo obtener la calificación al hacer clic en un botón
            JButton submitButton = new JButton("Obtener Calificación");
            submitButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(frame, "Calificación seleccionada: " + ratingPanel.getCurrentRating());
            });

            frame.add(ratingPanel, BorderLayout.NORTH); // Agregamos el panel de estrellas
            frame.add(submitButton, BorderLayout.SOUTH);

            frame.pack(); // Ajusta el tamaño del frame a los componentes
            frame.setLocationRelativeTo(null); // Centra el frame en la pantalla
            frame.setVisible(true);
        });
    }
}

 */