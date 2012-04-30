package roundyz.kids.math.model;

import java.util.Random;
import java.util.Vector;

public class QuestionList {

	private Vector<Question> questions;
	private int pointer;
	private int pointerlimit;
	
	
	public Question getRandom(){
		Random randomGenerator = new Random();
		int random = randomGenerator.nextInt(this.pointerlimit);
		this.setPointer(random);
		return this.getCurrent();
	}


	private void setupQuestionList() {

		for (int i=1;i<=12;i++){
			for (int z = 1; z <= 12; z++) {
				int answer = i * z;
				this.questions.add(new Question(i, z, answer, '*'));
			}
		}
		
		for (int i=1;i<=100;i++)
		{
			for (int z=1;z<=100;z++){
				int answer = z+i;
				this.questions.add(new Question(i, z, answer, '+'));
			}
		}
		
		for (int i=1;i<=100;i++)
		{
			for (int z=1;z<=100;z++){
				if (i>=z){
				int answer = i-z;
				this.questions.add(new Question(i, z, answer, '-'));
				}
			}
		}
		
		for (int i=1;i<=12;i++){
			for (int z = 1; z <= 12; z++) {
				
					int answer =  i/z;
					this.questions.add(new Question(i, z, answer,(char)248 ));
				
			}
		}
	}

	public QuestionList() {
		this.setQuestions(new Vector<Question>());
		this.setupQuestionList();
		this.setPointer(0);
		this.pointerlimit = this.questions.size();
	}

	public void setQuestions(Vector<Question> questions) {
		this.questions = questions;
	}

	public Vector<Question> getQuestions() {
		return this.questions;
	}

	public void setPointer(int pointer) {
		this.pointer = pointer;
	}

	public int getPointer() {
		return this.pointer;
	}

	public Question getFirst() {
		return this.questions.get(0);
	}

	public Question getNext() {
		if (this.getPointer() != this.pointerlimit) {
			this.setPointer(this.pointer + 1);
		} else {
			this.setPointer(0);
		}
		return this.getCurrent();
	}

	public Question getPrevious() {
		if (this.getPointer() != 0) {
			this.setPointer(this.pointer - 1);
		} else {
			this.setPointer(this.pointerlimit);
		}
		return this.getCurrent();
	}

	public Question getCurrent() {
		return this.getQuestions().get(this.getPointer());
	}

}
