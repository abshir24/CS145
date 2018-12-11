import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/* 
 * Class Gui handles the graphical user interface portion of the website
 * this class inherits from the JFrame object.
 *  @author Abshir Mohamed
 * 	@version 1.0
 */

public class GUI extends JFrame{
	private JButton add ;
	private JButton pop;
	private JButton clear;
	private JButton activeButton;

	private JPanel panelT;
	
	private JPanel panelC;
	
	private JPanel panelM;
	
	private JLabel label1;

	private JLabel label2;
	
	private CardHeap cardHeap;
	/**
	 * Program Constructor
	 * This constructor creates all of the buttons for the user interface as well as the grid
	 * where the buttons will be placed. It also adds event listeners to each of the buttons so that
	 * the buttons have functionality.
	 */
	public GUI() {

		// Construct Heap and Label for Heap
		cardHeap = new CardHeap();
		
		ButtonHandler handler = new ButtonHandler();

		// Construct GridPane
		panelT = new JPanel();

		panelM = new JPanel();
		
		panelC = new JPanel();
		
		panelT.setLayout(new FlowLayout());
		
		panelC.setLayout(new FlowLayout());
		
		label1 = new JLabel("[]");
		
		label1.setFont(new Font("Serif", Font.PLAIN, 25));
		
		label2 = new JLabel("[]");
		
		label2.setFont(new Font("Serif", Font.PLAIN, 25));
		
		panelT.add(label1);
		
		panelM.add(label2);
		
		add(panelT, BorderLayout.NORTH);
		
		add(panelM, BorderLayout.CENTER);
		
		add = addButton("Add",panelC);
		
		add.addActionListener(handler);

		pop = addButton("Pop",panelC);
		
		pop.addActionListener(handler);

		clear = addButton("Clear",panelC);
		
		clear.addActionListener(handler);
		
		add(panelC, BorderLayout.SOUTH);
		
	}


	/**
	 * adds a button to the panel and then returns the button so that it 
	 * may be placed in a variable
	 * @param caption the buttons caption
	 * @param panel the panel where the button will be placed
	 * @return the button added
	 */
	
	private JButton addButton(String caption,JPanel panel)
	{
			activeButton = new JButton(caption);
			
			activeButton.setPreferredSize(new Dimension(100,50));
			
			panel.add(activeButton,BorderLayout.SOUTH);
			
			return activeButton;
	}
	
	
	//Event handler class that handles the button clicks for every button in the application.
	private class ButtonHandler implements ActionListener{
		/**
		 * adds an event for every button clicked
		 * @param event uses the event object to add functionality to buttons
		 */
		public void actionPerformed(ActionEvent event){
			if(event.getSource()==add) cardHeap.add(new Card());
			else if(event.getSource()==pop) label2.setText(cardHeap.remove().toString());
			else if(event.getSource()==clear) {
				cardHeap.clear();
				label2.setText("[]");
			}
			
			label1.setText(cardHeap.toString());
		}
	}
}
