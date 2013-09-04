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
		
		GridLayout layout = new GridLayout(2, 1);
		this.setLayout(layout);
		this.add(this.getTable());		

		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.gray);
		exitButton.setForeground(Color.white);
		exitButton.addMouseListener(this.getExitMouseListener(this) );

		this.add(exitButton);		

		this.repaint();
	}


		private MouseListener getExitMouseListener(final HistoryView view) {
			return new MouseListener() {
				public void mouseClicked(MouseEvent arg0) {
					view.dispose();
				}
			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			};

		}

	private JTable getTable()
	{
		String[][] data = new String[10][6];
		String[] columns = {
			"firstnumber",
			"operator",
			"secondnumber",
			"answer",
			"attempt",
			"guess"
		};
		int count = 1;
		data[0] = columns;
		for (Question question: this.history.getQuestions()) {
			data[count] = question.toArray();
			count++;
		}
		JTable table = new JTable(data, columns);
		return table;
	}


}
