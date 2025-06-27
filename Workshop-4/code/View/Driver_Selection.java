
import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Driver_Selection extends JFrame {

	private BorderLayout layout;
	
	public Driver_Selection() {

		layout = new BorderLayout();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(540, 500);
		
		this.setLayout(layout);

		this.setVisible(true);
		setPanels();
	}

	public void setPanels() {
		//Border/margin for the inside panels
		LineBorder coloredBorder = new LineBorder(Color.BLACK, 2);
		
		//Panel Generators
		JPanel panel2 = new JPanel();
		JPanel panel4 = new JPanel();
		
		//Panel Dimension
		panel2.setPreferredSize(new Dimension(250,100));
		panel4.setPreferredSize(new Dimension(250,100));
		
		
		//Making panel holders within panels
		panel2.setLayout(new BorderLayout(5, 5));
		panel4.setLayout(new BorderLayout(5, 5));
		
		//Sub-panels made for the left to centralize an image
		
		JPanel subPanel2A = new JPanel();
		
		JPanel subPanel2B = new JPanel();
		subPanel2B.setBackground(Color.CYAN);
		subPanel2B.add(new JLabel("Image to display"));
		subPanel2B.setBorder(coloredBorder);
		
		JPanel subPanel2C = new JPanel();
		
		subPanel2A.setPreferredSize(new Dimension(100,135));
		subPanel2B.setPreferredSize(new Dimension(100,135));
		subPanel2C.setPreferredSize(new Dimension(100,135));
		
		panel2.add(subPanel2A, BorderLayout.NORTH);
		panel2.add(subPanel2B, BorderLayout.CENTER);
		panel2.add(subPanel2C, BorderLayout.SOUTH);
		
		
		//Sub-panels made for the right so that every driver can show its car and price
		JPanel subPanel4A = new JPanel();
		subPanel4A.setBackground(Color.CYAN);
		subPanel4A.add(new JLabel("Driver1 toString method"));
		subPanel4A.setBorder(coloredBorder);
		
		JPanel subPanel4B = new JPanel();
		subPanel4B.setBackground(Color.CYAN);
		subPanel4B.add(new JLabel("Driver2 toString method"));
		subPanel4B.setBorder(coloredBorder);
		
		JPanel subPanel4C = new JPanel();
		subPanel4C.setBackground(Color.CYAN);
		subPanel4C.add(new JLabel("Driver3 toString method"));
		subPanel4C.setBorder(coloredBorder);
		

		subPanel4A.setPreferredSize(new Dimension(100,151));
		subPanel4B.setPreferredSize(new Dimension(100,151));
		subPanel4C.setPreferredSize(new Dimension(100,151));
		
		panel4.add(subPanel4A, BorderLayout.NORTH);
		panel4.add(subPanel4B, BorderLayout.CENTER);
		panel4.add(subPanel4C, BorderLayout.SOUTH);
	
		
		//Panel addition
		this.add(panel2, BorderLayout.WEST);
		this.add(panel4, BorderLayout.EAST);
		}
	
	}