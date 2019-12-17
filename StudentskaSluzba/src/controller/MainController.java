/**
 * 
 */
package controller;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class MainController {

	private static MainController instance;
	
	private ProfesoriController profesoriController;
	private PredmetiController predmetiController;
	private StudentiController studentiController;

	/**
	 * @return the instance
	 */
	public static MainController getInstance() {
		if (instance == null) {
			instance = new MainController();
		}

		return instance;
	}

	private MainController() {

		this.profesoriController = new ProfesoriController();
		this.predmetiController = new PredmetiController();
		this.studentiController = new StudentiController();

	}

	/**
	 * @return the predmetiController
	 */
	public PredmetiController getPredmetiController() {
		return predmetiController;
	}

	/**
	 * @return the profesoriController
	 */
	public ProfesoriController getProfesoriController() {
		return profesoriController;
	}
	/**
	 * @return the studentiController
	 */
	public StudentiController getStudentiController() {
		return studentiController;
	}

}
