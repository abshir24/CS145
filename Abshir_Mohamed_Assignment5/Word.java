/* 
 * Class Word is the class that handles most of the back-end functionality that goes
 * behind making the Anagram program. This class is constructed using a lot of helper functions 
 * to help create a program that will find the anagram of a word that the user inputs
 *  @author Abshir Mohamed
 * 	@version 1.0
 */

import java.util.*;

public class Word implements Comparable<Word> {
	
	private String original,canonical;
	
	
	/**
	   * The main constructor for this class
	   * @param a word that will be used as the basis for the object
	*/  
	public Word(String x)
	{
		original = x.toLowerCase();
		
		char[] c = original.toCharArray();
		
		Arrays.sort(c);
		
		canonical = new String(c);
	
	}
	
	/**
	   * The getWord method returns the word in its original form
	*/ 
	public String getWord()
	{
		return original;
	}
	
	/**
	   * The getForm method returns the word in its canonical form
	*/ 
	public String getForm()
	{
		return canonical;
	}
	
	/**
	   * The toString method returns the word in its canonical form and original form as a concatenated string
	*/ 
	public String toString()
	{
		return "[" + original +"=" +canonical + "]";
	}
	
	/**
	   * The compareTo method compares two word objects by their canonical form
	   * @param x is the word object that will be compared
	*/ 
	public int compareTo(Word x)
	{
		return canonical.compareTo(x.getForm());
	}

}
