
public class Dog implements Animal {

	private String Name;
	
	
	public Dog(String name)
	{
		Name = name;
	}
	
	public String makeSound()
	{
		return "woof";
	}
	
	public String toString()
	{
		return Name + " the dog";
	}
	
	public String getName()
	{
		return Name;
	}
}
