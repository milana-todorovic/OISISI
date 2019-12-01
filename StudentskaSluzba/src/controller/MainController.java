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
	// TODO dodati kontroler za studente kada bude implementirana funkcionalnost
	// #student
	// TODO dodati kontroler za profesora kada bude implementirana funkcionalnost
	// #profesor
	private PredmetiController predmetiController;

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
		this.predmetiController = new PredmetiController();
	}

	/**
	 * @return the predmetiController
	 */
	public PredmetiController getPredmetiController() {
		return predmetiController;
	}

}
