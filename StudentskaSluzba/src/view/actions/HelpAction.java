/**
 * 
 */
package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import view.dialogs.HelpDialog;

/**
 * @author Ana Perisic ra1-2017
 *
 */
public class HelpAction extends AbstractAction {

	private static final long serialVersionUID = -5972506427913665080L;

	public HelpAction() {
		putValue(NAME, "Pomo\u0107");
		putValue(MNEMONIC_KEY, KeyEvent.VK_P);
		putValue(SMALL_ICON, new ImageIcon("resource/help.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		@SuppressWarnings("unused")
		HelpDialog helpDialog = new HelpDialog();

	}

}
