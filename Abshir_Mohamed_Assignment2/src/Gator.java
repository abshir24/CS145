
/**
* The Gator Class handles the properties of its own class as well as the properties of the Critter class
* @author Abshir Mohamed
* @version 1.0

*/

import java.awt.*;

public class Gator extends Critter{
	public Action getMove(CritterInfo info) {
		/**
	 	   * getMove function creates a specific move for critter
	 	   * based on the critters location on the board
	 	   * @returns specific action based on critters location on the board
	   */  
		if(info.getFront() == Neighbor.SAME && info.getFront() == Neighbor.OTHER )
	    	 return Action.INFECT;
	    else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL)
	    	 return Action.RIGHT;
		if(info.getFront() == Neighbor.SAME)
	    	 return Action.LEFT;
	    else
	    	 return Action.HOP;
		
	}
		
	public Color getColor() {
	/**
	 	   * getColor function retrieves the current color of the animal
	 	   * @returns Color for animal
	   */  
	     return Color.BLACK;
	}
		
	 public String toString() {
		 /**
	 	   * toString function that returns a string object containing the animals unique information
	 	   * @returns string object containing animal info
	   */  
	      return "G";
	 }
}
