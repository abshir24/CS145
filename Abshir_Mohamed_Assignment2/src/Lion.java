
/**
* The Lion Class handles the properties of its own class as well as the properties of the Critter class
* @author Abshir Mohamed
* @version 1.0

*/

import java.awt.*;
import java.util.Random;

public class Lion extends Critter{
	
	private int moveCounter, color;
	
	
	public Lion()
	{
		moveCounter = 0;
		color=1;
	}
	
	public Action getMove(CritterInfo info) {
		/**
	 	   * getMove function creates a specific move for critter
	 	   * based on the critters location on the board
	 	   * @returns specific action based on critters location on the board
	   */  
		if(moveCounter == 3)
		{
			Random rand = new Random();
			
			color = rand.nextInt(3)+1;
			
			moveCounter = 0;
		}
		else
			moveCounter++;
		
		if(info.getFront() == Neighbor.OTHER)
	    	 return Action.INFECT;
	    else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL)
	    	 return Action.LEFT;
		if(info.getFront() == Neighbor.SAME)
	    	 return Action.RIGHT;
	    else
	    	 return Action.HOP;
	    
	}
		
	public Color getColor() {
		/**
	 	   * getColor function retrieves the current color of the animal
	 	   * @returns Color for animal
	   */ 
		switch(color)
		{
			case 1:
				return Color.GREEN;
			case 2:
				return Color.RED;
			default:
				return Color.BLUE;
		}
	}
		
	 public String toString() {
		 /**
	 	   * toString function that returns a string object containing the animals unique information
	 	   * @returns string object containing animal info
	   */  
	      return "L";
	  }
}
