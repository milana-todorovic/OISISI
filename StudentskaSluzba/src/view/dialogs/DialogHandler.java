/**
 * 
 */
package view.dialogs;

import java.util.List;

import javax.swing.JFrame;

import model.Predmet;
import model.Student;
import view.Tabs;
import view.dialogs.dodavanjeProfesoraNaPredmet.ProfesorPredmetDialog;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class DialogHandler {

	private ListDialog listDialog;
	private PredmetDialog predmetDialog;
	private ProfesorPredmetDialog profesorPredmetDialog;
	private StudentDialog studentDialog;

	/**
	 * Konstruktor koji instancira sve cesto koristene dijaloge.
	 * 
	 * @param parent
	 */
	public DialogHandler(JFrame parent) {
		super();

		this.listDialog = new ListDialog(parent);
		this.predmetDialog = new PredmetDialog(parent);
		this.profesorPredmetDialog = new ProfesorPredmetDialog(parent);
		this.studentDialog = new StudentDialog(parent);
	}

	/**
	 * Metoda koja otvara dijalog za prikaz listi.
	 * 
	 * @param title - naslov prozora
	 * @param value - lista koju treba prikazati
	 */
	public void showListDialog(String title, List<?> value) {
		listDialog.show(title, value);
	}

	/**
	 * U zavisnosti od trenutno izabranog taba otvara prozor za dodavanje profesora,
	 * predmeta, ili studenta.
	 * 
	 * @param tab
	 */
	public void launchAdd(Tabs.TabNames tab) {
		switch (tab) {
		case PREDMETI:
			predmetDialog.addMode();
			break;
		case PROFESORI:
			// TODO dodati kada bude implementirana funkcionalnost #dodavanje_profesora
			break;
		case STUDENTI:
			studentDialog.addMode();
			break;
		default:
			break;
		}
	}

	/**
	 * Metoda koja otvara prozor za izmenu predmeta.
	 * 
	 * @param predmet
	 */
	public void launchPredmetiEdit(Predmet predmet) {
		predmetDialog.editMode(predmet);
	}

	/**
	 * Metoda koja otvara prozor za dodavanje/imzenu profesora na predmetu.
	 * 
	 * @param profesorIndex
	 */
	public void launchProfesorNaPredmetuEdit(int profesorIndex) {
		profesorPredmetDialog.show(profesorIndex);
	}

	public void launchStudentiEdit(Student student) {
		studentDialog.editMode(student);
	}

}
