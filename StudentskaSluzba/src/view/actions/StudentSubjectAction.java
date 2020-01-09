package view.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import controller.MainController;
import view.MainFrame;

/**
 * 
 * @author Ana Perisic ra1-2017
 *
 */
public class StudentSubjectAction extends AbstractAction {

	private static final long serialVersionUID = 5664642698304087503L;

	public StudentSubjectAction() {
		putValue(NAME, "Dodaj studenta na predmet");
		putValue(SHORT_DESCRIPTION, "Dodaj studenta na predmet (Ctrl+S)");
		putValue(SMALL_ICON, new ImageIcon("resource/student.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int predmet = MainFrame.getInstance().getSelectedRow();
		if (predmet == -1) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(),
					"Nije izabran predmet na koji treba dodati studenta!", "Gre\u0161ka!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		MainController.getInstance().getPredmetiController().launchDodavanjeStudentaNaPredmet(predmet);

	}

}
