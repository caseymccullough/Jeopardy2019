package Jeopardy.views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import Jeopardy.common.FinalJeopardyQuestion;
import Jeopardy.common.JeopardyGame;
import Jeopardy.common.Question;
import Jeopardy.common.Team;

import java.awt.FlowLayout;
import java.awt.Font;

public class ScoreBoardPanel extends JPanel {

	private static final Font FONT = new Font("Monaco", Font.PLAIN, 24);

	private JLabel [] teamLabels;
	private Team[] myTeams;
	private JeopardyGraphics theGame;
	private FinalJeopardyTile finalJeopardyTile;
	 
	public ScoreBoardPanel(JeopardyGraphics gameIn) 
	{
		
		
		
		theGame = gameIn;
		
		myTeams = theGame.getTeams();
		
		setBorder(new LineBorder(new Color(0, 0, 0), 5));
		this.setBackground(Color.yellow);
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblJeopardy = new JLabel("Jeopardy");
		lblJeopardy.setFont(FONT);
		add(lblJeopardy);
		
		
		teamLabels = new JLabel [myTeams.length]; // one extra used for current team
		for (int j = 0; j < myTeams.length; j++)
		{
			teamLabels[j] = new JLabel("    " + myTeams[j].toString());
			teamLabels[j].setForeground((myTeams[j].getColor()));
			teamLabels[j].setFont(FONT);
			add(teamLabels[j]);
			
			
		}
		
		Team current = theGame.getCurrentTeam();
		
		JLabel currentTeamLabel = new JLabel ("    Current Team : " + current.getName());
		 
		currentTeamLabel.setForeground(current.getColor());
		currentTeamLabel.setFont(FONT);
		add(currentTeamLabel);
		
		FinalJeopardyQuestion tempFJQuestion = new FinalJeopardyQuestion ("Science", "Most common constituent of atmosphere", "What is N2");
		
		finalJeopardyTile = new FinalJeopardyTile (tempFJQuestion, theGame);
		
		add(finalJeopardyTile);
		
		

	}
	
	public String toString ()
	{
		
		String result = "";
		for (Team t: myTeams)
		{
			result += t + "  ";
		}
		return result;
	}
	


}
