/* 
 * Class PremiumCard is the class that handles most of the back-end functionality that goes
 * behind making the CardArray program. This class is constructed using a lot of helper functions 
 * to help create a program that will be used to create a card that will later be added to a deck of cards throughout
 * the program
 *  @author Abshir Mohamed
 * 	@version 1.0
 */

import java.util.*;

public class PremiumCard extends Card{

	public PremiumCard()
	{
		super();
	}
	
	public PremiumCard(int x)
	{
		super(x);
	}
	
	public PremiumCard(int Power, int Toughness)
	{
		super(Power,Toughness);
	}
	
	/**
	   * The overridden toString method returns a string containing the power and toughness of the card
	   * @returns a string containing the power and toughness of the card
*/ 
	
	public String toString()
	{
		return  "{{"+getPower() + "/" +getToughness()+"}}";
	}
	
}
