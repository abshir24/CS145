/* 
 * Class CardArrayList is the class that handles most of the back-end functionality that goes
 * behind making the CardArray program. This class is constructed using a lot of helper functions 
 * to help create a program that will be used add remove update and retrieve from a deck of cards
 *  @author Abshir Mohamed
 * 	@version 1.0
 */
 


import java.util.*;

public class CardArrayList {
	private Card[] cards;
	
	private int size;
	
	/**
	   * This version of the constructor creates a new deck of cards with a size of 10
	   * and initializes the size field to 0
*/ 
	public CardArrayList()
	{
		cards = new Card[10];
		
		size = 0;
	}
	
	/**
	   * This version of the constructor takes in an integer and sets the size of the
	   * cards array to that integer.
	   * @param x the size of the cards array
	   * @throw IllegalArgumentException if the x index is out of the Array bounds
*/ 
	public CardArrayList(int x)
	{
		if(x < 1) throw new IllegalArgumentException("Input must be greater than 0!");
		
		cards = new Card[x];
		
		size = 0;
	}
	
	/**
	   * The overridden toString method uses a fence post algorithm to print out the contents of the
	   * cards array
	   * @returns the contents of the card array
*/ 
	public String toString()
	{
		String returnString  = "[0: ";
		
		for(int i = 0;i<size;i++)
		{
			returnString += i == size - 1 ?cards[i].toString() : cards[i].toString()+",";
		}
		
		return returnString +  " :"+size+"]";
	}
	
	/**
	   * This size method returns the size of the sub array inside of the array
	   * @returns the card that was removed
*/ 
	public int size()
	{
		return size;
	}
	
	/**
	   * This add method adds a card to the back of the array
*/ 
	public void add(Card x)
	{
		if(cards[cards.length-1] != null)
			cards = Arrays.copyOf(cards, cards.length * 2);
		
		cards[size++] = x;
		
	}
	
	/**
	   * This remove method removes the last card from the array
	   * @returns the card that was removed
*/ 
	
	public Card remove()
	{
		return cards[--size];
	}
	
	/**
	   * This get method returns the the card at the specific index that was passed in
	   * @param x is the index that the card is wanted to be found at
	   * @returns the card at that index if found
	   * @throw IllegalArgumentException if the location index is out of the Array bounds
*/ 
	public Card get(int x)
	{
		if(x > size || x < 0)
			throw new IllegalArgumentException("Index out of bounds");
		
		return cards[x];
	}
	
	/**
	   * This indexOf method returns the index of the card that was passed
	   * @param card is the card that will be checked in the method
	   * @returns the index of the card
*/ 
	public int indexOf(Card card)
	{
		
		for(int i = 0;i<size;i++)
			if(cards[i].compareTo(card) == 0)
				return i;
		
		return -1;
	}
	/**
	   * This add method adds a card from the array at a 
	   * specific location
	   * @param location location of card
	   * @param x card being added
	   * @throw IllegalArgumentException if the location index is out of the Array bounds
*/ 
	public void add(int location,Card x)
	{
		if(location > size+1 || location < 0)
			throw new IllegalArgumentException("Index is out of bounds"); 
			
		if(cards[cards.length-1]!=null)
		{
			cards = Arrays.copyOf(cards, cards.length + 1);
			
			cards[size++] = x;
		}
		else 
		{
			if(location == size)
				cards[size++] = x;
			else {
				size++;
				
				for(int i = size-1;i>location;i--)
					cards[i] = cards[i-1];
				
				cards[location] = x;
				
			}	
		}
	}
	
	/**
	   * This remove method removes a card from the array at a 
	   * specific location
	   * @param location location of card
	   * @throw IllegalArgumentException if the location index is out of the Array bounds
	   * @returns the card that was removed
*/ 
	public Card remove(int location)
	{
		if(location > size+1 || location < 0)
			throw new IllegalArgumentException("Index is out of bounds"); 
		
		if(location == size)
			return cards[--size];
		else {
			Card temp = cards[location];
			
			for(int i = location;i<size;i++)
				cards[i] = cards[i+1];
			
			size--;
			
			return temp;
		}	
	}
	
	/**
	   * The sort function sorts the cards array by first breaking it down to the array list indexes
	   * and then using merge sort to sort the array list.
	   
*/ 
	public void sort()
	{
		
		Card[] copy = Arrays.copyOfRange(cards, 0,size);
		
		mergeSort(copy);
		
		for(int i = 0;i<size;i++)
			cards[i] = copy[i];
	}
	
	/**
	   * The mergeSort function sorts an array by breaking it down to
	   * smaller pieces recursively
	   * @param result is the original array that is being sorted
*/ 
	public Card[]  mergeSort(Card[] a)
	{
		
		// split array into two halves
		Card[] left = Arrays.copyOfRange(a, 0,a.length/2);
		Card[] right = Arrays.copyOfRange(a, a.length/2,a.length);
		
		if (a.length >= 2) {
			  //sort the two halves
			  
			  mergeSort(left);
			  mergeSort(right);
			  
			  //merge the sorted halves into a sorted whole
			  
			  merge(a,left,right);
		  }
		  
		 return a;	  
	  }
	  
	/**
	   * The merge function merges the left/right elements into a sorted result.
	   * Precondition: left/right are sorted
	   * @param result is the original array that is being sorted
	   * @param left is the left side of the original array
	   * @param right is the right side of the original array
*/ 

	  public void merge(Card[] result,Card[] left,Card[] right)
	  {
		  
		  int i1 = 0; //index into left array
		  int i2 = 0; // index into right array
		  
		  for(int i = 0;i<result.length;i++)
		  { 
			  if(i2>=right.length|| (i1<left.length && (left[i1].compareTo(right[i2]) > 0 )))
			  {
				  result[i] = left[i1]; // take from left
				  i1++;
			  }else{
				  result[i] = right[i2]; // take from right
				  i2++;
			  }
		  }

	  }
	  
	  /**
	   * The shuffle method iterates through an array and shuffles every element at least once
	   */ 
	  public void shuffle()
	  {
		  
		  Random rand = new Random();
	  
		  int randIdx;
		  for(int i = 0;i<size;i++)
		  {  
			  do { randIdx = rand.nextInt(size-1)+0; }while(randIdx==i);
			  
			  Card temp = cards[i];
			  
			  cards[i] = cards[randIdx];
			  
			  cards[randIdx] = temp; 
		  }
	  }
	  
	  /**
	   * The clear method resets the array back to 10 empty indexes as well as setting the size to 0
	  */
	  public void clear()
	  {
		 
		  size = 0;
		  
		  cards = new Card[10];
	  }
	  
	  
	
}
