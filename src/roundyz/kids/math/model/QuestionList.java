package roundyz.kids.math.model;

import java.util.Random;
import java.util.Vector;

public class QuestionList 
{

    protected Vector<Question> questions;
    protected int pointer;
    protected int pointerlimit;
    
    
    public Question getRandom()
	{
        Random randomGenerator = new Random();
        int random = randomGenerator.nextInt(this.pointerlimit);
        this.setPointer(random);
        return this.getCurrent();
    }

    private void setupQuestionList(Vector<Integer> justTheseTimesTables) 
    {
        if (justTheseTimesTables.size() >=1) {
            for (int i=1; i<=12;i++) {
                for (int z: justTheseTimesTables) {
                    int answer = i * z;
                    this.questions.add(new Question(i, z, answer, '*'));
                }
            }
        } else {
            //use a default
            for (int i=1;i<=12;i++){
                for (int z = 1; z <= 12; z++) {
                    int answer = i * z;
                    this.questions.add(new Question(i, z, answer, '*'));
                }
            }
        }
    }


	public QuestionList() {
	}

    public QuestionList(Vector<Integer> justTheseTimesTables) {
        this.setQuestions(new Vector<Question>());
        this.setupQuestionList(justTheseTimesTables);
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
