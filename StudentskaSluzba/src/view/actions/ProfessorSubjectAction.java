/**
 * 
 */
package view.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import view.MainFrame;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class ProfessorSubjectAction extends AbstractAction {

	private static final long serialVersionUID = -58116647230194991L;

	public ProfessorSubjectAction() {
		putValue(NAME, "Dodaj profesora na predmet");
		putValue(SHORT_DESCRIPTION, "Dodaj profesora na predmet (Ctrl+P)");
		putValue(SMALL_ICON, new ImageIcon("resource/profesor.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (MainFrame.getInstance().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(),
					"Nije izabran predmet na koji treba dodati profesora!", "Gre\u0161ka!", JOptionPane.ERROR_MESSAGE);
			return;
		}

		/*
		 * TODO dodati tijelo kada bude implementirana funkcionalnost
		 * #dodavanje_profesora_na_predmet
		 */
	}

}
