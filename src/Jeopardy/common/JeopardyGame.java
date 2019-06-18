package Jeopardy.common;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import Jeopardy.views.JeopardyGraphics;
import Jeopardy.views.TeamFrame;

public class JeopardyGame {
	
	
	private final static String BOARD_FILE = "Trivia1.txt";
	
	private Team[] theTeams;
	private BoardInfo bInfo; 

	public JeopardyGame()
	{
	
		TextReader reader = new TextReader(BOARD_FILE);
		reader.openFile();
		BoardInfo bInfo = reader.readFile();
		reader.closeFile();
		
		TeamFrame tf = new TeamFrame(this, bInfo);

		//JeopardyGraphics jg = new JeopardyGraphics (getTheTeams(), bInfo);

		
	}
	
	
	public void setTheTeams(Team[] teamsIn)
	{
		theTeams = teamsIn; 
	}
	
	public Team[] getTheTeams()
	{
		return theTeams;
	}
	

	
	public BoardInfo getTheBoardInfo()
	{
		return bInfo; 
	}


	public static void main(String[] args) {
		
		JeopardyGame game = new JeopardyGame();
	
	}




}
