package roundyz.kids.math.model;

public class Question 
{

	private int firstNumber;
	private int guess;
	private int secondNumber;
	private int answer;
	private char operator;
	private int tries=3;
	private int attempt=1;
	public boolean wasCorrect;


	public int getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}

	public int getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public char getOperator() {
		return operator;
	}

	public void setOperator(char operator) {
		this.operator = operator;
	}

	public int getTries() {
		return tries;
	}

	public void setTries(int tries) {
		this.tries = tries;
	}

	public int getAttempt() {
		return attempt;
	}

	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}

	public Question(int firstNumber, int secondNumber, int answer, char operator) {
		this.setFirstNumber(firstNumber);
		this.setSecondNumber(secondNumber);
		this.setAnswer(answer);
		this.setOperator(operator);
	}

	public boolean checkAnswer() {
		return  this.guess == this.answer;
	}

	public void setGuess(int guess) {
		this.guess = guess;
	}

	public int getGuess() {
		return guess;
	}

	public String[] toArray()
	{
		String[] ret = new String[6];
		ret[0] = Integer.toString(firstNumber);	
		ret[1] = Character.toString(operator);	
		ret[2] = Integer.toString(secondNumber);	
		ret[3] = Integer.toString(answer);	
		ret[4] = Integer.toString(guess);	
		ret[5] = wasCorrect?"Y":"N";	
		return ret;
	}

}
