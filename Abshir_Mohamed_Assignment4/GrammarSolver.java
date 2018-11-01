/* 
 * Class Grammar is the class that handles most of the back-end functionality that goes
 * behind making the Grammar program. This class is constructed using a lot of helper functions to emulate
 * a recursive grammar that generates a sentence based on user input.
 *  @author Abshir Mohamed
 * 	@version 1.0
 */


import java.io.*;
import java.util.*;

public class GrammarSolver {

	Map<String,List<String>> grammarMap = new TreeMap<>();
	
	List<String> nonTerminals = new ArrayList<>();
	
	List<String> terminals = new ArrayList<>();
	
	List<String> original;
	
	/**
	   * The main constructor for this class
	   * @param list is a list of strings that contains the contents of the file
	   * that the user selected
	   * @throws illegal argument exception if the list is null or the list does not contain any elements
	   * @throws illegal argument exception if the list contains the same non-terminal for more than 1 element.
*/  
	
	public GrammarSolver(List<String> list)
	{
		if(list.size() == 0 || list == null)
			throw new IllegalArgumentException("List cannot be empty or null!");
		
		int idx;
		String symbol;
		
		for(int i = 0;i<list.size();i++)
		{
			idx = 0;
			
			symbol = "";
			
			while(list.get(i).charAt(idx) != ':')
			{
				symbol += list.get(i).charAt(idx);
				idx++;
			}
			
			nonTerminals.add(symbol.trim());
		}
			
		for(int i = 0;i<nonTerminals.size();i++)
			for(int j = i+1;j< nonTerminals.size(); j++)
				if(nonTerminals.get(i).equals(nonTerminals.get(j)))
					throw new IllegalArgumentException("Grammar cannot contain more than 1 line for the same terminal!");
		
		original = list;
		
		
		removeNonTerminals();
		
		convertGrammarMap();
		
		System.out.println("MAP!!!!! " + grammarMap);
		
	}
	
	
	/**
	   * The contains function checks to see if the list of non-terminals contains the
	   * terminal requested by the user
	   * @param String symbol is the non-terminal requested by the user
	   * @throws an illegal argument exception if the symbol does not have any characters or 
	   * if the symbol is null
	   * @returns boolean indicating whether or not the symbol is in the list of non terminals
*/ 
	public boolean contains(String symbol)
	{
		if(symbol.length() == 0 || symbol == null)
			throw new IllegalArgumentException("Not a proper symbol");
	
		return nonTerminals.contains(symbol);
	}
	
	
	/**
	   * The getSymbols converts the nonTerminal list into a sorted
	   * TreeSet and returns that set
	   * @returns sorted TreeSet of nonterminals
*/ 
	public Set<String>getSymbols()
	{
		Set<String> nonTerminalSet = new TreeSet<>(nonTerminals);
		
		return nonTerminalSet;
	}
	
	
	/**
	   * The converGrammarMap function store the contents of the grammar into a Map.
	   * So the non-terminal symbols become keys and their rules become values.
	   * @param String symbol is the non-terminal requested by the user
*/ 
	
	public void convertGrammarMap()
	{
		String rule;
		
		for(int i = 0 ;i<nonTerminals.size();i++)
		{
			String symbol = nonTerminals.get(i);
			
			String[] lineArr = terminals.get(i).split("[|]");
			
			String line = join(lineArr), 
							terminal = "";
		
			for(int j = 0;j<lineArr.length;j++)
			{
				
				rule = lineArr[j].trim();
				
				if(grammarMap.containsKey(symbol))
					grammarMap.get(symbol).add(rule);
				else
				{
					List<String> rules = new ArrayList<>();
					
					rules.add(rule);
					
					grammarMap.put(symbol, rules);
				}
			}
		}
	}
	
	/**
	   * The generate function uses the grammar to generate a random occurrence of the given symbol and returns it as a String. 
	   * @param String symbol is the non-terminal requested by the user
	   * @throws an illegal argument exception if the symbol does not have any characters or 
	   * if the symbol is null
	   * @returns a randomly generated string with a random occurrence of the given symbol.
*/ 
	
	public String generate(String symbol)
	{
		if(symbol == null || symbol.length() == 0)
			throw new IllegalArgumentException("Symbol cannot be null or empty!!");
		
		if(!grammarMap.containsKey(symbol))
			return symbol;
		
		Random rand = new Random();
		
		int size = grammarMap.get(symbol).size();
		
	    String rule = grammarMap.get(symbol).get(rand.nextInt(size)+0);
	    
	    String[] rulesSplit = rule.split("[ \t]+");
	    
	    String sentence = "";
	    
	    for (int i = 0; i < rulesSplit.length; i++)
	    
	        sentence += " "+generate(rulesSplit[i]) ;
	    
	    return sentence.trim();
	}
	
	
	/**
	   * The join function converts a string array to a string
	   * @param String[] line is a string array created using the .split() method
	   * @returns a string comprising of the array's contents
*/ 
	
	public String join(String[] line)
	{
		String returnString = "";
		
		for(int i = 0;i<line.length;i++)
			returnString+=line[i]+" ";
		
		return returnString.trim();
	}
	
	/**
	   * The removeNonTerminals removes the nonTerminal piece from every line in the grammar
	   * and stores the remaining contents into a list of strings to be used later in the program
*/ 
	public void removeNonTerminals()
	{
		int idx ;
		
		String line;
		for(int i = 0 ;i<original.size();i++)
		{
			idx = 0;
			
			line = original.get(i);
			
			while(line.charAt(idx) != '=')
				idx++;
			
			terminals.add(line.substring(idx+1));
		}
		
	}
}
