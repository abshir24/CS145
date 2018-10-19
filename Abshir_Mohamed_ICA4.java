/**
* The Program Class handles the main functionality of the program
* This programs purpose is to count the number of occurrences of each word in a file and determine how many of each of them there are.
* Print them out from most common to least common, printing out both the word and the count.
* @author Abshir Mohamed
* @version 1.0
*/

import java.util.*;
import java.io.*;

public class Program {

	/**
	   * Main functions handles all of the functionality for this program
	   * This function parses through a map and records all words from smallest word count to largest
	 */ 
	public static void main(String[] args)
	{
	
		Map<String,Integer> map = retrieveWords();
		
		while(!map.isEmpty())
		{
			int SMNSF = 1000;
			
			String SWSF = "";
			
			for(String x: map.keySet())
			{
				if(map.get(x) < SMNSF)
				{
					SMNSF = map.get(x);
					SWSF = x;
				}
			}
			
			System.out.println(SWSF + " " + SMNSF);
			
			map.remove(SWSF);
		}
	}
	
	/**
	   * retrieveWords parses through a file and records how many times a specific word appears in a file
	   * @throws FileNotFoundExeption
	   * @returns a map containing all the words and how many times they appear in the file
 */ 
	public static Map<String,Integer> retrieveWords()
	{	
		Map<String,Integer> returnMap = new HashMap<>();
				
		try {
			
			Scanner file = new Scanner(new File("src/DataFile1.txt"));
			
			
			while(file.hasNext())
			{
				String word = file.next();
				
				if(!returnMap.containsKey(word))
					returnMap.put(word,1);
				else
					returnMap.put(word,returnMap.get(word)+1);
			}
			
	    }catch (FileNotFoundException e) {
	    	
	        throw new AssertionError("The file is expected to exist (was supposed to be verified earlier)");
	        
	    }
		
		
		return returnMap;
	
	}
	
	
///Inefficient Solution
	
//	public static ArrayList<Integer> numberStorage(Map<String,Integer> map)
//	{
//		ArrayList<Integer> list = new ArrayList<>();
//		for(String x:map.keySet())
//		{
//			list.add(map.get(x));
//		}
//		
//		Collections.sort(list);
//		
//		return list;
//	}
//	
//	public static ArrayList<String> finalReturn(ArrayList<Integer> list,Map<String,Integer> map)
//	{
//		ArrayList<String> returnList = new ArrayList<>();
//		
//		for(int i = 0;i<list.size();i++)
//		{
//			int num = list.get(i);
//			
//			for(String x: map.keySet())
//			{
//				if(map.get(x) == num && !returnList.contains(x + " " + num ))
//					returnList.add(x + " " + num );
//			}
//		}
//		
//		return returnList;
//	}
}
