/**
 * 
 */
package controller;

import model.Database;
import view.MainFrame;
import view.Tabs;

/**
 * @author Milana Todorovic ra3-2017
 * @author Ana Perisic ra1-2017
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

	/**
	 * Metoda koja u zavisnosti od izabranog taba poziva brisanje predmeta,
	 * studenta, ili profesora.
	 * 
	 * @param index - indeks stavke koju treba obrisati
	 */
	public void remove(int index, Tabs.TabNames tab) {
		switch (tab) {
		case PREDMETI:
			this.predmetiController.remove(index);
			break;
		case PROFESORI:
			this.profesoriController.remove(index);
			break;
		case STUDENTI:
			this.studentiController.remove(index);
			break;
		default:
			break;
		}

		MainFrame.getInstance().rowDeletedInDipslayedTable(index);
	}

	/**
	 * @param index
	 */
	public void removeXfromX(int innerIndex) {
		int outerIndex = MainFrame.getInstance().getSelectedRow();
		
		switch (MainFrame.getInstance().getSelectedTab()) {
		case PREDMETI:
			// TODO dodati kada bude implementirana funkcionalnost #uklanjanje_studenta_sa_predmeta
			break;
		case PROFESORI:
			Database.getInstance().removeProfesorPredmet(outerIndex, innerIndex);
			break;
		case STUDENTI:
			// TODO dodati kada bude implementirana funkcionalnost #uklanjanje_studenta_sa_predmeta
			break;
		default:
			break;
		}
	}

}
