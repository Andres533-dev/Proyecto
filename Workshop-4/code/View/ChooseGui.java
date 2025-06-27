package Proyecto.Code.src.View;
import javax.swing.*;
import java.awt.*;

public class ChooseGui {
    private JPanel buttonPanel;
    private JLabel label;
    private JPanel pane;
    public ChooseGui(String[] labelsText) {
        pane = new JPanel();
        buttonPanel = new JPanel();
        this.setUpLabel(labelsText);
        this.setUppButton(labelsText);
        this.setUpPanel();
        this.setUpFrame();

    }
    public void setUpLabel(String [] labelsText) {
        label = new JLabel(labelsText[0]);
        label.setFont(new Font("Arial", Font.BOLD, 50));

    }
    public void setUppButton(String [] labelsText) {
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 0));
        for (int i = 1; i <=labelsText.length-1; i++) {
            JButton button = new JButton(labelsText[i]); // Creates the label with each corresponding text
            button.setFont(new Font("Arial", Font.BOLD, 25));
            button.setPreferredSize(new Dimension(200, 60));
            buttonPanel.add(button);
        }

    }
    public void setUpPanel() {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 20, 10);
        pane.add(label, gbc);
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        pane.add(buttonPanel, gbc);

    }
    public void setUpFrame(){
        JFrame frame= new JFrame("Proyecto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(pane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
