/**
* The Animal class handles the properties of our animal object
* Creates and retrieves data for Animal
*
* @author Abshir Mohamed
* @version 1.0

*/



import java.util.*;

public class Animal{
    private String Name;
    private int x;
    private int y;
    private int maxSpeed; 

    public Animal(){
    	/**
    	   * This method is the default constructor for the Animal Class
    	   
    	*/
        Name = "Unknown";
        x = 0;
        y = 0;
        maxSpeed = 2;
    }

    public Animal(String custom){
    	/**
    	   * This method is the over-loaded constructor for the Animal Class
    	   * It handles user input to create a custom animal
    	   * @param custom A placeholder to indicate that this is the constructor that will create the custom animal
    	 */
    	Scanner input = new Scanner(System.in);
    
    	do {
    		System.out.println("Enter a name for your animal (must be more than 1 character)");
    		
    		Name = input.nextLine();
    		
    	}while(Name.length() < 1);
    	
    	do {
    		System.out.println("Enter a max speed for your animal (must be greater than 0)");
    		
    		maxSpeed = input.nextInt();
  
    	}while(maxSpeed < 1);
    	
    	do {
    		System.out.println("Enter an x-coordinate (x must be greater than or equal to -10 and less than or equal to 10)");
        	
        	x = input.nextInt();
    	}while(x < -10 || x > 10 );
    	
    	do {
    		System.out.println("Enter an y-coordinate (y must be greater than or equal to -10 and less than or equal to 10");
        	
        	y = input.nextInt();
    	}while(y < -10 || y > 10 );
    	
    }
    
    public String getName()
    {
    	/**
    	   * This method retrieves the name of this animal
    	   * @return String Name of this specific animal
    	 */
    	return Name;
    }
    
    public int getX()
    {
    	/**
  	   		* This method retrieves the x coordinate for this animal
  	   		* @return Int X coordinate location for this animal
  	   	*/
    	return x;
    }
    
    public int getY()
    {
    	/**
	   		* This method retrieves the y coordinate for this animal
	   		* @return Int y coordinate location for this animal
	   	*/
    	return y;
    }
    
    public String toString()
    {
    	/**
	   		* This method retrieves the animals name and location and converts that data into one string
	   		* @return String animal data
	   	*/
    	return "Name: " + Name+ "\n"
    			+ "X-Coordinate: "+ x +"\n"
    			+ "Y-Coordinate: "+ y +"\n";
    		
    }
    
    public boolean touching(Animal animalX)
    {
    	/**
	  	   * This method checks to see if two animal objects
	  	   * have the same x and y location on a grid
	  	   * @param Animal Animal object
	  	   * @return boolean Indicates whether or not two animal objects are at the same point on the grid
	  	  */
    	return (animalX.getX() == x && animalX.getY() == y);
    }
    
    public void move()
    {
    	/**
	  	   * Updates an Animals x and y coordinates based on a random number generator
	  	 */
    	Random rand = new Random();
    	
//    	Random direction 1 = up, 2 = down, 3 = left , 4 = right
    	
    	int direction = rand.nextInt(4)+1,
    			distance = rand.nextInt(maxSpeed) + 1;
    	
    	
    	System.out.printf("%s is traveling the distance of %d \n",Name,distance);
    	
    	switch(direction)
    	{
    		case 1:
    			//If the distance is greater than the grids bounds then relocate position to the bottom of board
    			if((distance + x) > 10) {
    				//Counter to keep track of positions moved
    				for(int i = distance;i>0;i--)
    				{
    					//If the current position is greater than 10 then the current position goes back to the bottom of the board
    					if(++x > 10) x = -10;
    					
    				}
    				
    			}
    				
    			else
    				x = distance + x;
    			
    			break;
    			
    		case 2:
    			//If the distance is greater than the grids bounds then relocate position to the bottom of board and keeps moving up
    			if((x-distance) < -10) {
    				//Counter to keep track of positions moved
    				for(int i = distance ;i>0;i--)
    				{
    					//If the current position is less than -10 then the current position goes back to the top of the board and keeps moving down
    					if(--x < -10) x = 10;
    				}
    				
    			}
    				
    			else
    				x = x-distance;
    			
    			break;
    		
    		case 3:
    			//If the distance is greater than the grids bounds then relocate position to the bottom of board
    			if((y-distance) < -10) {
    				//Counter to keep track of positions moved
    				for(int i = distance ;i>0;i--)
    				{
    					//If the current position is less than -10 then the current position goes back to the right side of the board and keeps moving left
    					if(--y < -10) y = 10;
    				}
    				
    			}
    				
    			else
    				y = y - distance;
    			break;
    		
    		default:
    			//If the distance is greater than the grids bounds then relocate position to the bottom of board
    			if((distance + y) > 10) {
    				//Counter to keep track of positions moved
    				for(int i = distance;i>0;i--)
    				{
    					//If the current position is greater than 10 then the current position goes back to the left of the board
    					if(++y > 10) y = -10;
    					
    				}
    				
    			}
    				
    			else
    				y = distance + y;
    			
    			break;
    			
    	}
    }
}
