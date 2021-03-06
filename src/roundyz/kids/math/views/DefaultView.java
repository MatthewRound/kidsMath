package roundyz.kids.math.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import roundyz.kids.math.model.Question;
import roundyz.kids.math.model.QuestionList;
import roundyz.kids.math.model.QuestionHistory;
import roundyz.kids.math.views.*;

public class DefaultView extends JFrame 
{


	//test
	private static final long serialVersionUID = -4866723338357353993L;
	QuestionList questionList;

	int windowWidth = 300;
	int windowHeight = 210;

	//TODO show history
	QuestionHistory history;
	Question question;
	Font bigFont = new Font("Verdana", Font.BOLD, 50);
	HistoryView historyView;

	Font smallFont = new Font("Verdana", Font.PLAIN,25);
	JTextField guessAnswer = new JTextField();
	JTextField firstNumber = new JTextField();
	JTextField operator = new JTextField();
	JTextField secondNumber = new JTextField();
	
	
	public DefaultView(QuestionList questionList, QuestionHistory history) 
	{
		this.questionList = questionList;
		this.history = history;
		this.setup();
	}


	public void refreshBoxes() 
	{
		guessAnswer.setBackground(Color.white);
		guessAnswer.setText("");
		guessAnswer.setFont(this.bigFont);
		guessAnswer.setAlignmentX(CENTER_ALIGNMENT);
		guessAnswer.setAlignmentY(CENTER_ALIGNMENT);
		guessAnswer.setHorizontalAlignment(JTextField.RIGHT);
		firstNumber.setText(String.valueOf(this.question.getFirstNumber()));
		firstNumber.setFont(this.bigFont);
		firstNumber.setHorizontalAlignment(JTextField.RIGHT);
		secondNumber.setText(String.valueOf(this.question.getSecondNumber()));
		secondNumber.setFont(this.bigFont);
		secondNumber.setHorizontalAlignment(JTextField.RIGHT);
		operator.setText(String.valueOf(this.question.getOperator()));
		operator.setFont(this.bigFont);
		operator.setHorizontalAlignment(JTextField.RIGHT);
  		this.repaint();
	}


	public void setup() 
	{
		this.question = this.questionList.getCurrent();
		this.setSize(windowWidth, windowHeight);
		GridLayout layout = new GridLayout(5, 2);
		this.setLayout(layout);
		guessAnswer.setVisible(true);
		firstNumber.setEditable(false);
		secondNumber.setEditable(false);
		operator.setEditable(false);

		this.refreshBoxes();

		// buttons
		JButton showAnswer = this.getButton("=");
		showAnswer.addMouseListener(this.getShowAnswerListener(this));

		JButton exit = this.getButton("Exit");
		exit.addMouseListener(this.getExitListener());

		JButton nextQuestion = this.getButton("next");
		nextQuestion.addMouseListener(this.getNextQuestionListener(this));

		JButton random = this.getButton("Any");
		random.addMouseListener(this.getRandomQuestionListener(this));
		
		JButton lastQuestion = this.getButton("last");
		lastQuestion.addMouseListener(this.getLastQuestionListener(this));

		JButton showHistory = this.getButton("Score");
		showHistory.addMouseListener(this.getShowHistoryListener(this));
		
		this.add(lastQuestion);
		this.add(nextQuestion);

		this.add(random);
		this.add(firstNumber);

		this.add(operator);
		this.add(secondNumber);

		this.add(showAnswer);
		this.add(guessAnswer);
		
		this.add(exit);
		this.add(showHistory);
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
				view.question = view.questionList.getRandom();
				view.refreshBoxes();
			}
		};
	}


	private MouseListener getLastQuestionListener(final DefaultView view) 
	{
		return new MouseListener() {

			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
				view.question = view.questionList.getPrevious();
				view.refreshBoxes();

			}
		};
	}


	public Question getQuestion() 
	{
		return question;
	}


	public void setQuestion(Question question) 
	{
		this.question = question;
	}


	private MouseListener getNextQuestionListener(final DefaultView view) 
	{

		return new MouseListener() {

			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
				view.question = view.questionList.getNext();
				view.refreshBoxes();
			}
		};

	}


	private MouseListener getExitListener() 
	{
		return new MouseListener() {

			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}

			public void mouseEntered(MouseEvent arg0) {
			}
		};
	}


	private MouseListener getShowAnswerListener(final DefaultView view) 
	{
		return new MouseListener() {

			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
				String answer = view.guessAnswer.getText().trim();
				String message;
				int guess = 0;
				try {
					guess = Integer.parseInt(answer);
				} catch (Exception e) {
					message = "You need to type an number first";
					view.guessAnswer.setBackground(Color.orange);
					System.out.println("error:"+ e.getMessage());
				}
				view.question.setGuess(guess);
				String format = "Wrong! \nAnswer was %s, you said %s!";
				view.guessAnswer.setBackground(Color.red);
				view.question.wasCorrect = false;
				int attempt = view.question.getAttempt()!=0?view.question.getAttempt():1;
				if (view.question.checkAnswer()) {
					format = "Well done! %s = %s.";
					view.question.wasCorrect = true;
					view.guessAnswer.setBackground(Color.green);
				} else {
 					view.question.setAttempt(attempt++); 
					if (view.question.getAttempt() >= question.getTries()) {
						format = "You tried too many times. Answer was %s, last attempt was %s";
					}
				}
				if (view.question != null) {
					System.out.println(view.question.getAnswer());
					history.addToList(view.question); 
				}
				System.out.println(history.getQuestions().size());
				message = String.format(format, view.question.getAnswer(),
						view.question.getGuess());

				JOptionPane.showMessageDialog(view, message);
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


	private MouseListener getShowHistoryListener(final DefaultView view) 
	{
		return new MouseListener() {

			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
				//TODO add current location here
				view.historyView = new HistoryView(view.history, view.windowWidth, view.windowHeight);
				view.historyView.setVisible(true);
			}

			public void mouseEntered(MouseEvent arg0) {
			}
		};
	}

}
