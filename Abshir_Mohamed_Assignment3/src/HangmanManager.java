
/* 
 * Class HangmanManger is the class that handles most of the back-end functionality that goes
 * behind making the game. This class is constructed using a lot of helper functions to emulate
 * a challenging hang-man game that allows the cpu to generate a new word from a list of words everytime
 * the user picks a new letter.
 *  @author Abshir Mohamed
 * 	@version 1.0
 */


import java.util.*;
import java.io.*;
public class HangmanManager {
	
	private int length,guesses;
	private String word,rPattern="";
	private Set<String>words;
	private SortedSet<Character>lGuessed = new TreeSet<>();
	
	private Map<String,Set<String>> map = new TreeMap<>();
	
	
	/**
	   * The main constructor for this class
	   * @param Dictionary is an empty list of strings that will be filled using the retrieve words
	   * method
	   * @param len is a designated length for a word which is chosen by the user
	   * @param max is the max amount of guesses that a user can have before the program ends
 */  
	public  HangmanManager (List<String>Dictionary,int len,int max)
	{
		if(len<1 || max < 0)
			throw new IllegalArgumentException("Length of word must be greater than 0 and max cannot be a negative number");
		
		words = retrieveWords(Dictionary,len);
		
		length = len;
		
		guesses = max;
		
		for(int i = 0;i<length;i++)
			rPattern+="-";
		
	}
	
	/**
	   * The retrieve words function retrieves a list of words from a text file based on the number of characters
	   * in the word and places them into a list.
	   * @param Dictionary is an empty list of strings that will be filled using the retrieve words
	   * method
	   * @param len is a designated length for a word which is chosen by the user
	   * @returns A list filled with words that have the designated length that the user picked
*/ 
	public Set<String> retrieveWords(List<String> dictionary, int len)
	{	
		Set<String> returnSet = new TreeSet<>();
		
		for(int i = 0;i<dictionary.size();i++)
			if(dictionary.get(i).length() == len)
				returnSet.add(dictionary.get(i));
		
		return returnSet;
	}
	
	
	/**
	   * The pattern method returns the pattern of characters guessed successfully
	   
	   * @returns pattern guessed successfully i.e "--e-a"
*/ 
	public String pattern()
	{
		return rPattern;
	}
	
	
	/**
	   * The record method word method is the method that handles the change of direction that the cpu will take 
	   * to ensure that the user has the hardest time picking the correct word. This function records a character
	   * and at the same time creates a word tree from the list of words brought in from the file that will make the 
	   * task of choosing the correct word very difficult for the user
	   * @param c is the character guessed by the user
	   * @returns the number of instances that character appears in the word
	 */ 
	public int record(char c)
	{
		
		if(guesses<1)
			throw new IllegalArgumentException("No guesses left");
		else if (words.isEmpty())
			throw new IllegalArgumentException("Not enough words in list to make a guess from");
		else if(lGuessed.contains(c))
			throw new IllegalArgumentException("You have already guessed this word before");
		else {
			guesses--;
			
			lGuessed.add(c);
			
			if(words.size() == 1)
			{
				setWord();
				
				fillPattern(c);
				
				resetPattern();
				
			}
			else 
				patternTree(c);
			
			return letterOccurence(c);
			
		}
		
	}
	
	/**
	   * The patternTree function uses a Map to associate family patterns with the set of words that have each pattern. 
	   * If there is a tie (two of the word families are of equal size), you should pick the one that occurs earlier in the Map 
	   * (i.e., the one whose key comes up first when you iterate over the key set). 
	   * The set of words representing the biggest family then becomes the dictionary for the next round.
	   * @param c is the character guessed by the user
*/ 
	public void patternTree(char c)
	{
		for(String x: words)
		{
			Set<String> valueSet = new HashSet<>();
			
			if(x.contains(""+c))
			{
				String keyPattern = "";
				
				for(int i = 0;i<x.length();i++)
				{
					if(x.charAt(i)!=c)
						keyPattern+='-';
					else
						keyPattern+=c;
				}
				
				if(!map.containsKey(keyPattern))
				{
					valueSet.add(x);
					map.put(keyPattern, valueSet);
				}else {
					map.get(keyPattern).add(x);
				}
			}
			else {
				if(!map.containsKey(pattern()))
				{
					valueSet.add(x);
					map.put(pattern(), valueSet);
				}else {
					map.get(pattern()).add(x);
				}
			}
		}
		
		resetWords();
	
	}
	
	/**
	   * The resetWords function resets the set of words that the cpu can pick from based on the 
	   * key that has the set with the biggest size as its value.
*/ 
	public void resetWords()
	{
		
		int maxLen = 0;
		
		String maxKey = "";
		
		
		for(String x : map.keySet())
		{
			if(map.get(x).size() > maxLen)
			{
				maxLen = map.get(x).size();
				
				maxKey = x;
			}
		}
		
		
		rPattern = maxKey;
		words = map.get(maxKey);
		map = new HashMap<>();
	}
	
	/**
	   * The fillPattern function resets the pattern displayed in the game and 
	   * adds the correct letter that was guessed by the user to the pattern.
	   * @param c character guessed by the user
	 */ 
	
	public void fillPattern(char c)
	{
		
		if(word.contains(""+c))
		{
			
			int index = 0;
			
			String temp ="";
			
			while(word.charAt(index)!=c)
				index++;
			
			
			for(int i = 0;i<rPattern.length();i++)
			{
				if(i == index)
					temp+=word.charAt(i);
				else
					temp+=rPattern.charAt(i);
			}
			
			rPattern = temp;
		}
	}
	
	/**
	   * The letterOccurence function checks to see how may times the letter guessed by the user 
	   * occurs in the word and also updates the pattern displayed on the game screen
	   * @param character guessed by user
	   * @return the number of times the character occurs in the word
	 */ 
	public int letterOccurence(char c)
	{
		int count = 0;
		
		for(int i = 0;i<rPattern.length();i++)
			if(rPattern.charAt(i) == c)
				count++;
		
		return count;
	}
	
	
	/**
	   * The resetPattern function resets the pattern displayed in the game and 
	   * adds the correct letter that was guessed by the user to the pattern.
	 */ 
	
	public void resetPattern()
	{
		String temp = "";
		
		for(int i = 0;i<word.length();i++)
		{
			if(lGuessed.contains(word.charAt(i)))
				temp+=word.charAt(i);
			else
				temp += "-";
				
		}
		
		rPattern = temp;
	}
	
	/**
	   * The setWord function gets called when there is only one word in the words set
	   * and that word gets set to be the final word.
	 */ 
	
	public void setWord()
	{
		for(String x : words)
			word = x;
	}
	
	/**
	   * The client calls this method to get access to the current set 
	   * of words being considered by the HangmanManager.
	   * @returns the set of words back to the HangmanManger
	 */ 
	
	public Set<String>words()
	{
		return words;
	}
	
	/**
	   * The client calls this method to find out how many guesses the player has left.
	   * @returns the number of guesses left to the user
	 */ 
	
	public int guessesLeft()
	{
		return guesses;
	}
	
	/**
	   *The client calls this method to find out the current set of letters 
	   * that have been guessed by the user.
	   * @returns the set of letters guessed by the user
	 */ 
	public SortedSet<Character> guesses()
	{
		return lGuessed;
	}
	
	
	
	
	

}
