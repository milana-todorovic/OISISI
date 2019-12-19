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

import controller.MainController;
import view.MainFrame;
import view.Tabs;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class DeleteAction extends AbstractAction {

	private static final long serialVersionUID = -4037794738047100642L;

	public DeleteAction() {
		putValue(NAME, "Obri\u0161i");
		putValue(MNEMONIC_KEY, KeyEvent.VK_O);
		putValue(SHORT_DESCRIPTION, "Obri\u0161i (Ctrl+D)");
		putValue(SMALL_ICON, new ImageIcon("resource/delete.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Tabs.TabNames tab = MainFrame.getInstance().getSelectedTab();
		String item = tab.toString().toLowerCase();
		item = item.substring(0, item.length() - 1);

		if (MainFrame.getInstance().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Nije izabran " + item + " za brisanje!",
					"Gre\u0161ka!", JOptionPane.ERROR_MESSAGE);
			return;
		}

		int choice = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
				"Da li ste sigurni da \u017Eelite da potvrdite brisanje izabranog " + item + "a?", "Potvrda brisanja",
				JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			MainController.getInstance().remove(MainFrame.getInstance().getSelectedRow(), tab);
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izabrani " + item + " je uspe\u0161no obrisan.",
					"Brisanje", JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
