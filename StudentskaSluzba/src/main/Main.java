/**
 * 
 */
package main;

import controller.MainController;
import model.Database;
import view.MainFrame;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Database.getInstance();
		MainController.getInstance();
		MainFrame.getInstance();
	}

}
