package Proyecto.Code.src.View;
import Proyecto.Code.src.Controler.*;
import Proyecto.Code.src.CreditCard;

import javax.swing.*;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Form  {

	private JButton  button;
	private List<JTextField> fields;
	private SpringLayout layout;
	private List<JLabel> labels;
	private JPanel pane;
	
	public Form(String[] labelTexts){
    pane = new JPanel();
    layout = new SpringLayout();
    button = new JButton("Submit");
    setupLabels(labelTexts);
    setupTextFields();
    setupLayout();
    setupPane();
	setUpFrame();
	}
	
	/*
	 * This method generates a Label required for the amount of data
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
	 * This method works similar to a starter for the Panel to avoid
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
		
		//Button location based on the last field center and south end.
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, button, 0, SpringLayout.HORIZONTAL_CENTER, fields.get(i-1));
		layout.putConstraint(SpringLayout.NORTH, button, 50, SpringLayout.SOUTH, fields.get(i-1));
	}
	private void setupPane() {
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
	public void setUpFrame(){
		JFrame frame=new JFrame();
		frame.setSize(500,500);
		frame.add(pane);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
	public List<String> Controller(JFrame frame){
		button.addActionListener(e->{
			List<String> answers = new ArrayList<>();
			for(JTextField textField : fields) {
				answers.add(textField.getText());
			}
			JLabel email=new JLabel("Email");
			JLabel name=new JLabel("Name");
			JLabel typeRoad=new JLabel("Type of road");
			JLabel cardNumber=new JLabel("Card number");
			if(labels.getFirst().equals(email)){
				try{
					LogIn();
				}
				catch (Exception ex){
					JOptionPane.showMessageDialog(frame,"Invalid input.");

				}
			}
			else if(labels.getFirst().equals(name)){
				try{
					SignUp signUp=new SignUp(answers);
				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(frame,"Invalid input.");
				}
			}
			else if(labels.getFirst().equals(typeRoad)){
				try{
					Direction();
				}
				catch (){

				}
			}
			else if(labels.getFirst().equals(cardNumber)){
				CreditCard creditCard=new CreditCard();
			}
		});
	}

}

