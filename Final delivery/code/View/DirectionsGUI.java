package Proyecto.Code.src.View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DirectionsGUI {
    public JButton submitButton;
    public JButton backButton;
    private ArrayList<JTextField> fields;
    private final SpringLayout layout;
    private ArrayList<JLabel> labels;
    private final JPanel pane;
    private JComboBox<String> directionComboBox;
    private JLabel comboBoxLabel;

    public DirectionsGUI(String[] labelTexts,String [] dataAvenues) {
        pane = new JPanel();
        layout = new SpringLayout();
        submitButton = new JButton("Submit");
        backButton = new JButton("Back");
        setUpComboBox(dataAvenues);
        setUpLabels(labelTexts);
        setupTextFields();
        setupLayout();
    }
    public void setUpComboBox(String[]dataAvenues){
        directionComboBox = new JComboBox<>(dataAvenues);
        directionComboBox.setFont(new Font("Arial", Font.BOLD, 20));
        directionComboBox.setPreferredSize(new Dimension(300, 30));
    }
    public void setUpLabels(String[] labelTexts) {
        comboBoxLabel = new JLabel("Select the Avenue:");
        comboBoxLabel.setFont(new Font("Arial", Font.BOLD, 25));
        labels = new ArrayList<>();
        for (String labelText : labelTexts) {
            JLabel label = new JLabel(labelText);
            label.setFont(new Font("Arial", Font.BOLD, 25));
            labels.add(label);
        }
    }

    public void setupTextFields() {
        fields = new ArrayList<>();
        for (int i = 0; i < labels.size(); i++) {
            JTextField textField = new JTextField();
            textField.setPreferredSize(new Dimension(300, 25));
            textField.setFont(new Font("Arial", Font.BOLD, 22));
            fields.add(textField);
        }
    }

    public void setupLayout() {
        layout.putConstraint(SpringLayout.WEST, comboBoxLabel, 50, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, comboBoxLabel, 20, SpringLayout.NORTH, pane);

        // Posicionar el ComboBox debajo del label
        layout.putConstraint(SpringLayout.WEST, directionComboBox, 50, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, directionComboBox, 5, SpringLayout.SOUTH, comboBoxLabel); // 5px de separación

        // Position labels and fields below the combo box
        for (int i = 0; i < labels.size(); i++) {
            JLabel currentLabel = labels.get(i);
            JTextField currentTextField = fields.get(i);

            layout.putConstraint(SpringLayout.WEST, currentLabel, 50, SpringLayout.WEST, pane);

            if (i == 0) {
                layout.putConstraint(SpringLayout.NORTH, currentLabel, 20, SpringLayout.SOUTH, directionComboBox);
            } else {
                layout.putConstraint(SpringLayout.NORTH, currentLabel, 15, SpringLayout.SOUTH, fields.get(i - 1));
            }

            layout.putConstraint(SpringLayout.WEST, currentTextField, 0, SpringLayout.WEST, currentLabel);
            layout.putConstraint(SpringLayout.NORTH, currentTextField, 35, SpringLayout.NORTH, currentLabel);
        }

        // Position buttons relative to the last field
        int lastIndex = labels.size() - 1;
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, submitButton, 0, SpringLayout.HORIZONTAL_CENTER, fields.get(lastIndex));
        layout.putConstraint(SpringLayout.NORTH, submitButton, 50, SpringLayout.SOUTH, fields.get(lastIndex));
        layout.putConstraint(SpringLayout.NORTH, backButton, 0, SpringLayout.NORTH, submitButton);
        layout.putConstraint(SpringLayout.EAST, backButton, -10, SpringLayout.WEST, submitButton);
    }

    public JPanel setUpPanel() {
        pane.setLayout(layout);
        pane.add(submitButton);
        pane.add(backButton);
        pane.add(comboBoxLabel);
        pane.add(directionComboBox);
        for (int i = 0; i < labels.size(); i++) {
            pane.add(labels.get(i));
            pane.add(fields.get(i));
        }
        return pane;
    }

    public ArrayList<String> getFormData() {
        ArrayList<String> data = new ArrayList<>();
        // Add the selected direction type first
        data.add((String) directionComboBox.getSelectedItem());
        // Add the field values
        for (JTextField field : fields) {
            data.add(field.getText());
        }
        return data;
    }
}
