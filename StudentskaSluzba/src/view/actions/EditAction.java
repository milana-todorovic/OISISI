/**
 * 
 */
package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import view.MainFrame;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class EditAction extends AbstractAction {

	private static final long serialVersionUID = -5882406906480829694L;

	public EditAction() {
		/*
		 * TODO izabrati naziv i mnemonik kada bude implementirana funkcionalnost
		 * #menu_bar
		 */
		// putValue(NAME, "Izmeni");
		// putValue(MNEMONIC_KEY, KeyEvent.VK_I);
		putValue(SHORT_DESCRIPTION, "Izmeni (Ctrl+E)");
		putValue(SMALL_ICON, new ImageIcon("resource/edit.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (MainFrame.getInstance().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Nije izabrana stavka za izmenu!", "Gre\u0161ka!",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// TODO u kontroler?
		switch (MainFrame.getInstance().getSelectedTab()) {
		case STUDENTI:
			// TODO dodati kada bude implementirana funkcionalnost izmena_studenta
			break;
		case PROFESORI:
			// TODO dodati kada bude implementirana funkcionalnost izmena_profesora
			break;
		case PREDMETI:
			// TODO dodati kada bude implementirana funkcionalnost izmena_predmeta
			break;
		}
	}

}
