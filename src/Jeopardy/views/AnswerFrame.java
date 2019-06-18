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
import javax.swing.border.LineBorder;

import Jeopardy.common.JeopardyGame;
import Jeopardy.common.Question;
import Jeopardy.common.Team;
import Jeopardy.views.QuestionFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AnswerFrame extends JFrame {
	
	public static final Color ANSWER_COLOR = Color.BLUE;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static final int WINDOW_WIDTH = (int) screenSize.getWidth();
	public static final int WINDOW_HEIGHT = (int) screenSize.getHeight() - 50;
	
	public static final Dimension DIMENSION = new Dimension (WINDOW_WIDTH, WINDOW_HEIGHT - 50);
	public static final Dimension TEXT_DIMENSION = new Dimension (WINDOW_WIDTH - 50, WINDOW_HEIGHT - 50);
	
	private static final Font FONT = new Font("Helvetica Bold", Font.PLAIN, 90);
	private static final Color FONT_COLOR = Color.WHITE;
	
	private static final int BORDER_THICKNESS = 5; 
	
	private Question myQuestion; // contains answer, question, value. 
	private boolean isCorrect;
	private Team currentTeam;
	private JeopardyGraphics theGame;
	
	public AnswerFrame (Question questionIn, JeopardyGraphics gameIn)
	{
		super("" + gameIn.getCurrentTeam().getName());
		
		myQuestion = questionIn; 
		theGame = gameIn; 
		currentTeam = theGame.getCurrentTeam(); 
		
		
		this.setForeground(ANSWER_COLOR);
		this.setPreferredSize(DIMENSION);
		this.setMinimumSize(DIMENSION);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		this.add(setUpPanel());
		this.pack();
		this.setVisible(true);
		
	}

		
	public JPanel setUpPanel()
	
	{
		JPanel resultPanel = new JPanel();
		resultPanel.setLayout(new BorderLayout(5, 5));
		resultPanel.setBackground(ANSWER_COLOR);	
		resultPanel.setBorder(new LineBorder(currentTeam.getColor(), BORDER_THICKNESS));

		
		JTextArea answerText = new JTextArea (myQuestion.getAnswer());	
		answerText.setFont(FONT);
		answerText.setForeground(FONT_COLOR);
		answerText.setBackground(ANSWER_COLOR); // here. 
		answerText.setSize(TEXT_DIMENSION);
		answerText.setLineWrap(true);
		
		answerText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
	
		
		
		JButton questionMarkButton = new JButton ("To Question");
		questionMarkButton.setPreferredSize(new Dimension (TEXT_DIMENSION.width, 80));
		questionMarkButton.setForeground(Color.DARK_GRAY);
		questionMarkButton.setForeground(currentTeam.getColor());

		questionMarkButton.addActionListener (new ActionListener(){
		
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("inside action listener for question mark");
				
				QuestionFrame qf = new QuestionFrame (myQuestion, currentTeam, theGame);
				
				close();
			}
		});
		


		resultPanel.add(answerText, BorderLayout.CENTER);
		resultPanel.add(questionMarkButton, BorderLayout.PAGE_END);

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
	
	// public Tile (String q, String a, int v)
	
	public static void main(String args[]) {
		
		Question sampleQuestion = new Question ("this is the question", "this is the answer", 500);
		
		//AnswerFrame theFrame = new AnswerFrame (sampleQuestion);
		
	}
	
	
}
