package Jeopardy.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Jeopardy.common.Board;

public class TilesPanel extends JPanel 
{

	public static final int WINDOW_WIDTH = 1000;

	public static final int WINDOW_HEIGHT = 800;
	public static final Dimension DIMENSION = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
	public static final Dimension TEXT_DIMENSION = new Dimension(WINDOW_WIDTH - 50, WINDOW_HEIGHT - 50);
	private static final Font FONT = new Font("TimesRoman", Font.PLAIN, 30);
	
	private Color tileColor;
	private Board myBoard;

	

	public TilesPanel(Board boardIn, Color tileColorIn)  {
		
		setLayout(new GridLayout(6, 5, 0, 0));

		myBoard = boardIn; 
		tileColor = tileColorIn;
		
		initComponents();
		createEvents();

	}

	private void initComponents() {

		setBackground(tileColor);
		this.setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		
		JTextArea categoriesText;
		String[] categories = myBoard.getCategories();

		for (int i = 0; i < categories.length; i++) {
			categoriesText = new JTextArea (categories[i]);
			categoriesText.setFont(FONT);
			categoriesText.setForeground(Color.white);
			categoriesText.setBackground (Color.blue);
			categoriesText.setBorder(new LineBorder(Color.DARK_GRAY));
			categoriesText.setLineWrap(true);
			categoriesText.setWrapStyleWord(true);
			
			//categoriesText.setBorder(new EmptyBorder(5, 5, 5, 5));
			//categoriesText.setHorizontalAlignment(SwingConstants.CENTER);
			//categoriesText.setVerticalAlignment(SwingConstants.BOTTOM);
			this.add(categoriesText);

		}

		Tile current;

		for (int c = 0; c < myBoard.getNumRows(); c++) // build each column
			for (int r = 0; r < myBoard.getNumCols(); r++) {
				current = myBoard.getTile(r, c);

				current.setMinimumSize(new Dimension(WINDOW_WIDTH / 5, WINDOW_HEIGHT / 6));
				current.setVerticalAlignment(SwingConstants.BOTTOM);
			
				this.add(current);

			}
	

	}

	private void createEvents() {
		// TODO Auto-generated method stub

	}

	
}


		

