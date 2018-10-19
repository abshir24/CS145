/**
* The Program Class handles the main functionality of the program
* This programs purpose is to run two recursive funtions that have two different purposes.
* @author Abshir Mohamed
* @version 1.0
*/
import java.util.*;
public class Program {

	public static void main(String[] args)
	{
		/**
		   * Main functions handles all of the functionality for this program
		 **/ 
		
		writeSquares(8);
		
		
		System.out.println(isPalindrome("madam"));
		
	}
	
	/**
	   * isPalindrome checks to see if word is a palindrome recursively
	   * @param word that needs to be checked
	   * @returns a boolean if word is palindrome
*/ 
	
	public static boolean isPalindrome(String word)
	{
		int s = 0,e = word.length()-1;
		
		if(word.length() ==1)
			return true;
		
		if(word.charAt(0) == word.charAt(word.length()-1))
			return isPalindrome(word.substring(++s,--e + 1));
		else
			return false;
		
	}
	
	/**
	   * writeSquares prints numbers squares of numbers up to input in odd order descending and even order ascending
	   * @param number input to count down from
*/ 
	public static void writeSquares(int num)
	{
		if(num <= 0)
		{
			return;
		}
		{
			if(num%2 == 0)
			{
				writeSquares(num-1);
				System.out.print(num*num+" ");
			}
			
			else {
				System.out.print(num*num+" ");
				writeSquares(num-1);
				
			}
				
			
		}
		
	}

}



