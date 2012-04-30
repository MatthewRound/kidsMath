package roundyz.kids.math;

import roundyz.kids.math.model.*;

public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Controller();
	}

	public Controller() {
		QuestionList questionList = new QuestionList();
		
		//window
		View window = new View(questionList);
		window.setVisible(true);
	}
	

}
