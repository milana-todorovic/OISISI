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
	private ProfesoriController profesoriController;
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
		// TODO instancirati kontroler za studente kada bude implementirana
		// funkcionalnost #student
		this.profesoriController = new ProfesoriController();
		this.predmetiController = new PredmetiController();
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

}
