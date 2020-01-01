/**
 * 
 */
package view.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import controller.MainController;
import view.MainFrame;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class ProfessorSubjectRemoveAction extends AbstractAction {

	private static final long serialVersionUID = 4630245379533474215L;

	public ProfessorSubjectRemoveAction() {
		putValue(NAME, "Ukloni profesora sa predmeta");
		putValue(SHORT_DESCRIPTION, "Ukloni profesora sa predmeta (Ctrl+R)");
		putValue(SMALL_ICON, new ImageIcon("resource/profesor_uklanjanje.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int predmet = MainFrame.getInstance().getSelectedRow();

		if (predmet == -1) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(),
					"Nije izabran predmet sa kog treba ukloniti profesora!", "Gre\u0161ka!", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (MainController.getInstance().getPredmetiController().getPredmet(predmet).getProfesor() == null) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izabrani predmet nema profesora.",
					"Uklanjanje profesora sa predmeta", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		int choice = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
				"Da li ste sigurni da \u017Eelite da uklonite profesora sa predmeta?",
				"Uklanjanje profesora sa predmeta", JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			MainController.getInstance().getPredmetiController().ukloniProfesoraSaPredmeta(predmet);
		}

	}

}
