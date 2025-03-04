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

		MainFrame.getInstance().getTableModel().fireTableRowsDeleted(index, index);
	}

	/**
	 * Metoda koja u zavisnosti izabranog taba poziva brisanje veza izmedju predmeta
	 * i studenta ili predmeta i profesora. Brisanje se pokrece iz dijaloga koji
	 * prikazuje postojece veze.
	 * 
	 * @param index
	 */
	public void removeXfromX(int innerIndex) {
		int outerIndex = MainFrame.getInstance().getSelectedRow();

		switch (MainFrame.getInstance().getSelectedTab()) {
		case PREDMETI:
			Database.getInstance().removePredmetStudent(outerIndex, innerIndex);
			// zbog kolone broj studenta u tabeli predmeta
			MainFrame.getInstance().cancelSearch();
			MainFrame.getInstance().getTableModel().fireTableDataChanged();
			MainFrame.getInstance().setSelectedRow(outerIndex);
			break;
		case PROFESORI:
			Database.getInstance().removeProfesorPredmet(outerIndex, innerIndex);
			break;
		case STUDENTI:
			Database.getInstance().removeStudentPredmet(outerIndex, innerIndex);
			break;
		default:
			break;
		}
	}

	/**
	 * Metoda koja dijalogu za izmenu prosledjuje objekat koji treba izmeniti. U
	 * zavisnosti od izabranog taba poziva odgovarajuci dijalog.
	 * 
	 * @param selected - indeks stavke koju treba izmeniti
	 */
	public void launchEdit(int index) {
		switch (MainFrame.getInstance().getSelectedTab()) {
		case PREDMETI:
			MainFrame.getInstance().getDialogHandler().launchPredmetiEdit(predmetiController.getPredmet(index));
			break;
		case PROFESORI:
			MainFrame.getInstance().getDialogHandler().launchProfesoriEdit(profesoriController.getProfesor(index));
			break;
		case STUDENTI:
			MainFrame.getInstance().getDialogHandler().launchStudentiEdit(studentiController.getStudent(index));
			break;
		default:
			break;
		}
	}

	/**
	 * Metoda koja u zavisnosti od izabranog taba pokrece pretragu tacne tabele.
	 * 
	 * @param searchParam - parametri kombinovane pretrage
	 */
	public void startSearch(String searchParam) {
		if (searchParam.isEmpty()) {
			MainFrame.getInstance().getRowSorter().setRowFilter(null);
			return;
		}

		switch (MainFrame.getInstance().getSelectedTab()) {
		case PREDMETI:
			this.predmetiController.startSearch(searchParam);
			break;
		case PROFESORI:
			this.profesoriController.startSearch(searchParam);
			break;
		case STUDENTI:
			this.studentiController.startSearch(searchParam);
			break;
		default:
			break;
		}
	}

	/**
	 * Metoda koja vraca tabelu u pocetno stanje kada korisnik zavrsi pretragu.
	 * 
	 */
	public void cancelSearch() {
		MainFrame.getInstance().getRowSorter().setRowFilter(null);
	}
	
	public boolean saveDatabase() {
		return Database.getInstance().saveState();
	}

}
