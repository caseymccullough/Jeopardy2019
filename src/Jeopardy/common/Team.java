package Jeopardy.common;
import java.awt.Color;


public class Team {
	
	private String name;
	private int score;
	private Color myColor; 
	private static final Color [] teamColors= {Color.MAGENTA, Color.GREEN, Color.CYAN, Color.RED, Color.BLUE};
	
	private static int numTeams = 0;
	
	public Team (String n)
	{
		name = n;
		score = 0;
		myColor = teamColors[numTeams];
		numTeams++;
	}
	
	public String toString ()
	{
		return name + ": " + score;
	}
	
	public void addScore (int change)
	{
		score += change;
	}
	
	public void subtractScore (int change)
	{
		score -= change;
	}
	
	
	public String getName()
	{
		return name;
	}
	public Color getColor ()
	{
		return myColor;
	}

}
