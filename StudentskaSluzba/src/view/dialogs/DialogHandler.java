/**
 * 
 */
package view.dialogs;

import java.util.List;

import javax.swing.JFrame;

import model.Predmet;
import model.Profesor;
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
	private ProfesorDialog profesorDialog;

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
		this.profesorDialog = new ProfesorDialog(parent);
	}

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
			profesorDialog.addMode();
			break;
		case STUDENTI:
			studentDialog.addMode();
			break;
		default:
			break;
		}
	}

	public void launchPredmetiEdit(Predmet predmet) {
		predmetDialog.editMode(predmet);
	}

	public void launchProfesorNaPredmetuEdit(int index) {
		profesorPredmetDialog.show(index);
	}

	public void launchStudentiEdit(Student student) {
		studentDialog.editMode(student);
	}

	public void launchProfesoriEdit(Profesor profesor) {
		profesorDialog.editMode(profesor);
	}

}
