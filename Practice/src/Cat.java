
public class Cat implements Animal {

	private String Name;
	
	public Cat(String name)
	{
		Name = name;
	}
	
	public String makeSound()
	{
		return "meow";
	}
	
	public String toString()
	{
		return Name + " the cat";
	}
	
	public String getName()
	{
		return Name;
	}
}
