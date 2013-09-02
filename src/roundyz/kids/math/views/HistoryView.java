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

public class HistoryView extends JFrame 
{


	private static final long serialVersionUID = -4566723338357353993L;
	QuestionHistory history;
	Font smallFont = new Font("Verdana", Font.PLAIN,25);
	

	public HistoryView(QuestionHistory history) 
	{
		this.history = history;
		this.setup();
	}


	public void refreshBoxes() 
	{
  		this.repaint();
	}


	public void setup() 
	{
		int windowWidth = 300;
		int windowHeight = 210;
		this.setSize(windowWidth, windowHeight);
		/*
			1 | x | 2 | ANSWER | Attempt 1 | Attempt 2 | Attempt 3
			------------------------------------------------------
			                     exit
		*/
		
		GridLayout layout = new GridLayout(1, 1);
		this.setLayout(layout);
		this.add(this.getTable());		
		this.repaint();
	}


	private MouseListener getRandomQuestionListener(final DefaultView view) 
	{
		return new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				view.refreshBoxes();
			}
		};
	}

	public JButton getButton(String label) 
	{
		JButton j = new JButton(label);
		j.setBackground(Color.gray);
		j.setForeground(Color.white);
		j.setFont(this.smallFont);
		return j;
	}


	private JTable getTable()
	{
		String[][] data = new String[10][10];
		String[] columns = {
			"firstnumber",
			"operator",
			"secondnumber",
			"answer",
			"attempt",
			"guess"
		};
		int count = 0;
		for (Question question: this.history.getQuestions()) {
			data[count] = question.toArray();
		}
		JTable table = new JTable(data, columns);
		return table;
	}


}
