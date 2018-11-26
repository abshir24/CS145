import java.util.*;
import java.io.*;

public class QuestionTree
{

  UserInterface my;

  public QuestionTree (UserInterface ui)
  {
    my = ui;
  }
  
  public void play()
  {
   my.println("Play Game here");
  }
  
  public void save(PrintStream output)
  {
    my.println("Save the current tree here");
  }
  
  public void load(Scanner input)
  {
    my.println("Save the current file here");
  }
  
  public int totalGames()
  {
    return 0;
  }
  
  public int gamesWon()
  {
    return 0;
  }
  
}