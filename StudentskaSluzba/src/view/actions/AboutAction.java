/**
 * 
 */
package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import view.dialogs.AboutDialog;

/**
 * @author Ana Perisic ra1-2017
 *
 */
public class AboutAction extends AbstractAction {

	private static final long serialVersionUID = -5691929077253535134L;

	public AboutAction() {
		putValue(NAME, "Opis");
		putValue(MNEMONIC_KEY, KeyEvent.VK_O);
		putValue(SMALL_ICON, new ImageIcon("resource/about.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		@SuppressWarnings("unused")
		AboutDialog aboutDialog = new AboutDialog();

	}

}
