/* 
 * Class AnagramManager is the class that handles most of the back-end functionality that goes
 * behind making the Anagram program. This class is constructed using a lot of helper functions 
 * to help create a program that will find the anagram of a word that the user inputs
 *  @author Abshir Mohamed
 * 	@version 1.0
 */

import java.util.*;

public class AnagramManager {
	
	private Word[] words;
	
	/**
	   * The main constructor for this class
	   * @param list is a list of strings that contains the contents of the file
	   * @throws illegal argument exception if the list is null or the list does not contain any elements
*/  
	public AnagramManager(List<String> list)
	{
		if(list == null || list.isEmpty())
			throw new IllegalArgumentException("List cannot be empty or null!");
		
		int size = list.size();
		
		words = new Word[size];
		
		for(int i = 0;i<size; i++)
			words[i] = new Word(list.get(i));
	}
	
	/**
	   * sortByWord sorts the word array by original word alphabetically
*/ 
	public void sortByWord()
	{
		bubbleSort();
	}
	
	/**
	   * sortByWord sorts the word array by canonical word alphabetically
*/ 
	public void sortByForm()
	{
		Arrays.sort(words);
	}
	
	
	/**
	   * The getAnagram method takes a user string and retrieves an anagram for that string
	   * @param user input string
	   * @returns an anagram of that string.
*/  
	public String getAnagram(String x)
	{
		String copy = x;
		
		char[] c = x.toCharArray();
		
		Arrays.sort(c);
		
		x = new String(c);
		
		String[] cNons;
		
		int size = 0;
		
		for(int i = 0;i<words.length;i++)
		{
			if(words[i].getForm().equals(x) &&(!words[i].getWord().equals(copy)))
				size++;
		}
			
		if(size==0)
			return "";
		else
		{
			cNons = new String[size];
			
			int idx = 0;
			
			for(int i = 0;i<words.length;i++)
				if(words[i].getForm().equals(x)&&(!words[i].getWord().equals(copy)))
					cNons[idx++] = words[i].getWord();

			Random rand = new Random();
			
			
			return size > 1 ? cNons[rand.nextInt(size)+0] : cNons[0];
		}
	}
	
	
	/**
	   * The getAnagrams method takes a user string and retrieves all
	   * of the words that have the same canonical form as that string.
	   * @param user input string
	   * @returns a set of words that have the same canonical form at the user input string
*/  
	
	public Set<String> getAnagrams(String x)
	{
		char[] c = x.toCharArray();
		
		Arrays.sort(c);
		
		x = new String(c);
		
		Set<String> cNons = new TreeSet<>();
		
		for(int i = 0;i<words.length;i++)
			if(words[i].getForm().equals(x))
				cNons.add(words[i].getWord());
		
		return cNons;
	}
	
	/**
	   * The toString method should return a string that prints off the first five Words of the current array and 
	   * then print off the last five Words of the current array, depending on how it is sorted.
	   * @returns string that prints off the first five Words of the current array and 
	   * then print off the last five Words of the current array, depending on how it is sorted.
*/  
	public String toString()
	{
		int size = words.length;
		
		String returnString = "";
		
		boolean flag = false;
		
		for(int i = 0;i<size;i++)
		{
			if(i <= 4 || i>= size-6)
				returnString += words[i];
			else
				if(!flag)
				{
					returnString+="[...]";
					flag = true;
				}
		
		}
		
		return returnString;
	}
	
	
	/**
	   * The bubbleSort sorts the array of word objects by either canonical form or
	   * original word form
*/ 
	public void bubbleSort()
	{
		
		for(int x=1;x<10;x++)
		{
			for(int y=0;y<10-x;y++)
			{
				
					String word1 = words[y].getWord();
					String word2 = words[y+1].getWord();
					
					if(word1.compareTo(word2)>0)
					{
						Word temp=words[y];
						words[y]=words[y+1];
						words[y+1]=temp;
						
					}
				
			}
		}
	}
	
}
