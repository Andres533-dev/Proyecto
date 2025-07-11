package Proyecto.Code.src.View;/*
 * This file contains the frontend to the card data request for 
 * online payment
 */
import javax.swing.*;

import java.awt.Dimension;
import java.awt.Font;

import java.util.List;
import java.util.ArrayList;

public class Panel extends JFrame {

	private JButton  button;
	private List<JTextField> fields;
	private SpringLayout layout;
	private List<JLabel> labels;
	
	public Panel(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.layout = new SpringLayout();
		
		button = new JButton("Submit");
		button.setPreferredSize(new Dimension(150, 25));
		
		setupLabels();
		setupTextFields();

		
		setupLayout();
		setupPanel();
	}
	
	private void setupLabels() {
		labels = new ArrayList<>(); // Starts the label's array
		String[] labelTexts = {"CC Number:", "CC Exp Date:", "CVV:", "Country:"}; // Texts per label

		for (int i = 0; i < 4; i++) {
			JLabel label = new JLabel(labelTexts[i]); // Creates the label with each corresponding text
			label.setFont(new Font("Arial", Font.BOLD, 25));
			labels.add(label); // Adds the label to the list
		}
		
	}
	
	
	private void setupTextFields() {
		fields = new ArrayList<>();
		
			for(int i = 0; i < 4; i++ ) {
				JTextField textField = new JTextField();
				textField.setPreferredSize(new Dimension(300, 25));
				textField.setFont(new Font("Arial", Font.BOLD, 22));
				fields.add(textField);
			}
	}
	
	private void setupPanel() {
		
		this.setLayout(layout);
		this.setPreferredSize(new Dimension (405, 600));
		this.add(button);
		
		//Cycle to add both labels and fields
		for(int i= 0; i < labels.size(); i++) {
			this.add(labels.get(i));
			this.add(fields.get(i));
		}
		
		this.pack();
		this.setVisible(true);
		
	}
	
	private void setupLayout() {
		int i;
		for (i = 0; i < labels.size(); i++) {
			JLabel currentLabel = labels.get(i);
			JTextField currentTextField = fields.get(i);

			layout.putConstraint(SpringLayout.WEST, currentLabel, 50, SpringLayout.WEST, this); 

			if (i == 0) {
				layout.putConstraint(SpringLayout.NORTH, currentLabel, 100, SpringLayout.NORTH, this);
			} else {
				layout.putConstraint(SpringLayout.NORTH, currentLabel, 15, SpringLayout.SOUTH, fields.get(i-1));
			}

			layout.putConstraint(SpringLayout.WEST, currentTextField, 0, SpringLayout.WEST, currentLabel); 
			layout.putConstraint(SpringLayout.NORTH, currentTextField, 35, SpringLayout.NORTH, currentLabel);
		}
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, button, 0, SpringLayout.HORIZONTAL_CENTER, fields.get(i-1));
		layout.putConstraint(SpringLayout.NORTH, button, 50, SpringLayout.SOUTH, fields.get(i-1));
	}
}
