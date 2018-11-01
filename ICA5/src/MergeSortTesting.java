import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class MergeSortTesting
{
  private List<Person> myList= new ArrayList<Person>();
  public static void main(String[] args) 
  {
     MergeSortTesting obj = new MergeSortTesting();
     obj.run();
  }
  
  public void run()
  {
    //MAKE SURE TO UNCOMMENT ONE OF THE LINES BELOW
    File f = new File("src/DataFileInClass5.txt");
//    File f = new File("DataFileInClass5ver2.txt");
    
    Scanner scan = null;
    try
    {
      scan = new Scanner(f);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File Not found");
      System.exit(0);
    }
     
    while(scan.hasNext())
    {
      int i = scan.nextInt();
      String a = scan.next();
      String b = scan.next();
      Person temp = new Person(i,a,b);
      myList.add(temp);
      
      //System.out.println(temp);
    }
    
    //System.out.println(myList);
    long startTime = System.currentTimeMillis();
    Collections.sort(myList); 
    long endTime = System.currentTimeMillis();
    sortListByID(myList); 
    long endTime2 = System.currentTimeMillis();
    System.out.println("Checking the order");
    for (int i=0;i<5;i++) System.out.println(myList.get(i));
    
    System.out.println();    
    System.out.printf("The computer sort took %d (ms) to run.%n" , endTime-startTime);
    System.out.printf("          My sort took %d (ms) to run.%n" , endTime2-endTime);
    
  }
 
  private class Person implements Comparable<Person>
  {
    private String fName;
    private String lName;
    private int ID;
    
    public int getID()
    {return ID;}
    
    public String getName()
    {return fName + " " + lName;}
    
    Person(int a, String b, String c)
    {
      fName = b;
      lName = c;
      ID = a;
    } 
    public String toString()
    {return "["+lName +", " + fName + " #" + ID+"]";}
    public int compareTo(Person o)
    {
      if (lName.compareTo(o.lName)==0) return fName.compareTo(o.fName);
      else return lName.compareTo(o.lName);
    }
  }
  
  
  private static void sortListByID (List<Person> theList)
  {
    mergeSort(theList);
  }
  
  
  public static List<Person> mergeSort(List<Person> a)
  {
/**
	   * The mergeSort function sorts an array list by breaking it down to
	   * smaller pieces recursively
	   * @param result is the original arraylist that is being sorted
*/ 
	// split array into two halves
	  List<Person> left = new ArrayList<>();
	  List<Person> right = new ArrayList<>();
	  
	  if (a.size() >= 2) {
		  int size = a.size(),mid = size/2;
		  
		  left.addAll( a.subList(0,mid));
		  
		  right.addAll(a.subList(mid, a.size()));
		  
		  //sort the two halves
		  
		  mergeSort(left);
		  mergeSort(right);
		  
		  //merge the sorted halves into a sorted whole
		  
		  merge(a,left,right);
	  }
	  
	 return a;	  
  }
  

  public static void merge(List<Person> result, List<Person>left,List<Person>right)
  {
	  /**
	   * The merge function merges the left/right elements into a sorted result.
	   * Precondition: left/right are sorted
	   * @param result is the original arraylist that is being sorted
	   * @param left is the left side of the original arraylist
	   * @param right is the right side of the original arraylist
*/ 
	  int i1 = 0; //index into left array
	  int i2 = 0; // index into right array
	  
	  for(int i = 0;i<result.size();i++)
	  { 
		  if(i2>=right.size() || (i1<left.size() && (left.get(i1).getID() <= right.get(i2).getID())))
		  {
			  result.set(i,left.get(i1)); // take from left
			  i1++;
		  }else{
			  result.set(i,right.get(i2)); // take from right
			  i2++;
		  }
	  }

  }
  
}