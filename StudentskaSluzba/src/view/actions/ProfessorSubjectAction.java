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
public class ProfessorSubjectAction extends AbstractAction {

	private static final long serialVersionUID = -58116647230194991L;

	public ProfessorSubjectAction() {
		putValue(NAME, "Izmeni profesora na predmetu");
		putValue(SHORT_DESCRIPTION, "Izmeni profesora na predmetu (Ctrl+P)");
		putValue(SMALL_ICON, new ImageIcon("resource/profesor.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int predmet = MainFrame.getInstance().getSelectedRow();

		if (predmet == -1) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(),
					"Nije izabran predmet na kom treba izmeniti profesora!", "Gre\u0161ka!", JOptionPane.ERROR_MESSAGE);
			return;
		}

		MainController.getInstance().getPredmetiController().launchProfesorNaPredmetuEdit(predmet);
	}

}
