package Jeopardy.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Jeopardy.common.BoardInfo;
import Jeopardy.common.JeopardyGame;
import Jeopardy.common.Team;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class TeamFrame extends JFrame {

	public static final Color FRAME_COLOR = Color.blue;
	public static final Dimension DIMENSION = new Dimension(800, 600);
	private static final Font FONT = new Font("TimesRoman", Font.PLAIN, 30);
	private static final Color TEXT_COLOR = Color.green;
	private static final int MAX_TEAMS = 5;
	private static final Color [] TEAM_COLORS = {Color.MAGENTA, Color.GREEN, Color.CYAN, Color.RED, Color.YELLOW};

	private static JTextField[] teamNames;
	private Team[] theTeams;
	private JeopardyGame theGame;
	
	private BoardInfo bInfo;
	
	private JeopardyGraphics jg ;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamFrame frame = new TeamFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public TeamFrame(JeopardyGame gameIn, BoardInfo bInfoIn ) {

		super("Team Registration");
		
		theGame = gameIn;
		bInfo = bInfoIn;
		
		getContentPane().setBackground(Color.BLUE);
		initComponents();
		createEvents();

	}

	private void initComponents() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(FRAME_COLOR);
		setPreferredSize(DIMENSION);
		setMinimumSize(DIMENSION);
		getContentPane().setLayout(new FlowLayout());

		teamNames = new JTextField[MAX_TEAMS];
		// theTeams = theTeamsIn;

		JPanel textFields = new JPanel();
		textFields.setBackground(Color.BLUE);
		textFields.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		GridLayout layout = new GridLayout(5, 1);
		textFields.setLayout(layout);

		for (int j = 0; j < MAX_TEAMS; j++) {
			teamNames[j] = new JTextField(20);
			teamNames[j].setBackground(TEAM_COLORS[j]);
		

			JLabel label = new JLabel("Team #  " + (j + 1));
			label.setForeground(TEAM_COLORS[j]);
			label.setFont(FONT);

			teamNames[j].setVisible(true);
			textFields.add(label);
			textFields.add(teamNames[j]);


		}

		JPanel buttons = new JPanel();
		buttons.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		buttons.setVisible(true);
		textFields.setVisible(true);

		JLabel label = new JLabel("Please enter each team name");
		label.setFont(FONT);
		label.setForeground(Color.WHITE);

		getContentPane().add(label);

		getContentPane().add(textFields);
		getContentPane().add(buttons);
		
				JButton done = new JButton("Done");
				buttons.add(done);
				done.setMinimumSize(DIMENSION);
				done.setVisible(true);
				
						done.addActionListener(new ActionListener() {
				
							public void actionPerformed(ActionEvent e) {
				
								// gets text input
								// generates array of Teams
								generateTeams();
								theGame.setTheTeams(getTheTeams());
								System.out.println("TEST");
								makeFrame();

							}
						});

		this.pack();
		this.setVisible(true);


	}

	public void generateTeams()

	// gets text input
	// generates array of Teams
	{
		System.out.println("in generateTeams()");
		int numNames = 0;

		for (int i = 0; i < teamNames.length; i++) {
			if (teamNames[i].getText() != null && !(teamNames[i].getText().equals("")))
				numNames++;
		}
		theTeams = new Team[numNames];
		Team currentTeam;
		int currentPos = 0;
		for (int i = 0; i < teamNames.length; i++) {
			if (teamNames[i].getText() != null && !(teamNames[i].getText().equals(""))) {
				currentTeam = new Team(teamNames[i].getText());
				theTeams[currentPos] = currentTeam;
				System.out.println("adding " + currentTeam + " at position " + currentPos);
				currentPos++;
			}

		}
		
		for (int i = 0; i < theTeams.length; i++)
		{
			System.out.println(theTeams[i]);
		}

	}

	public Team[] getTheTeams() {

		System.out.println("in getTheTeams");
		// System.out.println (theTeams);
		return theTeams;
	}

	public void close() {

		this.setVisible(false);

		System.out.println("in close() for IntroFrame");

	}

	private void createEvents() {
		// TODO Auto-generated method stub

	}
	
	public void makeFrame()
	{
		jg = new JeopardyGraphics(theTeams, bInfo);
		jg.setVisible(true);
		this.close();
	}

}
