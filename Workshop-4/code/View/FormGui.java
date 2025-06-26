package View;
/*
 * This file contains the frontend to the card data request for 
 * online payment
 */
import javax.swing.*;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import java.util.ArrayList;

public class FormGui extends JFrame {

	private JButton  button;
	private List<JTextField> fields;
	private SpringLayout layout;
	private List<JLabel> labels;
	private JPanel pane;
	
	public FormGui(String[] labelTexts){
    pane = new JPanel();
    layout = new SpringLayout();
    button = new JButton("Submit");
    setupLabels(labelTexts);
    setupTextFields();
    //layoutPanel();
    setupLayout();
    setupPanel();
	setUpFrame();
	}
	
	/*
	 * This method generates a Label required for the ammount of data (4)
	 * that is required to verify the ownership and the payment
	 */
	private void setupLabels(String[] labelTexts) {
		labels = new ArrayList<>(); // Starts the label's array
		for (int i = 0; i < labelTexts.length; i++) {
			JLabel label = new JLabel(labelTexts[i]); // Creates the label with each corresponding text
			label.setFont(new Font("Arial", Font.BOLD, 25));
			labels.add(label); // Adds the label to the list
		}
	}
	/*
	 * This method creates a textfield for each one of the labels made beforehand,
	 * this method follow the same logic as "setupLabels".
	 */
	private void setupTextFields() {
		fields = new ArrayList<>();
			for(int i = 0; i < labels.size(); i++ ) {
				JTextField textField = new JTextField();
				textField.setPreferredSize(new Dimension(300, 25));
				textField.setFont(new Font("Arial", Font.BOLD, 22));
				fields.add(textField);
			}
	}	
	/*
	 * This method works similar as a starter for the Panel to avoid 
	 * any mess within the constructor logic.
	 */
	private void setupLayout() {
		int i;
		
		//Cycle to fit each label to the panel margin and subsequently its textfield.
		for (i = 0; i < labels.size(); i++) {
			JLabel currentLabel = labels.get(i);
			JTextField currentTextField = fields.get(i);

			layout.putConstraint(SpringLayout.WEST, currentLabel, 50, SpringLayout.WEST, pane); //Left margin

			if (i == 0) {
				layout.putConstraint(SpringLayout.NORTH, currentLabel, 100, SpringLayout.NORTH, pane); //Inits the first label downwards
			} else {
				layout.putConstraint(SpringLayout.NORTH, currentLabel, 15, SpringLayout.SOUTH, fields.get(i-1)); // 15 pixels width between the next label and the last field
			}

			//Spacing between label and field on index [i]
			layout.putConstraint(SpringLayout.WEST, currentTextField, 0, SpringLayout.WEST, currentLabel); 
			layout.putConstraint(SpringLayout.NORTH, currentTextField, 35, SpringLayout.NORTH, currentLabel);
		}
		
		//Button ubication based on the last field center and south end.
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, button, 0, SpringLayout.HORIZONTAL_CENTER, fields.get(i-1));
		layout.putConstraint(SpringLayout.NORTH, button, 50, SpringLayout.SOUTH, fields.get(i-1));
	}
	private void setupPanel() {
		pane.setLayout(layout);
		pane.add(button);
		//Cycle to add both labels and fields
		for(int i= 0; i < labels.size(); i++) {
			pane.add(labels.get(i));
			pane.add(fields.get(i));
		}
		
	}
	
	/*
	 * This method establishes the dimensions and padding between each label
	 * and its corresponding textfield within the main panel, avoid modifying the values.
	 */
	
	
    /* 
	private void layoutPanel(){
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, pane, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, pane, 0, SpringLayout.VERTICAL_CENTER, this);
		
	}
	*/	
	public void setUpFrame(){
		this.setSize(500,500);
		this.setContentPane(pane);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
}

