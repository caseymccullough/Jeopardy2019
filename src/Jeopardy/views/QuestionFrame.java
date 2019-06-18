package Jeopardy.views;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Jeopardy.common.JeopardyGame;
import Jeopardy.common.Question;
import Jeopardy.common.Team;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionFrame extends JFrame {
	
	public static final Color QUESTION_COLOR = Color.BLUE;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static final int WINDOW_WIDTH = (int) screenSize.getWidth();
	public static final int WINDOW_HEIGHT = (int) screenSize.getHeight() - 50;
	
	public static final Dimension DIMENSION = new Dimension (WINDOW_WIDTH, WINDOW_HEIGHT - 50);
	public static final Dimension TEXT_DIMENSION = new Dimension (WINDOW_WIDTH - 50, WINDOW_HEIGHT - 50);
	
	private static final Font FONT = new Font("Helvetica Bold", Font.PLAIN, 90);
	private static final Color FONT_COLOR = Color.WHITE;
	
	private static final int BORDER_THICKNESS = 5; 
	
	private Question myQuestion;
	private Team theTeam;
	private JeopardyGraphics theGame;
	
	private boolean isCorrect;

	
	public QuestionFrame (Question questionIn, Team teamIn, JeopardyGraphics gameIn)
	{
		super ();
		myQuestion = questionIn;
		theTeam = teamIn;
		theGame = gameIn;
		
		this.setBackground(QUESTION_COLOR);
		this.setPreferredSize(DIMENSION);
		this.setMinimumSize(DIMENSION);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(setUpPanel());
		this.pack();
		this.setVisible(true);
		
	}

		
	public JPanel setUpPanel ()
	
	{
		JPanel resultPanel = new JPanel();
		resultPanel.setBackground(QUESTION_COLOR);
		
		
		resultPanel.setLayout(new BorderLayout (5, 5));
		
		
		JPanel questionPanel = new JPanel(); // contains question and correct / incorrect button
		questionPanel.setBackground(QUESTION_COLOR);
		JPanel buttonsPanel = new JPanel();
		
		JTextArea questionText = new JTextArea (myQuestion.getQuestion());
		
		questionText.setFont(FONT);
		questionText.setSize(TEXT_DIMENSION);
		questionText.setLineWrap(true);
		
		Icon correctIcon = new ImageIcon("correct.png");
		Icon incorrectIcon = new ImageIcon ("incorrect.jpeg");

		JButton correct = new JButton (correctIcon);
		JButton wrong = new JButton (incorrectIcon);
		
		int scoreAdjust = myQuestion.getValue();
		System.out.println("score adjust: " + scoreAdjust);

		
		correct.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {

				theTeam.addScore(scoreAdjust);
				theGame.correctResponse();
				//theGame.processAnswer();
				
				
				close();
				
			
					
			}
		});
		
		wrong.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				
				theTeam.subtractScore(scoreAdjust);
				theGame.incorrectResponse();
				//theGame.processAnswer();
				
				close();
				
			}
		});
		 
		buttonsPanel.add(correct);
		buttonsPanel.add(wrong);
		

		
		questionPanel.add(questionText);
	
		
		resultPanel.add(questionPanel, BorderLayout.CENTER);
		resultPanel.add(buttonsPanel, BorderLayout.PAGE_END);
		//resultPanel.add(bottomPanel);
		
		/*if (showQuestion)
		{
			this.add(questionPanel);
			
		}*/
		
		
		return resultPanel;
		

		
	}
	
	public void close ()
	{
	   this.setVisible(false);
	   
	}
	
	public boolean isCorrect()
	{
		return isCorrect;
	}
	

	
	
}
