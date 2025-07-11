package Proyecto.Code.src.View;

import javax.swing.*;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Form implements GUI {

	public JButton submitButton;
	public JButton backButton;
	private List<JTextField> fields;
	private final SpringLayout layout;
	private List<JLabel> labels;
	private final JPanel pane;

	public Form(String[] labelTexts) {
		pane = new JPanel();
		layout = new SpringLayout();
		submitButton = new JButton("Submit");
		backButton = new JButton("Back");
		setUpLabels(labelTexts);
		setupTextFields();
		setupLayout();
	}

	/*
	 * This method generates a Label required for the amount of data
	 */
	public void setUpLabels(String[] labelTexts) {
		labels = new ArrayList<>(); // Starts the label's array
        for (String labelText : labelTexts) {
            JLabel label = new JLabel(labelText); // Creates the label with each corresponding text
            label.setFont(new Font("Arial", Font.BOLD, 25));
            labels.add(label); // Adds the label to the list
        }
	}

	/*
	 * This method creates a textfield for each one of the labels made beforehand,
	 * this method follow the same logic as "setupLabels".
	 */
	public void setupTextFields() {
		fields = new ArrayList<>();
		for (int i = 0; i < labels.size(); i++) {
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
	public void setupLayout() {
		int i;
		//Cycle to fit each label to the panel margin and subsequently its textfield.
		for ( i=0; i < labels.size(); i++) {
			JLabel currentLabel = labels.get(i);
			JTextField currentTextField = fields.get(i);

			layout.putConstraint(SpringLayout.WEST, currentLabel, 50, SpringLayout.WEST, pane); //Left margin

			if (i == 0) {
				layout.putConstraint(SpringLayout.NORTH, currentLabel, 100, SpringLayout.NORTH, pane); //Inits the first label downwards
			} else {
				layout.putConstraint(SpringLayout.NORTH, currentLabel, 15, SpringLayout.SOUTH, fields.get(i - 1)); // 15 pixels width between the next label and the last field
			}

			//Spacing between label and field on index [i]
			layout.putConstraint(SpringLayout.WEST, currentTextField, 0, SpringLayout.WEST, currentLabel);
			layout.putConstraint(SpringLayout.NORTH, currentTextField, 35, SpringLayout.NORTH, currentLabel);

		}
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, submitButton, 0, SpringLayout.HORIZONTAL_CENTER, fields.get(i - 1));
		layout.putConstraint(SpringLayout.NORTH, submitButton, 50, SpringLayout.SOUTH, fields.get(i - 1));
		layout.putConstraint(SpringLayout.NORTH, backButton, 0, SpringLayout.NORTH, submitButton);
		layout.putConstraint(SpringLayout.EAST, backButton, -10, SpringLayout.WEST, submitButton);

		//Button location based on the last field center and south end.
	}

	public JPanel setUpPanel() {
		pane.setLayout(layout);
		pane.add(submitButton);
		pane.add(backButton);
		//Cycle to add both labels and fields
		for (int i = 0; i < labels.size(); i++) {
			pane.add(labels.get(i));
			pane.add(fields.get(i));
		}
		return pane;

	}

	/*
	 * This method establishes the dimensions and padding between each label
	 * and its corresponding textfield within the main panel, avoid modifying the values.
	 */
	public ArrayList<String> getFormData() {
		ArrayList<String> data = new ArrayList<>();
        for (JTextField field : fields) {
            data.add(field.getText());
        }
		return data;
	}
	/*
	public void failureMessage(String message) {
		JOptionPane.showMessageDialog(frame, message, "failure", JOptionPane.ERROR_MESSAGE);
	}
	public void successfulMessage() {
		JOptionPane.showMessageDialog(frame, "Successful log in", "Successful", JOptionPane.INFORMATION_MESSAGE);
	}
	a
	 */
}

	/*
	public void Controller(JFrame frame) {
		SwingUtilities.invokeLater(() -> {
			button.addActionListener(e -> {
				List<String> answers = new ArrayList<>();
				for (JTextField textField : fields) {
					answers.add(textField.getText());
				}
				JLabel email = new JLabel("Email");
				JLabel name = new JLabel("Name");
				JLabel typeRoad = new JLabel("Type of road");
				JLabel cardNumber = new JLabel("Card number");
				if (labels.getFirst().equals(email)) {
					try {
						Login login = new Login(answers);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(frame, "Invalid input.");
					}
				} else if (labels.getFirst().equals(name)) {
					try {
						SignUp signUp = new SignUp(answers);
					} catch (RuntimeException ex) {
						JOptionPane.showMessageDialog(frame, "Invalid input.");
					}
				} else if (labels.getFirst().equals(typeRoad)) {
					try {
						int roadType = Integer.parseInt(answers.get(0));
						int streetNumber = Integer.parseInt(answers.get(1));
						int careerNumber = Integer.parseInt(answers.get(2));
						int houseNumber = Integer.parseInt(answers.get(3));
						Direction direction = new Direction(roadType, streetNumber, careerNumber, houseNumber);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(frame, "Invalid input.");
					}
				} else if (labels.getFirst().equals(cardNumber)) {
					try {
						CreditCard creditCard = new CreditCard(answers);
					} catch (RuntimeException ex) {
						JOptionPane.showMessageDialog(frame, "Invalid input.");
					}
				}
			});
		});
	}
	public static void mani(String[] args){
		String[] words={"Nombre","Apellido","Email","Contraseña"};
		Form form=new Form(words);
	}
}
*/
