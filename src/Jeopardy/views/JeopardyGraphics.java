package Jeopardy.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Jeopardy.common.Board;
import Jeopardy.common.BoardInfo;
import Jeopardy.common.FinalJeopardyQuestion;
import Jeopardy.common.JeopardyGame;
import Jeopardy.common.Question;
import Jeopardy.common.Team;
import Jeopardy.common.TextReader;

public class JeopardyGraphics extends JFrame {

	private Team[] theTeams;
	private Board theBoard;
	
	private JPanel contentPane;
	private int turnNumber;
	
	private ScoreBoardPanel sbPanel;
	
	
	private AnswerFrame answerFrame;
	private QuestionFrame questionFrame;
	

	public JeopardyGraphics(Team[] teamsIn, BoardInfo boardInfoIn) {
		
		super ("This is Jeopardy");
		
		theTeams = teamsIn; 
		theBoard = new Board (boardInfoIn, this);		
		turnNumber = 0;
		
		initComponents();
		
		
	


	}
	

	


	private void initComponents() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		sbPanel = new ScoreBoardPanel(this);
		contentPane.add(sbPanel, BorderLayout.NORTH);
		
		TilesPanel tiles = new TilesPanel (theBoard, Color.blue);
		contentPane.add(tiles, BorderLayout.CENTER);
		
		System.out.println("******** in init components");


		
	}
	
	public Team[] getTeams()
	{
		return theTeams;
	}

	
	public int getQuestionNumber()
	{
		return turnNumber;
	}
	
	public int getCurrentTeamNum ()
	{
		return turnNumber % theTeams.length;
	}
	
	public Team getCurrentTeam()
	{
		int pos = getCurrentTeamNum ();
		return theTeams[pos];
	}
	
	
	public void correctResponse()
	{
		System.out.println("CORRECT!!!");
		processAnswer();
	}
	
	public void incorrectResponse()
	{
		System.out.println("INCORRECT!!!");
		processAnswer();
	}
	
	public void processQuestion(Question currentQuestion)
	{
		
		 answerFrame = new AnswerFrame (currentQuestion, this);
				// Tile tileIn, Team teamIn, JeopardyGraphics gameIn
	}
	
	public void processFinalJeopardy(FinalJeopardyQuestion fjQuestion)
	{
		FinalJeopardyFrame fjFrame = new FinalJeopardyFrame (fjQuestion, getTeams());
			
	}
	
	private void processAnswer ()
	{

		turnNumber++;
		//questionFrame.close();
		this.remove(sbPanel);
		sbPanel = new ScoreBoardPanel(this);
		
		contentPane.add(sbPanel, BorderLayout.NORTH);
		
        this.getContentPane().validate();
        this.getContentPane().repaint();
        
		
	}
	
}
