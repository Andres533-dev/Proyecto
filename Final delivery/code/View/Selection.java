package Proyecto.Code.src.View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Selection implements GUI {
    private JPanel buttonPanel;
    private JLabel label;
    private final JPanel pane;
    public ArrayList<JButton> buttons;
    public Selection(String[] labelsText) {
        pane = new JPanel();
        buttonPanel = new JPanel();
        this.setUpLabels(labelsText);
        this.setUpButton(labelsText);

    }
    public void setUpLabels(String [] labelsText) {
        label = new JLabel(labelsText[0]);
        label.setFont(new Font("Arial", Font.BOLD, 50));

    }
    public void setUpButton(String [] labelsText) {
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 0));
        buttons = new ArrayList<>();
        for (int i = 1; i <=labelsText.length-1; i++) {
            JButton button = new JButton(labelsText[i]);// Creates the label with each corresponding text
            button.setFont(new Font("Arial", Font.BOLD, 25));
            button.setPreferredSize(new Dimension(200, 60));
            buttons.add(button);
            buttonPanel.add(button);
        }

    }


    public JPanel setUpPanel() {
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
            return pane;
    }
}
