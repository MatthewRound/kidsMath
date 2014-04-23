package roundyz.kids.math;

import java.util.Vector;
import roundyz.kids.math.model.*;
import roundyz.kids.math.views.*;

public class Controller 
{


	Vector<Integer> onlyTimesTables;


	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Controller controller = new Controller();
		controller.onlyTimesTables = new Vector<Integer>();
		for(String arg:args) {
			controller.onlyTimesTables.add(Integer.parseInt(arg));
		}
		controller.go();
	}


	public Controller() 
	{
	}


	public void go() 
	{
		QuestionList questionList = new QuestionList(this.onlyTimesTables);
		QuestionHistory history = new QuestionHistory();
		DefaultView window = new DefaultView(questionList, history);
		window.setVisible(true);
	}
	

}
