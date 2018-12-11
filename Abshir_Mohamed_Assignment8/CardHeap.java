/* 
 * Class CardHeap is the class that handles most of the back-end functionality that goes
 * into organizing the deck of cards used by the main program.  This class is constructed using a lot of helper functions 
 * to help create a program that will best implement the heap data structure
 *  @author Abshir Mohamed
 * 	@version 1.0
 */


import java.util.*;

public class CardHeap {
	private Card[] cards;
	private int size;

	/**
	 * Heap
	 */
	public CardHeap() {
		cards = new Card[10];
		size = 0;
	}

	/**
	 * Check if a child has a parent
	 * @param i the element whom you seek to reunite with a parent
	 * @return the index of the parent
	 */
	private int parent(int i) {
		return i/2;
	}

	/**
	 * Get the left child of an element
	 * @param i the element whose left child you seek to abduct
	 * @return the abducted child
	 */
	private int leftChild(int i) {
		return i*2;
	}

	/**
	 * Get the right child of an element
	 * @param i the element whose right child you seek to abduct
	 * @return the abducted child
	 */
	private int rightChild(int i) {
		return i*2 +1;
	}

	/**
	 * Check if element has a parent or not
	 * @param i element to check
	 * @return True if it has a parent, false otherwise
	 */
	private boolean hasParent(int i) {
		return i > 1;
	}

	/**
	 * Check if element has left child
	 * @param i element to check
	 * @return True if it has left child, false otherwise
	 */
	private boolean hasLeftChild(int i ) {
		return leftChild(i) <= size;
	}

	/**
	 * Check if element has right child
	 * @param i element to check
	 * @return True if it has right child, false otherwise
	 */
	private boolean hasRightChild(int i) {
		return rightChild(i) <= size;
	}

	/**
	 * Swap two elements of an array
	 * @param a The array to swap the elements in
	 * @param index1 index of the first element
	 * @param index2 index of the second element
	 */
	private void swap( int index1, int index2) {
		Card temp = cards[index1];
		cards[index1] = cards[index2];
		cards[index2] = temp;
	}

	/**
	 * Add a value to this heap
	 * @param val The value to add
	 */
	public void add(Card card) {
		if (size+1 >= cards.length)
			cards = Arrays.copyOf(cards, cards.length*2);

		cards[size+1] = card;

		int index = size+1;
		boolean found = false;

		while (!found && hasParent(index)) {
			int parent = parent(index);
			if (cards[index].compareTo(cards[parent]) < 0) {
				swap(index, parent);
				index = parent(index);
			}
			else {
				found =true;
			}
		}
		size++;
	}
	

	/**
	 * Look at the first item in this heap
	 * @return first item
	 */
	public Card peek() {
		return cards[1];
	}

	/**
	 * "Clear" the contents of this heap
	 */
	public void clear() {
		size = 0;
	}

	@Override
	public String toString() {
		String s = "[";
		for (int i = 1; i < size+1; i++) {
			s += cards[i];
			s += ",";
		}
		return s.substring(0, s.length()) + "]";
	}
	
	/**
	 * Swap two elements of an array
	 * @param a The array to swap the elements in
	 * @param index1 index of the first element
	 * @param index2 index of the second element
	 */
	private void swap(Card[] a, int index1, int index2) {
		Card temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	/**
	 * Remove the first value from this heap
	 * @return the removed value
	 */
	public Card remove() {
		Card result = peek();
		cards[0] = cards[size--];
		
		heapSort(cards,size);
		
		return result;
	}

	
	/**
	 * Turns array of cards into heap of cards
	 * @param arr The array of cards
	 * @param n size of array
	 * @param i index to be swapped
	 */

	private void heapify(Card arr[], int n, int i) 
	{ 
	    int largest = i; // Initialize largest as root 
	    int l = 2*i + 1; // left = 2*i + 1 
	    int r = 2*i + 2; // right = 2*i + 2 
	  
	    // If left child is larger than root 
	    if (l < n && (arr[l].compareTo(arr[largest]) > 0)) 
	        largest = l; 
	  
	    // If right child is larger than largest so far 
	    if (r < n && (arr[r].compareTo(arr[largest]) > 0)) 
	        largest = r; 
	  
	    // If largest is not root 
	    if (largest != i) 
	    { 
	    	Card swap = cards[i]; 
            cards[i] = cards[largest]; 
            cards[largest] = swap; 
	  
	        // Recursively heapify the affected sub-tree 
	        heapify(arr, n, largest); 
	    } 
	} 
	
	/**
	 * Sorts array in heap format
	 * @param arr The array of cards
	 * @param n size of array
	 */
	private void heapSort(Card arr[], int n) 
	{ 
	    // Build heap (rearrange array) 
	    for (int i = n / 2 - 1; i >= 0; i--) 
	        heapify(arr, n, i); 
	  
	    // One by one extract an element from heap 
	    for (int i=n-1; i>=0; i--) 
	    { 
	        // Move current root to end 
	    	 // Move current root to end 
            Card temp = cards[0]; 
            cards[0] = cards[i]; 
            cards[i] = temp; 
	  
	        // call max heapify on the reduced heap 
	        heapify(arr, i, 0); 
	    } 
	} 
	
	
}
