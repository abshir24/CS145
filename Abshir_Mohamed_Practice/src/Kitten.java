/**
* The Kitten Class handles inherets the properties of the Cat class
* @author Abshir Mohamed
* @version 1.0
*/

public class Kitten extends Cat {
	public Kitten(String name)
	{
		/**
	 	   * Constructor function for the Kitten class
	 	   * @param string that contains the name of the animal
	   */
		super(name);
		
		//Inherets properties of parent object
	}
	
	public String toString()
	{
		/**
	 	   * This is used to override the traditional to string method
	 	   * @return the name of the animal and what type of animal it is
	   */
		
		return getName() + " the kitten";
	}
	
	
}
