/**
 * 
 */
package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import view.MainFrame;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class NewAction extends AbstractAction {

	private static final long serialVersionUID = -8152983303057846936L;

	public NewAction() {
		putValue(NAME, "Dodaj");
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
		putValue(SHORT_DESCRIPTION, "Dodaj (Ctrl+N)");
		putValue(SMALL_ICON, new ImageIcon("resource/new.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
	}

	/**
	 * U zavisnosti od trenutno selektovanog taba otvara dijalog za dodavanje
	 * studenta, predmeta, ili profesora.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.getInstance().launchAdd();
	}

}
