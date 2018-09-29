/**
* The Program class handles the main functionality of the program
* This program is a game simulation where 5 animals get placed on
* grid that is 20 x 20 in size. If there is a clash between 2 animals
* that happen to be at the same location then the program will indicate it
* @author Abshir Mohamed
* @version 1.0

*/

import java.util.*;
public class Program{
    public static void main(String[] args)
    {
    	/**
  	   		*Main method handles the main functionality of the program
  	   		*5 animals are stored and the game begins here
    	 */
    	Animal[] animals = new Animal[5];
    	
    	int fight = 0, round = 0;
    	
    	for(int i = 0; i< 5;i++) {
    		
    		System.out.println("Animal #"+(i+1));
    		
    		animals[i] = createAnimal();
    		
    		
    	}
    	
    	//Print all locations of the animals
    	printLocations(animals);
    	
    	//Game loop
    	
    	while(fight<5)
    	{
    		round++;
    		//Move all 5 animals
        	for(int i = 0;i<5;i++){
        		System.out.println("Moving animal #"+(i+1)); 
        		
        		animals[i].move();
        		
        		//Loop to keep track of clashes
        		for(int j = 0 ;j<animals.length;j++)
        		   {
        			   if(animals[i].equals(animals[j]))
        				   continue;
        			   else {
        				   if(animals[i].touching(animals[j])) {
        					   System.out.printf("FIGHT!! %s and %s have gotten into a bout",animals[i].getName(),animals[j].getName());
        					   fight++;
        				   }  
        			   }
        		   }
        	}
        	
        	
        	//Print all locations of the animals
        	printLocations(animals);
        	
    	}
    	
    	
    	System.out.printf("Total number of fights: %d \n", fight);
    	
    	System.out.printf("Total number of rounds: %d \n", round);
    	
    	System.out.println("Final location of all animals:");
    	
    	//Print all locations of the animals
    	printLocations(animals);
    		
    	
    	
	
    	
    }
    
   public static Animal createAnimal()
   {
	   /**
	 	   * This function creates an animal object
	 	   * @return Animal returns newly created animal object.
 	   */
	   Scanner input = new Scanner(System.in);
   	
	   	int userInput;
	   
	   	Animal animal;
	   	
	   	do {
	   		
	   		System.out.println("Create a custom animal or revert to default? 1)Custom 2)Default");
	   		
	   		userInput = input.nextInt();
	   		
	   	}while(userInput != 1 && userInput != 2);
	   	
	   	
	   	if(userInput == 1) 
	   		
	   		animal = new Animal("custom");
	   	
	   	else
	   		animal = new Animal();
	   	
	   	return animal;
   }
   
   public static void printLocations(Animal[] animals)
   {
	   /**
	 	   * This function creates an animal object
	 	   * @param animal Takes in the array of animals from the main function
	   */
	   System.out.println(animals[0].toString());
	   
	   for(int i = 0;i<animals.length;i++) {
		   
		   System.out.println("+-+-+-+-+-+-+-+-+-+-+-+");
		   
		   System.out.println(animals[i].toString());
	   }
		   
	   
   }
   
    
}