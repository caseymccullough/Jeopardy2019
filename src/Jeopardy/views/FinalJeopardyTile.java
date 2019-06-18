package Jeopardy.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Jeopardy.common.FinalJeopardyQuestion;
import Jeopardy.common.JeopardyGame;
import Jeopardy.common.Question;
import Jeopardy.common.Team;

public class FinalJeopardyTile extends JButton implements ActionListener
{
     
	private static final Font FONT = new Font("San Serif", Font.PLAIN, 90);
	private static final Color TEXT_COLOR = Color.BLUE; 
	private static final Dimension DIMENSION = new Dimension (30, 20);

	 private FinalJeopardyQuestion myQuestion; 
	 private JeopardyGraphics theGame;
	 
	 private static Icon finalJeopardyIcon = new ImageIcon("FinalJeopardy.jpeg");

     boolean answeredCorrectly;

     public FinalJeopardyTile (FinalJeopardyQuestion q, JeopardyGraphics gameIn)
     {
    	 super (finalJeopardyIcon);
    	 theGame = gameIn;
    	 
    	 this.setFont(FONT);
    	 this.setForeground(TEXT_COLOR);
    	 myQuestion = q; 
 
         this.addActionListener(this);
         this.setSize(DIMENSION);

   
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
		

		this.setVisible(false);
		

		//Team currentTeam = theGame.getCurrentTeam(numPicked);
		theGame.processFinalJeopardy(myQuestion);

		//answerFrame = new AnswerFrame (this, currentTeam, theGame);

		
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