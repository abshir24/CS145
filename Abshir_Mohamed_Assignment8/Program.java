/* CS145
 * Class Program is the driver program for the Cards program.  It creates a new instance of the Gui
 * object and sets runs the Gui so that the user can begin using the program
 * @author Abshir Mohamed
 * 	@version 1.0
 */
 

import java.awt.Dimension;

import javax.swing.JFrame;

public class Program {

	public static void main(String[] args)
	{
		GUI gui = new GUI();
		
		gui.setSize(new Dimension(500,250));
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setLocationRelativeTo(null);
	}
}
