package Jeopardy.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Jeopardy.common.FinalJeopardyQuestion;
import Jeopardy.common.Team;

public class FinalJeopardyFrame extends JFrame {
	
	public static final Color ANSWER_COLOR = Color.BLUE;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static final int WINDOW_WIDTH = (int) screenSize.getWidth();
	public static final int WINDOW_HEIGHT = (int) screenSize.getHeight() - 50;
	
	public static final Dimension DIMENSION = new Dimension (WINDOW_WIDTH, WINDOW_HEIGHT - 50);
	public static final Dimension TEXT_DIMENSION = new Dimension (WINDOW_WIDTH - 50, WINDOW_HEIGHT - 50);
	
	private static final Font FONT = new Font("Helvetica Bold", Font.PLAIN, 90);
	private static final Color FONT_COLOR = Color.WHITE;
	
	private static final int BORDER_THICKNESS = 5; 
	
	public FinalJeopardyFrame (FinalJeopardyQuestion fjQuestion, Team[] theTeams)
	{
		super ("Final Jeopardy!");
		this.setLayout(new BorderLayout(5, 5));
		this.setForeground(ANSWER_COLOR);
		this.setPreferredSize(DIMENSION);
		this.setMinimumSize(DIMENSION);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JPanel categoryPanel = new JPanel();
		
		JTextArea categoryText = new JTextArea ("Final Jeopardy Category: \n\n" + fjQuestion.getCategory());	
		categoryText.setFont(FONT);
		categoryText.setForeground(FONT_COLOR);
		categoryText.setBackground(ANSWER_COLOR); // here. 
		categoryText.setSize(TEXT_DIMENSION);
		categoryText.setLineWrap(true);
		categoryText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		categoryPanel.add(categoryText);
		
		this.add(categoryPanel);
		this.pack();
		this.setVisible(true);
		
	}

}
