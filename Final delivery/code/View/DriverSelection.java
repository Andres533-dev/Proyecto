package Proyecto.Code.src.View;

import Proyecto.Code.src.Controler.Driver;
import Proyecto.Code.src.Model.User;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;

public class DriverSelection extends Create {
	private User user;
	private static double selectedPrice; // To store the selected car's price

	public DriverSelection(User user) throws IOException {
		this.user = user;
		super("Driver Selection");
	}

	@Override
	protected JPanel createPanel() throws IOException {
		String[] carTypes = new String[]{"Xl", "Normal", "Fast"};
		JPanel panel = new JPanel(new GridLayout(2, 3, 10, 10));

		for (int i = 1; i <= 3; i++) {
			Driver dc = new Driver(carTypes[i-1], user);
			JPanel subPanel = createSubPanel(dc, carTypes[i-1], i);
			panel.add(subPanel);
		}
		return panel;
	}

	private JPanel createSubPanel(Driver driver, String carType, int number) {
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
		subPanel.setBackground(Color.CYAN);
		subPanel.setBorder(new LineBorder(Color.BLACK, 2));
		subPanel.setPreferredSize(new Dimension(200, 250));

		// 1. Image
		addImageToPanel(subPanel);

		// 2. Information labels
		JLabel typeLabel = new JLabel("Car Type: " + carType);
		typeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		subPanel.add(typeLabel);

		JLabel capacityLabel = new JLabel("Capacity: " + driver.getCar("User"));
		capacityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		subPanel.add(capacityLabel);

		// Extract price from the string (assuming format "Price: $XX.XX")
		String priceStr = driver.getPrice("User");
		double price = Double.parseDouble(priceStr.replaceAll("[^\\d.]", ""));

		JLabel priceLabel = new JLabel("Price: " + priceStr);
		priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		subPanel.add(priceLabel);

		JLabel timeToUserLabel = new JLabel("Time to you: " + driver.getTimeToUser("User")+"mins");
		timeToUserLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		subPanel.add(timeToUserLabel);

		// 3. Button with action listener
		addButtonToPanel(subPanel, price, carType);

		return subPanel;
	}

	private void addImageToPanel(JPanel panel) {
		ImageIcon originalIcon = new ImageIcon("car.jpg");
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		JLabel imageLabel = new JLabel(scaledIcon);
		imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		imageLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

		panel.add(imageLabel);
	}

	private void addButtonToPanel(JPanel panel, double price, String carType) {
		JButton button = new JButton("Select");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setMaximumSize(new Dimension(120, 30));
		button.setBackground(new Color(70, 130, 180));
		button.setForeground(Color.WHITE);

		// Action listener for the button
		button.addActionListener(e -> {
			try {
				// Store the selected price
				selectedPrice = price;

				// Show payment selection with the price
				PaymentSelection paymentSelection = new PaymentSelection();
				paymentSelection.setPrice(price); // Pass the price to payment selection
				Create.showPanel("Payment Selection");

				// Optional: Show confirmation message
				JOptionPane.showMessageDialog(null,
						"Selected: " + carType + "\nPrice: $" + price,
						"Selection Confirmation",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException ex) {
				System.out.println("Error in driver selection: " + ex.getMessage());
				JOptionPane.showMessageDialog(null,
						"Error processing selection",
						"Error",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(button);
	}

	// Getter for the selected price
	public static double getSelectedPrice() {
		return selectedPrice;
	}
}