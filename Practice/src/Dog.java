/**
* The Dog Class handles the properties of its own class as well as the properties of the puppy class
* @author Abshir Mohamed
* @version 1.0

*/
public class Dog implements Animal {

	private String Name;
	
	
	public Dog(String name)
	{
		/**
	 	   * Constructor function for the dog class
	 	   * @param string that contains the name of the animal
	   */
		
		Name = name;
	}
	
	public String makeSound()
	{
		/**
	 	   * This is used from the interface
	 	   * @return sound that this particular animal makes
	   */
		
		return "woof";
	}
	
	public String toString()
	{
		/**
	 	   * This is used to override the traditional to string method
	 	   * @return the name of the animal and what type of animal it is
	   */
		
		return Name + " the dog";
	}
	
	public String getName()
	{
		/**
	 	   * This is used to get the name of the animal
	 	   * @return name of animal
	   */
		
		return Name;
	}
}
