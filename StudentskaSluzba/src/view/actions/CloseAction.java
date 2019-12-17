/**
 * 
 */
package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

/**
 * @author Ana Perisic ra1-2017
 *
 */
public class CloseAction extends AbstractAction {

	private static final long serialVersionUID = -6551476711480419837L;

	public CloseAction() {
		putValue(NAME, "Zatvori");
		putValue(MNEMONIC_KEY, KeyEvent.VK_Z);
		putValue(SMALL_ICON, new ImageIcon("resource/cancel.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO dodati kada bude implementirana serijalizacija

	}

}
