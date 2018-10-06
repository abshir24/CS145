/**
* The Cat Class handles the properties of its own class as well as the properties of the kitten class
* @author Abshir Mohamed
* @version 1.0

*/

public class Cat implements Animal {
	
	//Name variable
	private String Name;
	
	public Cat(String name)
	{
		/**
	 	   * Constructor function for the cat class
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
		return "meow";
	}
	
	public String toString()
	{
		/**
	 	   * This is used to override the traditional to string method
	 	   * @return the name of the animal and what type of animal it is
	   */
		return Name + " the cat";
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
