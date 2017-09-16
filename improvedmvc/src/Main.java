

import controller.Controller;
import model.Model;
import view.View;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model mModel = new Model();
		View mView = new View(mModel);
		new Controller(mModel, mView);
	}

}
