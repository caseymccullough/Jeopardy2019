package Jeopardy.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Jeopardy.common.JeopardyGame;
import Jeopardy.common.Question;
import Jeopardy.common.Team;

public class Tile extends JButton implements ActionListener
{
     
	private static final Font FONT = new Font("San Serif", Font.PLAIN, 90);
	private static final Color TEXT_COLOR = Color.BLUE; 
	private static final Dimension DIMENSION = new Dimension (500, 500);
	
	private static int numPicked = 0;

	 private Question myQuestion; 
	 private JeopardyGraphics theGame;
	 
     private boolean selected;
     boolean answeredCorrectly;

     public Tile (Question q, JeopardyGraphics gameIn)
     {
    	 super ("" + q.getValue());
    	 theGame = gameIn;
    	 
    	 this.setFont(FONT);
    	 this.setForeground(TEXT_COLOR);
    	 myQuestion = q; 
         selected = false;
 
         this.addActionListener(this);
         this.setMinimumSize(DIMENSION);

   
     }
     
  
    public Question getQuestion() {
          return myQuestion;
     }
    
 // HERE *****
    public String getAnswer (){
         return myQuestion.getAnswer();
    }
    
    public int getValue()
    {
         return myQuestion.getValue();
    }

     public static int getNumPicked()
     {
    	 return numPicked;
     }
     
     public boolean wasAnsweredCorrectly()
     {
    	 return answeredCorrectly;
     }
     
     public void correctAnswer()
     {
			answeredCorrectly = true;
			System.out.println("Correct!");
			System.out.println(" gains " + this.getValue());
			//currentTeam.addScore(this.getValue());	
     }
     
     public void wrongAnswer()
     {
 		answeredCorrectly = false;
 		System.out.println ("Incorrect!");
		System.out.println(" loses " + this.getValue());
		//currentTeam.subtractScore(this.getValue());
     }
     
 
     
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		//theGame.update();
		selected = true;
		this.setVisible(false);
		

		//Team currentTeam = theGame.getCurrentTeam(numPicked);
		theGame.processQuestion(this.getQuestion());

		//answerFrame = new AnswerFrame (this, currentTeam, theGame);
		
		numPicked++;

		
		
		/*
		if (this.wasAnsweredCorrectly())
		{
			currentTeam.addScore(this.value);
		}
		else
		{
			currentTeam.subtractScore(this.value);
		}*/
		
		//theGame.updateGameFrame(); // not updating scoreboard.
		


		
		
		
		/*if (numPicked == numValidTiles) // all tiles have been picked
		{
			System.out.println ("END OF GAME");
		}
		else
		{
			currentTeamNum = numValidTiles % theTeams.length;
			System.out.println ("numPicked: " + Tile.getNumPicked());
			System.out.println ("current team #: " + currentTeamNum);
			
		}*/
		
	}
	
	public boolean getAnsweredCorrectly () 
	{
		return answeredCorrectly;
		
	}
	
	public String toString ()
	{
		return myQuestion.toString();
	}
     


     
}