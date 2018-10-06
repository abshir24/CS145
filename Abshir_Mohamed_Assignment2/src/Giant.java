
/**
* The Giant Class handles the properties of its own class as well as the properties of the Critter class
* @author Abshir Mohamed
* @version 1.0

*/

import java.awt.*;


public class Giant extends Critter{
	private int moveCounter;
	
	private String phrase;
	
	
	public Giant() {
		moveCounter = 0;
		
		phrase = "fee";
	}
	public Action getMove(CritterInfo info) {
		/**
	 	   * getMove function creates a specific move for critter
	 	   * based on the critters location on the board
	 	   * @returns specific action based on critters location on the board
	   */  
		if(moveCounter == 6)
		{
			switch(phrase)
			{
				case "fee":
					phrase = "fie";
					break;
				case "fie":
					phrase = "foe";
					break;
				case "foe":
					phrase = "fum";
					break;
				default:
					phrase = "fee";
					break;
			}
			
			moveCounter = 0;
		}else {
			moveCounter++;
		}
			
		
		if(info.getFront() == Neighbor.OTHER)
	    	 return Action.INFECT;
	    else if(info.getFront() == Neighbor.EMPTY)
	    	 return Action.HOP;
	    else
	    	 return Action.RIGHT;
    }
	
	public Color getColor() {
		/**
	 	   * getColor function retrieves the current color of the animal
	 	   * @returns Color for animal
	   */ 
        return Color.GRAY;
    }
	
    public String toString() {
    	 /**
	 	   * toString function that returns a string object containing the animals unique information
	 	   * @returns string object containing animal info
	   */  
        return phrase;
    }
}
