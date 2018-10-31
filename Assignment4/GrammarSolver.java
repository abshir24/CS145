import java.io.*;
import java.util.*;

public class GrammarSolver {

	Map<String,List<String>> grammarMap = new TreeMap<>();
	
	List<String> nonTerminals = new ArrayList<>();
	
	List<String> terminals = new ArrayList<>();
	
	List<String> original;
	
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
		
	}
	
	public boolean contains(String symbol)
	{
		if(symbol.length() == 0 || symbol == null)
			throw new IllegalArgumentException("Not a proper symbol");
	
		return nonTerminals.contains(symbol);
	}
	
	public Set<String>getSymbols()
	{
		Set<String> nonTerminalSet = new TreeSet<>(nonTerminals);
		
		return nonTerminalSet;
	}
	
	
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
				
				rule = lineArr[j];
				
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
	
	public String generate(String symbol)
	{
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
	
	
	public String join(String[] line)
	{
		String returnString = "";
		
		for(int i = 0;i<line.length;i++)
			returnString+=line[i]+" ";
		
		return returnString.trim();
	}
	
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
