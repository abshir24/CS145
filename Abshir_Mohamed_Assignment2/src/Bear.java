import java.awt.*;

/**
* The Bear Class handles the properties of its own class as well as the properties of the Critter class
* @author Abshir Mohamed
* @version 1.0

*/
public class Bear extends Critter {
	private boolean polar;
	
	private String critterSymbol;
	
	
	public Bear(boolean color)
	{
		polar = color;
		
		critterSymbol = "/";
	}
	public Action getMove(CritterInfo info) {
		/**
	 	   * getMove function creates a specific move for critter
	 	   * based on the critters location on the board
	 	   * @returns specific action based on critters location on the board
	   */  
		
		critterSymbol = (critterSymbol == "/") ? "\\" : "/";
		//Changes the toString method to return a different symbol for every move
		
		if(info.getFront() == Neighbor.OTHER)
	    	 return Action.INFECT;
	    else if(info.getFront() == Neighbor.EMPTY)
	    	 return Action.HOP;
	    else
	    	 return Action.LEFT;
	}
		
	public Color getColor() {
		/**
	 	   * getColor function retrieves the current color of the animal
	 	   * @returns Color for animal
	   */ 
		//IF the polar boolean is set to true in when the object is constructed.
		if(polar)
			return Color.WHITE;
					
	    return Color.BLACK;
	 }
		
	 public String toString() {
		 /**
	 	   * toString function that returns a string object containing the animals unique information
	 	   * @returns string object containing animal info
	   */  
	      return critterSymbol;
	 }
}
