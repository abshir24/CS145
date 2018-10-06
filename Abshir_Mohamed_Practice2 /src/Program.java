// CS145 
// In Class program #1
// Array Lists

import java.util.*;

public class Program
{
  public static void main(String[] args)
  {
    List<String> myList = new ArrayList<>();
    
    myList.add("Four");
    myList.add("score");
    myList.add("and");
    myList.add("seven");
    myList.add("years");
    myList.add("ago.");

    System.out.print("Before: ");
    System.out.println(myList);
    

    swapPairs(myList);
    
    System.out.print("After:  ");    
    System.out.println(myList);

    // Round 2 - Odd
    System.out.println();
    System.out.println("***********");
    System.out.println();
    
    myList.clear();
    
    myList.add("1");
    myList.add("2");
    myList.add("3");
    myList.add("4");
    myList.add("5");
    myList.add("6");
    myList.add("7");    
    myList.add("8");   
    myList.add("9");             

    System.out.print("Before: ");
    System.out.println(myList);
    

    
    
    swapPairs(myList);
    
    System.out.print("After:  ");    
    System.out.println(myList);

  }
  
  
//	 //2 lines solution
  
  public static void swapPairs(List<String> list)
  {
	  /**
	 	   * swapPairs function that swaps 
	 	   * @param list of strings
	   */  
     for(int i = 0;i<list.size()-1;i+=2)
    
//    	Collections.swap(list, i, i+1);
    	 list.add(i,list.remove(i+1));
     
  }
  
  //4lines solution
  
//  public static void swapPairs(List<String> list)
//  {  
//     for(int i = 0;i<list.size()-1;i+=2)
//     {
//    	String temp = list.get(i);
//   	  
//   	  	list.set(i, list.get(i+1));
//   	  
//   	  	list.set(i+1, temp);
//     }
//     
//  }

  
}
    