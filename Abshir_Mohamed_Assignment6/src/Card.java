/* 
 * Class Card is the class that handles most of the back-end functionality that goes
 * behind making the CardArray program. This class is constructed using a lot of helper functions 
 * to help create a program that will be used to create a card that will later be added to a deck of cards throughout
 * the program
 *  @author Abshir Mohamed
 * 	@version 1.0
 */
 


import java.util.*;

public class Card {
	int power;
	int toughness;
	
	/**
	   * This version of the constructor creates a new card with a random power and toughness
*/ 
	public Card()
	{
		Random rand = new Random();
		
		power = rand.nextInt(1000)+1;
		
		toughness = rand.nextInt(1000)+1;
	}
	
	/**
	   * This version of the constructor takes in an integer and sets the power
	   * and toughness to that integer
	   * @param x integer to determine power and toughness of card
	   * @throws IllegalArgument exception if input is out of bounds
*/ 
	public Card(int x)
	{
		if(x<1 || x > 1000)
			throw new IllegalArgumentException("Input is out of bounds! Must be 1-1000");
		
		power = x;
		
		toughness = x;
	}
	
	/**
	   * This version of the constructor takes in an integer and sets the power
	   * and toughness to that integer
	   * @param Power integer to determine power of card
	   * @param Toughness integer to determine toughness of card
	   * @throws IllegalArgument exception if input is out of bounds
*/ 
	public Card(int Power, int Toughness)
	{
		if(( Power<1 || Power > 1000) || ( Toughness<1 || Power > 1000))
			throw new IllegalArgumentException("Input is out of bounds! Must be 1-1000");
		
		power = Power;
		
		toughness = Toughness;
	}
	
	/**
	   * getPower method returns the power of the card
	  
	   * @returns power of card
*/ 
	
	public int getPower()
	{
		return power;
	}
	
/**
	   * getToughness method returns the toughness of the card
	  
	   * @returns toughness of card
*/ 
	public int getToughness()
	{
		return toughness;
	}

	/**
	   * getCosts method returns the cost of the card
	  
	   * @returns cost of card
*/ 
	public double getCost()
	{
		return Math.round(Math.sqrt(1.5*getPower()+.9*getToughness()));
	}
	
	/**
	   * The overridden toString method returns a string containing the power and toughness of the card
	   * @returns a string containing the power and toughness of the card
*/ 
	public String toString()
	{
		return "["+power+"/"+toughness+"]";
	}
	
	/**
	   The compareTo method should implement the comparable interface for Card objects based upon the rules described above.
	   * @returns a comparable int to be used in the main program
*/ 
	
	public int compareTo(Card card)
	{
		if((card.getCost() == getCost()) && (card.getPower() == getPower()) && (card.getToughness() == getToughness()))
			return 0;
		else if((card.getCost() == getCost())&&(card.getPower() == getPower()))
				return card.getToughness() < getToughness() ? 1 : -1;
		else if(card.getCost() == getCost())
			return card.getPower() < getPower() ? 1 : -1;
		else
			return card.getCost() < getCost() ? 1 : -1;
				
	}
	
	/**
	   * Updates power and toughness
*/ 
	public void weaken()
	{
		double p = (double) power,t=(double)toughness;
		p -= p*.1;
		t -= t*.1;
		
		power = (int) p;
		
		toughness = (int)t;
	}
	
	/**
	   * Updates power and toughness
*/ 
	public void boost()
	{
		double p = (double) power,t=(double)toughness;
		p += p*.1;
		t += t*.1;
		
		power = (int) p;
		
		toughness = (int)t;
	}
}
