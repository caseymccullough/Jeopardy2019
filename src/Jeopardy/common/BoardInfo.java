package Jeopardy.common;

import java.util.ArrayList;

public class BoardInfo {
	
	private String boardTitle;
	private ArrayList <String> myCategories;
	private ArrayList <Question> myQuestions;
	
	public BoardInfo (String title, ArrayList <String> categories, ArrayList <Question> questions)
	{
		boardTitle = title; 
		myCategories = categories;
		myQuestions = questions;
	}
	
	public ArrayList <String> getCategories ()
	{
		return myCategories;
	}
	
	public ArrayList <Question> getQuestions()
	{
		return myQuestions;
	}

	public String toString()
	{
		String s = "";
		
		s += "Game Title: " + boardTitle + "\n";
		s += "******** CATEGORIES  **********\n";
		
		for (String cat: myCategories)
		{
			s += cat + "\n";
		}
		
		s += "******** QUESTIONS  **********\n";
		
		for (Question q: myQuestions)
		{
			s += q + "\n";
		}
		
		return s; 
	}
}
