package roundyz.kids.math;

import roundyz.kids.math.model.*;
import roundyz.kids.math.views.*;

public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Controller();
	}

	public Controller() {
		QuestionList questionList = new QuestionList();
		QuestionHistory history = new QuestionHistory();
		
		//window
		DefaultView window = new DefaultView(questionList, history);
		window.setVisible(true);
	}
	

}
