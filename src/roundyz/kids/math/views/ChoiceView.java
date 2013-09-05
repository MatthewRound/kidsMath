package roundyz.kids.math.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import roundyz.kids.math.model.Question;
import roundyz.kids.math.model.QuestionList;
import roundyz.kids.math.model.QuestionHistory;

public class ChoiceView extends JFrame 
{
	private static final long serialVersionUID = -4566723338357358993L;

	public ChoiceView() 
	{
		this.setup();
	}


	public void setup() 
	{
		int windowWidth = 300;
		int windowHeight = 210;
		this.setSize(windowWidth, windowHeight);
		/*
			
		*/
		
		GridLayout layout = new GridLayout(2, 1);
		this.setLayout(layout);

}

