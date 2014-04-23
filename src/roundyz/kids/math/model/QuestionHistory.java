package roundyz.kids.math.model;

import java.util.Vector;

public class QuestionHistory extends QuestionList
{

	protected int historyLimit;


	public QuestionHistory()
	{
		this.setQuestions(new Vector<Question>());
		this.setPointer(0);
		this.pointerlimit = this.questions.size();
		this.historyLimit = 10;
	}


	public void addToList(Question question)
	{
		this.questions.add(question);
		if (this.questions.size() >= this.historyLimit) {
			// this may be 0
			this.questions.remove(1);
		}
	}


}
