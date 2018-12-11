import java.util.*;

import java.io.*;

public class QuestionTree 
{

  UserInterface my;

  private QuestionNode root;
  
  private int totalGames;
  
  private int gamesWon;
  
  public QuestionTree (UserInterface ui)
  {
    my = ui;
    
    root = new QuestionNode("cpu");
  }
  
  /**
	 * Play this game until we reach a answer leaf node of the tree
	 */
	public void play() {
		root = play(root);
		this.totalGames++;
	}

	/**
	overloaded play function to be used for traversing through the tree.
	 * @param the root of the sub tree
	 * @return return modified tree.
	 * @throws IllegalArgumentException Input parameter was null
	 */
	private QuestionNode play(QuestionNode temp) throws IllegalArgumentException {
		if (temp == null)
			throw new IllegalArgumentException("Node is null");

		if (temp.left == null && temp.right == null) {
			my.print(String.format("Would your object happen to be %s?", temp.data));
			if (my.nextBoolean()) {
				
				my.println("I win!");
				
				gamesWon++;
				return temp;
			}
			else {
				my.print("What is your Object? ");
				
				QuestionNode answer = new QuestionNode(my.nextLine());
				
				my.println(String.format("Type a yes/no question to distinguish your item from %s:", temp.data));
				
				QuestionNode question = new QuestionNode(my.nextLine());
				
				my.print("What is the answer?");
				
				if (my.nextBoolean()) {
					
					question.left = answer;
					
					question.right = temp;
				}
				else {
					
					question.right = answer;
					
					question.left = temp;
				}
				return question;
			}
		}
		else {
			my.print(temp.data);
			if (my.nextBoolean())
				temp.left = play(temp.left);
			else
				temp.right = play(temp.right);
		}
		return temp;
	}
  
	/**
	 * play function using a while loop instead of recursion
	 * @throws IllegalArgumentException Input parameter was null
	 */

//  public void play()
//  {
//	  if (root == null)
//			throw new IllegalArgumentException("root does not exist");
//	  
//	  totalGames++;
//	  
//	  QuestionNode current = root,parent = root;
//	  
//	  while(!current.containsChildren())
//	  {
//		  my.println(current.data);
//		  
//		  boolean answer = my.nextBoolean();
//		  
//		  parent = current;
//		  
//		  current = answer == true ? current.left: current.right;
//	  }
//	  
//	  my.println("Is it a "+ current.data+ "?");
//	  
//	  if(!my.nextBoolean())
//	  {
//		  QuestionNode temp = current;
//		  
//		  my.println("What is your object?");
//		  
//		  String object = my.nextLine();
//		  
//		  my.println("Type a yes/no question to distinguish your item from " + current.data);
//		  
//		  String question = my.nextLine();
//		  
//		  my.println("And what is the answer for your object?");
//		  
//		  boolean answer = my.nextBoolean();
//		  
//		  current = new QuestionNode(question);
//		  
//		  if(answer)
//		  {
//			  current.left = new QuestionNode(object);
//			  current.right = temp;
//		  }else {
//			  current.left = temp;
//			  current.right = new QuestionNode(object);
//		  }
//	  }else {
//		  gamesWon++;
//		  
//		  my.println("I win!");
//	  }
//  }
  

  
  
  /**
	 * Save the current tree to a text file
	 * @param output The PrintStream Object to use to output to the file
	 */
	public void save(PrintStream output){
		save(root, output);
	}

	/**
	 * Recursive function that traverses tree and saves contents to file
	 * @param temp the starting node
	 * @param output he printstream object to use to output to the file
	 */
	private void save(QuestionNode temp, PrintStream output) {
		if (temp == null || output == null)
			throw new IllegalArgumentException("Node is null!");

		if (temp.left == null && temp.right == null)
			output.printf("A:%s\n", temp.data);
		else
			output.printf("Q:%s\n", temp.data);

		if (temp.left != null)
			save(temp.left, output);
		
		if (temp.right != null)
			save(temp.right, output);
	}
  
  /**
	 * Load a new question tree from the specified Scanner Object
	 * @param input Scanner Object to use to load the tree from
	 */
	public void load(Scanner input) {
		root = load(root, input);
	}

	/**
	 * Recursive Helper function to traverse the question tree and create the necessary nodes
	 * @param temp The Current head to load the tree onto
	 * @param input Scanner Object to use to load the tree from
	 * @return The completely loaded question tree
	 */
	private QuestionNode load(QuestionNode temp, Scanner input) {
		if (temp == null || input == null)
			throw new IllegalArgumentException("Node does not exist");

		if (temp.data.equalsIgnoreCase("cpu"))
			temp = new QuestionNode(input.nextLine().substring(2));
		
		if (!input.hasNextLine()) return null;

		String word = input.nextLine();
		temp.left = new QuestionNode(word.substring(2));
		if (word.charAt(0) == 'Q')
			temp.left = load(temp.left, input);


		word = input.nextLine();
		
		temp.right = new QuestionNode(word.substring(2));
		if (word.charAt(0) == 'Q')
			temp.right = load(temp.right, input);

		return temp;
}
	
/**
	 * total games is a getter function that returns the total games played
	 * @return total games played
*/
  public int totalGames()
  {
    return totalGames;
  }
  
  /**
	 * games won is a getter function that total games won by the cpu
	 * @return total games won by the cpu
*/
  public int gamesWon()
  {
    return gamesWon;
  }
  
  /**
 	 * Question node class that is used as the leaves of our tree
 */
  public class QuestionNode
  {
    public String data;
    public QuestionNode left;
    public QuestionNode right;
    
    public QuestionNode (String Data)
    {
      data = Data;
    }
    
    /**
	 * checks to see if a node has a left and right child 
	 * @return boolean indicating whether or not the node as two children
*/
    public boolean containsChildren()
    {
  	  return (this.left == null) && (this.right==null);
    }
    
  }
  
  
  
}