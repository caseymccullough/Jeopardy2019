package Jeopardy.common;

import java.io.*;
import java.util.*;

import Jeopardy.views.JeopardyGraphics;
import Jeopardy.views.Tile;



public class Board
{
     private Tile[][] theTiles;

     private int numRows;
     private int numCols;
     
     private String[] myCategories;
    // private JeopardyGraphics game;
    
     public Board (BoardInfo bi, JeopardyGraphics grIn)
     {
    	 
    	 numRows = 5;
    	 numCols = 5; 
    	 
          theTiles = new Tile [numRows] [numCols];
          myCategories = new String [5];
          
          


               //Tile.setGame(theGame);
               
              for (int i = 0; i < 5; i++)
              {    
                   myCategories[i] = bi.getCategories().get(i);
              }
              
              int questionCount = 0; 
              
              for (int col = 0; col < numCols; col++)
              {
                   for (int row = 0;  row < numRows; row++)
                   {
                	   Question q = bi.getQuestions().get(questionCount);
                	   
                	   System.out.println("a new question group: " + q);
                	   theTiles[col] [row] = new Tile (q, grIn);
                	   questionCount++;
                   }
                  
                  
                  
              }
     }
     
     public String toString()
     {
          String s = "THE BOARD";
          for (int col = 0; col < myCategories.length; col++)
          {   
               s += "\nCategory " + (col + 1) + ":  " + myCategories[col] + "\n";
               for (int r = 0; r < myCategories.length; r++)
                    s += theTiles [col] [r] + "\n";
               
          }    
          return s;
  
     }
     
     public int getNumRows()
     {
    	 return numRows;
     }
     
     public int getNumCols()
     {
    	 return numCols;
     }
     
     public Tile getTile (int r, int c)
     {
    	 return theTiles [r][c];
     }
     
     public String [] getCategories ()
     {
    	 return myCategories; 
     }
     
  
     
     

}