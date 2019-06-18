package Jeopardy.common;


import java.io.*;
import java.util.*;

public class TextReader {
     
     private Scanner scn;
     private String fileName;
     
     public TextReader (String file)
     {
    	 fileName = file;
     }
     
     public void openFile(){
          try{
               scn = new Scanner (new File (fileName));
               System.out.println("file loaded as " + fileName);
          }
          catch (Exception e) {
               System.out.println ("Could not find file");
          }
     }
     
     public BoardInfo readFile ()
     {
    	 
    	 ArrayList <String> theCategories = new ArrayList <String>();
    	 ArrayList <Question> theQuestions = new ArrayList <Question>();
    	
    	  String gameTitle = scn.nextLine();
    	  scn.nextLine();
    	  
    	  for (int i = 0; i < 5; i++)
    	  {
        	  String category = scn.nextLine();
        	  theCategories.add(category);
        	  
    	  }

    	  scn.nextLine(); // blank line
    	  scn.nextLine(); // "Question" "Answer" line
    	  
          while (scn.hasNextLine())
          {
               String line = scn.nextLine();
               
               int tabSpace = line.indexOf('\t');
               String stringValue = line.substring(0, tabSpace);
               int value = Integer.parseInt(stringValue);
               
               line = line.substring (tabSpace + 1);
               tabSpace = line.indexOf('\t');
               String answer = line.substring(0, tabSpace);
               
               String question = line.substring(tabSpace + 1);
               
               //System.out.println (answer + "\t" + question + "\t$ " + value);
               Question q = new Question (answer, question, value);
               //System.out.println(q);
               theQuestions.add(q);
        	  
        	  //System.out.println(scn.nextLine());
               
          }
          
          return new BoardInfo (gameTitle, theCategories, theQuestions);
          
     }
     
     public void closeFile(){
          scn.close();
     }
     
     
     
     
}